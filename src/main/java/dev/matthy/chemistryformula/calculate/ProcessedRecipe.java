package dev.matthy.chemistryformula.calculate;

import dev.matthy.chemistryformula.api.ChemistryCompound;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.server.MinecraftServer;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import static dev.matthy.chemistryformula.calculate.CraftingProcessor.acceptableItems;
import static dev.matthy.chemistryformula.calculate.CraftingProcessor.getId;
import static dev.matthy.chemistryformula.data.CompoundItems.calculatedItems;

public class ProcessedRecipe {
    public Item output;
    public ArrayList<ChemistryCompound> satisfactoryIngredients = new ArrayList<>(); // All ChemistryCompounds that could be calculated from their Ingredients
    public boolean recipeFullyCalculable = false; // Are all the recipe's items accounted for?
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) { // cr.: https://stackoverflow.com/q/23699371
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
    public ProcessedRecipe(ShapedRecipe recipe, MinecraftServer server) {
        int validSlots = 0; // Slots that aren't empty
        for (Ingredient ingredient : recipe.getIngredientPlacement().getIngredients()) { // Brute-force to see if any keys in our vanillaItems match a requirement
            if(ingredient.isEmpty()) continue;
            validSlots++;
            for (Item item : acceptableItems) {
                if (!ingredient.test(item.getDefaultStack())) continue;
                satisfactoryIngredients.add(calculatedItems.get(getId(item)));
                break;
            }
        }
        recipeFullyCalculable = satisfactoryIngredients.size() == validSlots;
        output = recipe.craft(CraftingRecipeInput.EMPTY, server.getRegistryManager()).getItem(); // Get the output item as Item
    }
    public ProcessedRecipe(ArrayList<ChemistryCompound> ingredients, Item output, boolean fullyCalculable) {
        this.satisfactoryIngredients = ingredients;
        this.output = output;
        this.recipeFullyCalculable = fullyCalculable;
    }
    public ProcessedRecipe(ArrayList<ChemistryCompound> ingredients, Item output) {
        this(ingredients, output, true);
    }
}
