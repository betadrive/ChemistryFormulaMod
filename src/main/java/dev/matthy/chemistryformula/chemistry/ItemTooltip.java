package dev.matthy.chemistryformula.chemistry;

import dev.matthy.chemistryformula.integration.CFMConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.HashMap;

import static dev.matthy.chemistryformula.chemistry.CraftingProcessor.getId;
import static dev.matthy.chemistryformula.data.CompoundItems.vanillaItems;

public class ItemTooltip {
    public static void initItems(HashMap<Identifier, ChemistryCompound> items) {
        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> { // Add our chemical formula for all of our items as a hook into every item
            if(!items.containsKey(getId(itemStack.getItem())) || !AutoConfig.getConfigHolder(CFMConfig.class).getConfig().displayFormula) return; // If it isn't catalogued or tooltips are disabled, don't add any tooltip
            list.add(Text.literal(items.get(getId(itemStack.getItem())).toString())); // If it *is* catalogued, add the tooltip!
        });
    }
    public static void init() {
        // Currently supported recipe type ids: minecraft:crafting_shaped, minecraft:crafting_shapeless
        initItems(vanillaItems);
    }
}
