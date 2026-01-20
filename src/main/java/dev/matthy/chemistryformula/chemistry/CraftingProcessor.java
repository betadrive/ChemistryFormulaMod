package dev.matthy.chemistryformula.chemistry;

import dev.matthy.chemistryformula.ChemistryFormulaMod;
import dev.matthy.chemistryformula.integration.CFMConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import static dev.matthy.chemistryformula.chemistry.ChemistryCompound.El;
import static dev.matthy.chemistryformula.data.CompoundItems.vanillaItems;

public class CraftingProcessor {
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) { // cr.: https://stackoverflow.com/q/23699371
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
    public static Identifier getId(Item item) {
        return Registries.ITEM.getId(item);
    }
    public static void processTree(MinecraftServer server) {
        // Shaped recipes
        Set<Identifier> ids = vanillaItems.keySet();
        ArrayList<Item> acceptableItems = new ArrayList<>();
        for(Identifier id : ids) {
            acceptableItems.add(Registries.ITEM.get(id));
        }
        server.getRecipeManager().values().stream()
                .filter((RecipeEntry<?> entry) -> entry.value() instanceof ShapedRecipe || entry.value() instanceof ShapelessRecipe) // Get only shaped recipes
                .map(recipe -> (CraftingRecipe) recipe.value())
                .forEach((CraftingRecipe recipe) -> {
                    int validSlots = 0; // Slots that aren't empty
                    ArrayList<ChemistryCompound> satisfactoryIngredients = new ArrayList<>(); // All ChemistryCompounds that could be calculated from their Ingredients
                    for (Ingredient ingredient : recipe.getIngredientPlacement().getIngredients()) { // Brute-force to see if any keys in our vanillaItems match a requirement
                        if(ingredient.isEmpty()) continue;
                        validSlots++;
                        for (Item item : acceptableItems) {
                            if (!ingredient.test(item.getDefaultStack())) continue;
                            satisfactoryIngredients.add(vanillaItems.get(getId(item)));
                            break;
                        }
                    }
                    if(satisfactoryIngredients.size() != validSlots) return; // If there were any items *without* formulas, then give up
                    ItemStack stack = recipe.craft(CraftingRecipeInput.EMPTY, server.getRegistryManager()); // Get the output item ItemStack
                    Identifier id = getId(stack.getItem()); // Get the output item ID
                    if(vanillaItems.containsKey(id)) return; // If already calculated, exit this item iteration early
                    ChemistryCompound compound = ChemistryCompound.fromFormula(El(ChemistryElement.H, 0)); // Make empty ChemistryCompound
                    for(ChemistryCompound toAdd : satisfactoryIngredients.stream().filter(distinctByKey(ChemistryCompound::toString)).toList()) compound.add(toAdd); // Combine all the unique ChemistryCompounds into 1 mixture
                    if(compound.isEmpty()) return; // If the compound is empty, exit early
                    vanillaItems.put(id, compound); // Add to our database otherwise
                });
    }
    public static void deepInit(MinecraftServer server) {
        int recipesComputed = 0;
        for(int i=0; i<AutoConfig.getConfigHolder(CFMConfig.class).getConfig().maxDepth; i++) { // We run processTree multiple times in order to get recipes nested more than 2 layers deep. For example, without this loop, wood planks would work (oak logs are already categorized), but sticks would not (oak logs are categorized but oak planks are not yet)
            processTree(server);
            ChemistryFormulaMod.LOGGER.info("depth=%d, %d items' compositions computed".formatted(i, vanillaItems.size())); // Log how many recipes have been calculated
            if(vanillaItems.size() > recipesComputed) recipesComputed = vanillaItems.size(); // If we've calculated more recipes total than last time, keep going
            else { // Otherwise, give up as there probably is no more layers of recipes to do. This also saves computational time by cutting it off early and not going to ultimateMaxDepth every time, which is a last-resort
                ChemistryFormulaMod.LOGGER.info("No additional recipes computed, stopping composition computation"); // Alert we've finished into log
                break; // Don't go again
            }
        }
    }
}
