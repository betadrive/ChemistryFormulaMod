package dev.matthy.chemistryformula.integration;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "cfm")
public class CFMConfig implements ConfigData {
    @ConfigEntry.Category("display")
    @ConfigEntry.Gui.Tooltip
    public boolean displayFormula = true;
    @ConfigEntry.Category("calculation")
    @ConfigEntry.Gui.Tooltip
    public int maxDepth = 1024;

}
