package dev.matthy.chemistryformula.chemistry;

import dev.matthy.chemistryformula.ChemistryFormulaMod;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.*;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static dev.matthy.chemistryformula.chemistry.ChemistryCompound.El;
import static dev.matthy.chemistryformula.chemistry.ChemistryElement.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class VanillaTooltips {
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) { // cr.: https://stackoverflow.com/q/23699371
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public static HashMap<Identifier, ChemistryCompound> vanillaItems = new HashMap<>() {{
        put(getId(Items.COAL), ChemistryCompound.fromFormula(El(C, 1))); // C
        put(getId(Items.DIAMOND), ChemistryCompound.elemental(C, 1)); // C
        put(getId(Items.IRON_INGOT), ChemistryCompound.fromFormula(El(Fe, 1))); // Fe
        put(getId(Items.GOLD_INGOT), ChemistryCompound.fromFormula(El(Au, 1))); // Au
        put(getId(Items.COPPER_INGOT), ChemistryCompound.fromFormula(El(Cu, 1))); // Cu
        put(getId(Items.EMERALD), ChemistryCompound.fromFormula(El(Be, 3), El(Al, 2), El(Si, 6), El(O, 18))); // cr.: https://en.wikipedia.org/wiki/Emerald
        put(getId(Items.AMETHYST_SHARD), ChemistryCompound.fromFormula(El(Si, 1), El(O,2))); // cr.: https://en.wikipedia.org/wiki/Emerald
        put(getId(Items.LAPIS_LAZULI), ChemistryCompound.fromFormula(El(Na, 8), El(Ca, 8), El(S, 4), El(Cl, 2), El(O, 34), El(H, 2), El(Al, 6), El(Si, 6))); // cr.: https://en.wikipedia.org/wiki/Lazurite#Structure
        put(getId(Items.REDSTONE), ChemistryCompound.fromFormula(El(Co, 1), El(S, 1), El(O, 4))); // cr.: https://www.reddit.com/r/feedthebeast/comments/bcbies/debunking_mmc_week_2_redstones_real_life/?utm_source=share&utm_medium=web3x&utm_name=web3xcss&utm_term=1&utm_content=share_button
        put(getId(Items.QUARTZ), ChemistryCompound.fromFormula(El(Si, 1), El(O, 2))); // cr.: https://en.wikipedia.org/wiki/Quartz
        put(getId(Items.GLASS), ChemistryCompound.fromFormula(El(Si, 1), El(O, 2))); // cr.: https://en.wikipedia.org/wiki/Glass#Microscopic_structure
        put(getId(Items.GUNPOWDER), ChemistryCompound.fromFormula(El(K, 1), El(N, 1), El(O, 3), El(C, 1), El(S, 1))); // cr.: https://en.wikipedia.org/wiki/Gunpowder#Components
        put(getId(Items.SNOWBALL), ChemistryCompound.fromFormula(El(H, 2), El(O,1))); // H2O
        put(getId(Items.BONE), ChemistryCompound.fromFormula(El(Ca, 10), El(P, 6), El(O, 26), El(H, 2))); // cr.: https://www.doitpoms.ac.uk/tlplib/bones/structure.php
        put(getId(Items.CLAY_BALL), ChemistryCompound.fromFormula(El(Al, 2), El(Si, 2), El(O, 9), El(H, 4))); // cr.: https://en.wikipedia.org/wiki/Kaolinite
        put(getId(Items.OAK_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11))); // cr.: https://en.wikipedia.org/wiki/Lignin#Composition_and_structure
        put(getId(Items.ACACIA_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.BIRCH_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.CHERRY_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.JUNGLE_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.DARK_OAK_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.MANGROVE_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.PALE_OAK_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.SPRUCE_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));;
        put(getId(Items.STRIPPED_OAK_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.STRIPPED_ACACIA_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.STRIPPED_BIRCH_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.STRIPPED_CHERRY_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.STRIPPED_JUNGLE_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.STRIPPED_DARK_OAK_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.STRIPPED_MANGROVE_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.STRIPPED_PALE_OAK_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.STRIPPED_SPRUCE_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));;
    }};
    public static final int ultimateMaxDepth = 1024;
    public static HashMap<Identifier, ChemistryCompound> processedItems = new HashMap<>();
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
                    int validSlots = 0;
                    ArrayList<ChemistryCompound> satisfactoryIngredients = new ArrayList<>();
                    for (Ingredient ingredient : recipe.getIngredientPlacement().getIngredients()) {
                        if(ingredient.isEmpty()) continue;
                        else validSlots++;
                        for (Item item : acceptableItems) {
                            if (!ingredient.test(item.getDefaultStack())) continue;
                            satisfactoryIngredients.add(vanillaItems.get(getId(item)));
                            break;
                        }
                    }
                    if(satisfactoryIngredients.size() != validSlots) return;
                    ItemStack stack = recipe.craft(CraftingRecipeInput.EMPTY, server.getRegistryManager());
                    Identifier id = getId(stack.getItem());
                    if(stack.getItem().equals(Items.BLUE_WOOL)) System.out.println(satisfactoryIngredients);
                    if(vanillaItems.containsKey(id)) return;
                    ChemistryCompound compound = ChemistryCompound.fromFormula(El(ChemistryElement.H, 0));
                    for(ChemistryCompound toAdd : satisfactoryIngredients.stream().filter(distinctByKey(ChemistryCompound::toString)).toList()) compound.add(toAdd);
                    if(compound.isEmpty()) return;
                    vanillaItems.put(id, compound);
                });
    }
    public static void deepInit(MinecraftServer server) {
        int recipesComputed = 0;
        for(int i=0; i<ultimateMaxDepth; i++) {
            processTree(server);
            ChemistryFormulaMod.LOGGER.info("depth=%d, %d items' compositions computed".formatted(i, vanillaItems.size()));
            if(vanillaItems.size() > recipesComputed) recipesComputed = vanillaItems.size();
            else {
                ChemistryFormulaMod.LOGGER.info("No additional recipes computed, stopping composition computation");
                break;
            }
        }
    }
    public static void initItems(HashMap<Identifier, ChemistryCompound> items) {
        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            if(!items.containsKey(getId(itemStack.getItem()))) return;
            list.add(Text.literal(items.get(getId(itemStack.getItem())).toString()));
        });
    }
    public static void init() {
        // System.out.println(Registries.RECIPE_SERIALIZER.getIds());
        // ids: minecraft:crafting_shaped, minecraft:crafting_shapeless
        initItems(vanillaItems);
    }
}
