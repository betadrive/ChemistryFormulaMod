package dev.matthy.chemistryformula.data;

import dev.matthy.chemistryformula.api.ChemistryCompound;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

import static dev.matthy.chemistryformula.api.ChemistryCompound.El;
import static dev.matthy.chemistryformula.api.ChemistryCompound.fromFormula;
import static dev.matthy.chemistryformula.api.ChemistryElement.*;
import static dev.matthy.chemistryformula.calculate.CraftingProcessor.getId;
import static dev.matthy.chemistryformula.data.Chemicals.*;
import static dev.matthy.chemistryformula.data.Ions.*;

public class CompoundItems {
    public static HashMap<Identifier, ChemistryCompound> calculatedItems = new HashMap<>() {{ // The Monolith. Converts many item Identifiers to rough chemical formulas
        // Mining/digging
        put(getId(Items.COAL), ChemistryCompound.fromFormula(El(C))); // C
        put(getId(Items.CHARCOAL), ChemistryCompound.fromFormula(El(C))); // C
        put(getId(Items.DIAMOND), ChemistryCompound.fromFormula(El(C))); // C
        put(getId(Items.IRON_INGOT), ChemistryCompound.fromFormula(El(Fe))); // Fe
        put(getId(Items.GOLD_INGOT), ChemistryCompound.fromFormula(El(Au))); // Au
        put(getId(Items.COPPER_INGOT), ChemistryCompound.fromFormula(El(Cu))); // Cu
        put(getId(Items.EMERALD), EMERALD);
        put(getId(Items.AMETHYST_SHARD), SILICON_DIOXIDE); // cr.: https://en.wikipedia.org/wiki/Emerald
        put(getId(Items.CALCITE), CARBONATE.mix(Ca)); // cr.: https://en.wikipedia.org/wiki/Calcite
        put(getId(Items.LAPIS_LAZULI), LAZURITE);
        put(getId(Items.REDSTONE), SULFATE.mix(El(Co))); // cr.: https://www.reddit.com/r/feedthebeast/comments/bcbies/debunking_mmc_week_2_redstones_real_life/?utm_source=share&utm_medium=web3x&utm_name=web3xcss&utm_term=1&utm_content=share_button
        put(getId(Items.QUARTZ), SULFATE.mix(El(Co))); // cr.: https://en.wikipedia.org/wiki/Quartz
        put(getId(Items.OBSIDIAN), SILICON_DIOXIDE); // cr.: https://en.wikipedia.org/wiki/Obsidian
        put(getId(Items.CLAY_BALL), ChemistryCompound.fromFormula(El(Al, 2), El(Si, 2), El(O, 9), El(H, 4))); // cr.: https://en.wikipedia.org/wiki/Kaolinite
        put(getId(Items.BASALT), BASALT);
        put(getId(Items.ANDESITE), ANDESITE);
        put(getId(Items.GRANITE), GRANITE);
        put(getId(Items.STONE), STONE);
        put(getId(Items.COBBLESTONE), STONE);
        put(getId(Items.DEEPSLATE), DEEPSLATE);
        put(getId(Items.COBBLED_DEEPSLATE), DEEPSLATE);
        put(getId(Items.FLINT), SILICON_DIOXIDE); // cr.: https://digitalfire.com/material/flint

        // Ores
        // In stone
        put(getId(Items.COAL_ORE), STONE.mix(El(C)));
        put(getId(Items.COPPER_ORE), STONE.mix(El(Cu)));
        put(getId(Items.IRON_ORE), STONE.mix(El(Fe)));
        put(getId(Items.LAPIS_ORE), STONE.mix(LAZURITE));
        put(getId(Items.REDSTONE_ORE), STONE.mix(SULFATE.mix(El(Co))));
        put(getId(Items.GOLD_ORE), STONE.mix(El(Au)));
        put(getId(Items.DIAMOND_ORE), STONE.mix(El(C)));
        put(getId(Items.EMERALD_ORE), STONE.mix(EMERALD));
        // In deepslate
        put(getId(Items.DEEPSLATE_COAL_ORE), DEEPSLATE.mix(El(C)));
        put(getId(Items.DEEPSLATE_COPPER_ORE), DEEPSLATE.mix(El(Cu)));
        put(getId(Items.DEEPSLATE_IRON_ORE), DEEPSLATE.mix(El(Fe)));
        put(getId(Items.DEEPSLATE_LAPIS_ORE), DEEPSLATE.mix(LAZURITE));
        put(getId(Items.DEEPSLATE_REDSTONE_ORE), DEEPSLATE.mix(SULFATE.mix(El(Co))));
        put(getId(Items.DEEPSLATE_GOLD_ORE), DEEPSLATE.mix(El(Au)));
        put(getId(Items.DEEPSLATE_DIAMOND_ORE), DEEPSLATE.mix(El(C)));
        put(getId(Items.DEEPSLATE_EMERALD_ORE), DEEPSLATE.mix(EMERALD));
        // Raw
        put(getId(Items.RAW_COPPER), fromFormula(El(Cu)));
        put(getId(Items.RAW_GOLD), fromFormula(El(Au)));
        put(getId(Items.RAW_IRON), fromFormula(El(Fe)));

        // Smelting
        put(getId(Items.GLASS), SILICON_DIOXIDE); // cr.: https://en.wikipedia.org/wiki/Glass#Microscopic_structure

        // Water-based
        put(getId(Items.SNOWBALL), WATER); // H2O
        put(getId(Items.ICE), WATER); // H2O
        put(getId(Items.WATER_BUCKET), WATER.mix(El(Fe)));

        // Wood
        put(getId(Items.OAK_LOG), LIGNIN); // cr.: https://en.wikipedia.org/wiki/Lignin#Composition_and_structure
        put(getId(Items.ACACIA_LOG), LIGNIN);
        put(getId(Items.BIRCH_LOG), LIGNIN);
        put(getId(Items.CHERRY_LOG), LIGNIN);
        put(getId(Items.JUNGLE_LOG), LIGNIN);
        put(getId(Items.DARK_OAK_LOG), LIGNIN);
        put(getId(Items.MANGROVE_LOG), LIGNIN);
        put(getId(Items.PALE_OAK_LOG), LIGNIN);
        put(getId(Items.SPRUCE_LOG), LIGNIN);
        put(getId(Items.STRIPPED_OAK_LOG), LIGNIN);
        put(getId(Items.STRIPPED_ACACIA_LOG), LIGNIN);
        put(getId(Items.STRIPPED_BIRCH_LOG), LIGNIN);
        put(getId(Items.STRIPPED_CHERRY_LOG), LIGNIN);
        put(getId(Items.STRIPPED_JUNGLE_LOG), LIGNIN);
        put(getId(Items.STRIPPED_DARK_OAK_LOG), LIGNIN);
        put(getId(Items.STRIPPED_MANGROVE_LOG), LIGNIN);
        put(getId(Items.STRIPPED_PALE_OAK_LOG), LIGNIN);
        put(getId(Items.STRIPPED_SPRUCE_LOG), LIGNIN);

        // Dyes
        put(getId(Items.GREEN_DYE), ChemistryCompound.fromFormula(El(C,55), El(H, 70), El(O, 6), El(N, 4), El(Mg))); // cr.: https://en.wikipedia.org/wiki/Cactus#Stems, https://en.wikipedia.org/wiki/Chlorophyll#Chemical_structure
        put(getId(Items.BROWN_DYE), ChemistryCompound.fromFormula(El(C,8),El(H, 13), El(O, 5))); // cr.: https://www.chembk.com/en/chem/CACAO%20PIGMENT, https://www.frontiersin.org/journals/materials/articles/10.3389/fmats.2025.1537067/full
        put(getId(Items.RED_DYE), ChemistryCompound.fromFormula(El(C,15),El(H,11),El(O, 5))); // cr.: https://en.wikipedia.org/wiki/Pelargonidin
        put(getId(Items.YELLOW_DYE), ChemistryCompound.fromFormula(El(C, 40), El(H, 56), El(O, 3))); // cr.: https://en.wikipedia.org/wiki/Antheraxanthin

        // Waxed items must be done manually since they're in-world transformations with right-clicking via honeycombs, which is not a shaped or shapeless recipe
        // Same with oxidized items
        put(getId(Items.EXPOSED_COPPER), COPPER_PATINA); // cr.: https://www.sciencedirect.com/science/article/abs/pii/S0010938X98000936
        put(getId(Items.EXPOSED_COPPER_CHEST), COPPER_PATINA.mix(LIGNIN));
        put(getId(Items.EXPOSED_COPPER_DOOR), COPPER_PATINA);
        put(getId(Items.EXPOSED_COPPER_TRAPDOOR), COPPER_PATINA);
        put(getId(Items.WEATHERED_COPPER), COPPER_PATINA);
        put(getId(Items.WEATHERED_COPPER_CHEST), COPPER_PATINA.mix(LIGNIN));
        put(getId(Items.WEATHERED_COPPER_DOOR), COPPER_PATINA);
        put(getId(Items.WEATHERED_COPPER_TRAPDOOR), COPPER_PATINA);
        put(getId(Items.OXIDIZED_COPPER), COPPER_PATINA);
        put(getId(Items.OXIDIZED_COPPER_CHEST), COPPER_PATINA.mix(LIGNIN));
        put(getId(Items.OXIDIZED_COPPER_DOOR), COPPER_PATINA);
        put(getId(Items.OXIDIZED_COPPER_TRAPDOOR), COPPER_PATINA);
        put(getId(Items.COPPER_CHAINS.unaffected()), ChemistryCompound.fromFormula(El(Cu)));
        put(getId(Items.COPPER_CHAINS.exposed()), COPPER_PATINA);
        put(getId(Items.COPPER_CHAINS.oxidized()), COPPER_PATINA);
        put(getId(Items.COPPER_CHAINS.waxed()), BEESWAX.mix(El(Cu)));
        put(getId(Items.COPPER_CHAINS.waxedExposed()), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));
        put(getId(Items.COPPER_CHAINS.waxedWeathered()), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));
        put(getId(Items.COPPER_CHAINS.waxedOxidized()), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));
        put(getId(Items.COPPER_BARS.unaffected()), ChemistryCompound.fromFormula(El(Cu)));
        put(getId(Items.COPPER_BARS.exposed()), COPPER_PATINA);
        put(getId(Items.COPPER_BARS.oxidized()), COPPER_PATINA);
        put(getId(Items.COPPER_BARS.waxed()), BEESWAX.mix(El(Cu)));
        put(getId(Items.COPPER_BARS.waxedExposed()), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));
        put(getId(Items.COPPER_BARS.waxedWeathered()), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));
        put(getId(Items.COPPER_BARS.waxedOxidized()), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));
        put(getId(Items.COPPER_LANTERNS.unaffected()), ChemistryCompound.fromFormula(El(Cu)));
        put(getId(Items.COPPER_LANTERNS.exposed()), COPPER_PATINA);
        put(getId(Items.COPPER_LANTERNS.oxidized()), COPPER_PATINA);
        put(getId(Items.COPPER_LANTERNS.waxed()), BEESWAX.mix(El(Cu)));
        put(getId(Items.COPPER_LANTERNS.waxedExposed()), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));
        put(getId(Items.COPPER_LANTERNS.waxedWeathered()), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));
        put(getId(Items.COPPER_LANTERNS.waxedOxidized()), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));
        put(getId(Items.WAXED_COPPER_BLOCK), BEESWAX.mix(El(Cu)));
        put(getId(Items.WAXED_COPPER_CHEST), BEESWAX.mix(El(Cu)).mix(LIGNIN));
        put(getId(Items.WAXED_COPPER_DOOR), BEESWAX.mix(El(Cu)));
        put(getId(Items.WAXED_COPPER_TRAPDOOR), BEESWAX.mix(El(Cu)));
        put(getId(Items.WAXED_EXPOSED_COPPER), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));
        put(getId(Items.WAXED_EXPOSED_COPPER_CHEST), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA).mix(LIGNIN));
        put(getId(Items.WAXED_EXPOSED_COPPER_DOOR), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));
        put(getId(Items.WAXED_EXPOSED_COPPER_TRAPDOOR), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));
        put(getId(Items.WAXED_WEATHERED_COPPER), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));
        put(getId(Items.WAXED_WEATHERED_COPPER_CHEST), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA).mix(LIGNIN));
        put(getId(Items.WAXED_WEATHERED_COPPER_DOOR), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));
        put(getId(Items.WAXED_WEATHERED_COPPER_TRAPDOOR), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));
        put(getId(Items.WAXED_OXIDIZED_COPPER), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));
        put(getId(Items.WAXED_OXIDIZED_COPPER_CHEST), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA).mix(LIGNIN));
        put(getId(Items.WAXED_OXIDIZED_COPPER_DOOR), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));
        put(getId(Items.WAXED_OXIDIZED_COPPER_TRAPDOOR), BEESWAX.mix(El(Cu)).mix(COPPER_PATINA));

        // Mob drops
        // Hostile
        put(getId(Items.STRING), GLYCINE);
        put(getId(Items.BONE), ChemistryCompound.fromFormula(El(Ca, 10), El(P, 6), El(O, 26), El(H, 2))); // cr.: https://www.doitpoms.ac.uk/tlplib/bones/structure.php
        put(getId(Items.GUNPOWDER), NITRATE.mix(El(K)).mix(El(S))); // cr.: https://en.wikipedia.org/wiki/Gunpowder#Components
        put(getId(Items.SLIME_BALL), ChemistryCompound.fromFormula(El(C,2),El(H,4), El(O))); // cr.: https://en.wikipedia.org/wiki/Polyvinyl_alcohol
        // Friendly
        put(getId(Items.INK_SAC), ChemistryCompound.fromFormula(El(C, 23), El(H, 20), El(N, 4), El(O, 8), El(S, 2))); // cr.: https://en.wikipedia.org/wiki/Cephalopod_ink#Properties_and_chemistry, https://pubchem.ncbi.nlm.nih.gov/compound/Eumelanins#section=InChI

        // Produce
        put(getId(Items.HONEY_BLOCK), GLUCOSE.mix(WATER)); // cr.: https://pmc.ncbi.nlm.nih.gov/articles/PMC5815988/
        put(getId(Items.HONEY_BOTTLE), GLUCOSE.mix(WATER).mix(SILICON_DIOXIDE));
        put(getId(Items.SUGAR), GLUCOSE); // C6H12O6
        put(getId(Items.HONEYCOMB), BEESWAX); // cr.: https://en.wikipedia.org/wiki/Beeswax

        // Misc.
        put(getId(Items.COBWEB), GLYCINE); // cr.: https://bioinfo.uochb.cas.cz/teaching/protphys2019/Saravanan.pdf, https://en.wikipedia.org/wiki/Glycine
    }};
    public static void addCompounds(Item item, ChemistryCompound compound) {
        calculatedItems.put(getId(item), compound);
    }
    public static void addCompounds(Map<Identifier, ChemistryCompound> map) {
        calculatedItems.putAll(map);
    }
}
