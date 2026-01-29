package dev.matthy.chemistryformula.calculate;

import dev.matthy.chemistryformula.ChemistryFormulaMod;
import dev.matthy.chemistryformula.api.ChemistryCompound;
import dev.matthy.chemistryformula.api.ChemistryElement;
import dev.matthy.chemistryformula.compat.ShapedRecipeCompat;
import dev.matthy.chemistryformula.compat.ShapelessRecipeCompat;
import dev.matthy.chemistryformula.integration.CFMConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.item.Item;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.registry.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.function.BiFunction;

import static dev.matthy.chemistryformula.api.ChemistryCompound.El;
import static dev.matthy.chemistryformula.calculate.ProcessedRecipe.distinctByKey;
import static dev.matthy.chemistryformula.data.CompoundItems.calculatedItems;

public class CraftingProcessor {
    public static Identifier getId(Item item) { // Get the item ID from Item class. Used for the keys in CompoundItems et al.
        return Registries.ITEM.getId(item);
    }
    public static ArrayList<Item> acceptableItems = new ArrayList<>();
    public static Class<?>[] allowedTypes = new Class[] {ShapedRecipe.class, ShapelessRecipe.class};
    public static HashMap<Class<?>, BiFunction<RecipeEntry<?>, MinecraftServer, ProcessedRecipe>> recipeProcessingCorrelations = new HashMap<>();
    public static void processTree(MinecraftServer server) {
        // Shaped recipes
        Set<Identifier> ids = calculatedItems.keySet();

        for(Identifier id : ids) {
            acceptableItems.add(Registries.ITEM.get(id));
        }
        server.getRecipeManager().values().stream()
                .filter((RecipeEntry<?> entry) -> Arrays.stream(allowedTypes).anyMatch((c) -> c.isInstance(entry.value())) ) // Get only allowed recipes
                .forEach(recipe -> {
                    ProcessedRecipe processedRecipe;
                    if(Arrays.asList(allowedTypes).contains(recipe.value().getClass())) processedRecipe = recipeProcessingCorrelations.get(recipe.value().getClass()).apply(recipe, server);
                    else { // Must be a subclass of one of allowedTypes
                        processedRecipe = recipeProcessingCorrelations.get(recipe.value().getClass().getSuperclass()).apply(recipe, server);
                    }
                    Identifier id = getId(processedRecipe.output); // Get the output item ID
                    if(calculatedItems.containsKey(id)) return; // If already calculated, exit this item iteration early
                    ChemistryCompound compound = ChemistryCompound.fromFormula(El(ChemistryElement.H, 0)); // Make empty ChemistryCompound
                    for(ChemistryCompound toAdd : processedRecipe.satisfactoryIngredients.stream().filter(distinctByKey(ChemistryCompound::toString)).toList()) compound.add(toAdd); // Combine all the unique ChemistryCompounds into 1 mixture
                    if(compound.isEmpty() || !processedRecipe.recipeFullyCalculable) return; // If the compound is empty, exit early
                    calculatedItems.put(id, compound); // Add to our database otherwise
                });
    }
    public static void addVanillaCorrelations() {
        recipeProcessingCorrelations.put(ShapedRecipe.class, ((entry, server) -> ShapedRecipeCompat.toProcessedRecipe((ShapedRecipe) entry.value(), server))); // Shaped recipes
        recipeProcessingCorrelations.put(ShapelessRecipe.class, ((entry, server) -> ShapelessRecipeCompat.toProcessedRecipe((ShapelessRecipe) entry.value(), server))); // Shapeless recipes
    }
    public static void deepInit(MinecraftServer server) {
        addVanillaCorrelations();

        int recipesComputed = 0;
        for(int i=0; i<AutoConfig.getConfigHolder(CFMConfig.class).getConfig().maxDepth; i++) { // We run processTree multiple times in order to get recipes nested more than 2 layers deep. For example, without this loop, wood planks would work (oak logs are already categorized), but sticks would not (oak logs are categorized but oak planks are not yet)
            processTree(server);
            ChemistryFormulaMod.LOGGER.info("depth=%d, %d items' compositions computed".formatted(i, calculatedItems.size())); // Log how many recipes have been calculated
            if(calculatedItems.size() > recipesComputed) recipesComputed = calculatedItems.size(); // If we've calculated more recipes total than last time, keep going
            else { // Otherwise, give up as there probably is no more layers of recipes to do. This also saves computational time by cutting it off early and not going to ultimateMaxDepth every time, which is a last-resort
                ChemistryFormulaMod.LOGGER.info("No additional recipes computed, stopping composition computation"); // Alert we've finished into log
                break; // Don't go again
            }
        }
    }
}
