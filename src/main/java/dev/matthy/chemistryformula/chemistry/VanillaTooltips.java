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

    public static HashMap<Identifier, ChemistryCompound> vanillaItems = new HashMap<>() {{ // The Monolith. Converts many item Identifiers to rough chemical formulas
        put(getId(Items.COAL), ChemistryCompound.fromFormula(El(C, 1))); // C
        put(getId(Items.CHARCOAL), ChemistryCompound.fromFormula(El(C, 1))); // C
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
        put(getId(Items.ICE), ChemistryCompound.fromFormula(El(H, 2), El(O,1))); // H2O
        put(getId(Items.OBSIDIAN), ChemistryCompound.fromFormula(El(Si, 1), El(O,2))); // cr.: https://en.wikipedia.org/wiki/Obsidian
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
        put(getId(Items.SPRUCE_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.STRIPPED_OAK_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.STRIPPED_ACACIA_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.STRIPPED_BIRCH_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.STRIPPED_CHERRY_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.STRIPPED_JUNGLE_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.STRIPPED_DARK_OAK_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.STRIPPED_MANGROVE_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.STRIPPED_PALE_OAK_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.STRIPPED_SPRUCE_LOG), ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11)));
        put(getId(Items.COBWEB), ChemistryCompound.fromFormula(El(C,2), El(H,5), El(N, 1), El(O, 2))); // cr.: https://bioinfo.uochb.cas.cz/teaching/protphys2019/Saravanan.pdf, https://en.wikipedia.org/wiki/Glycine
        put(getId(Items.STRING), ChemistryCompound.fromFormula(El(C,2), El(H,5), El(N, 1), El(O, 2)));
        put(getId(Items.BASALT), ChemistryCompound.fromFormula(El(Al, 10), El(Ca, 4), El(Fe, 3), El(K, 1), El(Mg, 2), El(Na, 1), El(O, 60), El(Si, 18))); // cr.: https://docs.google.com/spreadsheets/d/1NmP3F-X8efEhpApaaksnH-E4VQ6ahO4wJuhygTIm3rs/edit?usp=sharing
        put(getId(Items.ANDESITE), ChemistryCompound.fromFormula(El(Al, 11), El(Ca, 3), El(Fe, 2), El(K, 1), El(Mg, 1), El(Na, 2), El(O, 61), El(Si, 18)));
        put(getId(Items.GRANITE), ChemistryCompound.fromFormula(El(Al, 9), El(Ca, 1), El(Fe, 2), El(K, 2), El(Na, 2), El(O, 62), El(Si, 22)));
        put(getId(Items.STONE), ChemistryCompound.fromFormula(El(Al, 10), El(Ca, 2), El(Fe, 2), El(K, 1), El(Mg, 2), El(Na, 2), El(O, 61), El(Si, 19)));
        put(getId(Items.COBBLESTONE), ChemistryCompound.fromFormula(El(Al, 10), El(Ca, 2), El(Fe, 2), El(K, 1), El(Mg, 2), El(Na, 2), El(O, 61), El(Si, 19)));
        put(getId(Items.DEEPSLATE), ChemistryCompound.fromFormula(El(Al, 4), El(Ca, 2), El(Fe, 3), El(Mg, 14), El(O, 60), El(Si, 18)));
        put(getId(Items.COBBLED_DEEPSLATE), ChemistryCompound.fromFormula(El(Al, 4), El(Ca, 2), El(Fe, 3), El(Mg, 14), El(O, 60), El(Si, 18)));
        put(getId(Items.INK_SAC), ChemistryCompound.fromFormula(El(C, 23), El(H, 20), El(N, 4), El(O, 8), El(S, 2))); // cr.: https://en.wikipedia.org/wiki/Cephalopod_ink#Properties_and_chemistry, https://pubchem.ncbi.nlm.nih.gov/compound/Eumelanins#section=InChI
        put(getId(Items.GREEN_DYE), ChemistryCompound.fromFormula(El(C,55), El(H, 70), El(O, 6), El(N, 4), El(Mg, 1))); // cr.: https://en.wikipedia.org/wiki/Cactus#Stems, https://en.wikipedia.org/wiki/Chlorophyll#Chemical_structure
        put(getId(Items.BROWN_DYE), ChemistryCompound.fromFormula(El(C,8),El(H, 13), El(O, 5))); // cr.: https://www.chembk.com/en/chem/CACAO%20PIGMENT, https://www.frontiersin.org/journals/materials/articles/10.3389/fmats.2025.1537067/full
        put(getId(Items.RED_DYE), ChemistryCompound.fromFormula(El(C,15),El(H,11),El(O, 5))); // cr.: https://en.wikipedia.org/wiki/Pelargonidin
        put(getId(Items.YELLOW_DYE), ChemistryCompound.fromFormula(El(C, 40), El(H, 56), El(O, 3))); // cr.: https://en.wikipedia.org/wiki/Antheraxanthin
        put(getId(Items.FLINT), ChemistryCompound.fromFormula(El(Si, 1), El(O, 2))); // cr.: https://digitalfire.com/material/flint
    }};
    public static final int ultimateMaxDepth = 1024; // Max depth before we give up on processing deeper into recipes. Used to prevent infinite loops
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
                    int validSlots = 0; // Slots that aren't empty
                    ArrayList<ChemistryCompound> satisfactoryIngredients = new ArrayList<>(); // All ChemistryCompounds that could be calculated from their Ingredients
                    for (Ingredient ingredient : recipe.getIngredientPlacement().getIngredients()) { // Brute-force to see if any keys in our vanillaItems match a requirement
                        if(ingredient.isEmpty()) continue;
                        else validSlots++;
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
        for(int i=0; i<ultimateMaxDepth; i++) { // We run processTree multiple times in order to get recipes nested more than 2 layers deep. For example, without this loop, wood planks would work (oak logs are already categorized), but sticks would not (oak logs are categorized but oak planks are not yet)
            processTree(server);
            ChemistryFormulaMod.LOGGER.info("depth=%d, %d items' compositions computed".formatted(i, vanillaItems.size())); // Log how many recipes have been calculated
            if(vanillaItems.size() > recipesComputed) recipesComputed = vanillaItems.size(); // If we've calculated more recipes total than last time, keep going
            else { // Otherwise, give up as there probably is no more layers of recipes to do. This also saves computational time by cutting it off early and not going to ultimateMaxDepth every time, which is a last-resort
                ChemistryFormulaMod.LOGGER.info("No additional recipes computed, stopping composition computation"); // Alert we've finished into log
                break; // Don't go again
            }
        }
    }
    public static void initItems(HashMap<Identifier, ChemistryCompound> items) {
        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> { // Add our chemical formula for all of our items as a hook into every item
            if(!items.containsKey(getId(itemStack.getItem()))) return; // If it isn't catalogued, don't add any tooltip
            list.add(Text.literal(items.get(getId(itemStack.getItem())).toString())); // If it *is* catalogued, add the tooltip!
        });
    }
    public static void init() {
        // Currently supported recipe type ids: minecraft:crafting_shaped, minecraft:crafting_shapeless
        initItems(vanillaItems);
    }
}
