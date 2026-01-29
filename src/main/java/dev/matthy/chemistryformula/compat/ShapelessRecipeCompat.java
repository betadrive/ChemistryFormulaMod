package dev.matthy.chemistryformula.compat;

import dev.matthy.chemistryformula.api.ChemistryCompound;
import dev.matthy.chemistryformula.calculate.ProcessedRecipe;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.server.MinecraftServer;

import java.util.ArrayList;

import static dev.matthy.chemistryformula.calculate.CraftingProcessor.acceptableItems;
import static dev.matthy.chemistryformula.calculate.CraftingProcessor.getId;
import static dev.matthy.chemistryformula.data.CompoundItems.calculatedItems;

public class ShapelessRecipeCompat {
    public static ProcessedRecipe toProcessedRecipe(ShapelessRecipe recipe, MinecraftServer server) {
        Item output = recipe.craft(CraftingRecipeInput.EMPTY, server.getRegistryManager()).getItem(); // Get the output item as Item
        ArrayList<ChemistryCompound> satisfactoryIngredients = new ArrayList<>(); // All ChemistryCompounds that could be calculated from their Ingredients
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
        boolean recipeFullyCalculable = satisfactoryIngredients.size() == validSlots;
        return new ProcessedRecipe(satisfactoryIngredients, output, recipeFullyCalculable);
    }
}
