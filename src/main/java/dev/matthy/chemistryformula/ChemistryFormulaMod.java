package dev.matthy.chemistryformula;

import dev.matthy.chemistryformula.calculate.CraftingProcessor;
import dev.matthy.chemistryformula.display.ItemTooltip;
import dev.matthy.chemistryformula.integration.CFMConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChemistryFormulaMod implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger("cfm");

    @Override
    public void onInitialize() {
        AutoConfig.register(CFMConfig.class, GsonConfigSerializer::new);
        ServerLifecycleEvents.SERVER_STARTED.register(CraftingProcessor::deepInit);
        ServerPlayerEvents.JOIN.register((spe) -> ItemTooltip.init());
    }
}
