package dev.matthy.chemistryformula;

import dev.matthy.chemistryformula.chemistry.VanillaTooltips;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChemistryFormulaMod implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger("cfm");

    @Override
    public void onInitialize() {
        ServerLifecycleEvents.SERVER_STARTED.register(VanillaTooltips::deepInit);
        ServerPlayerEvents.JOIN.register((spe) -> VanillaTooltips.init());
    }
}
