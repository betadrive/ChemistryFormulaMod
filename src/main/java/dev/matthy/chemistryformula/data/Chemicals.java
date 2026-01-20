package dev.matthy.chemistryformula.data;

import dev.matthy.chemistryformula.chemistry.ChemistryCompound;

import static dev.matthy.chemistryformula.chemistry.ChemistryCompound.El;
import static dev.matthy.chemistryformula.chemistry.ChemistryCompound.fromFormula;
import static dev.matthy.chemistryformula.chemistry.ChemistryElement.*;
import static dev.matthy.chemistryformula.data.Ions.*;

public class Chemicals {
    public static ChemistryCompound GLUCOSE = fromFormula(El(C,6),El(H, 12), El(O, 6));
    public static ChemistryCompound WATER = OXIDE.mix(El(H, 2));
    public static ChemistryCompound LIGNIN = ChemistryCompound.fromFormula(El(C, 31), El(H, 34), El(O, 11));
    public static ChemistryCompound COPPER_PATINA = ChemistryCompound.fromFormula(El(Cu, 4), El(S), El(O, 10), El(H, 6));
    public static ChemistryCompound BEESWAX = ChemistryCompound.fromFormula(El(C, 46),El(H,92),El(O, 2));
    public static ChemistryCompound GLYCINE = ChemistryCompound.fromFormula(El(C,2), El(H,5), El(N), El(O, 2));
    public static ChemistryCompound SILICON_DIOXIDE = DIOXIDE.mix(El(Si));
    public static ChemistryCompound STONE = ChemistryCompound.fromFormula(El(Al, 10), El(Ca, 2), El(Fe, 2), El(K), El(Mg, 2), El(Na, 2), El(O, 61), El(Si, 19)); // cr.: https://docs.google.com/spreadsheets/d/1NmP3F-X8efEhpApaaksnH-E4VQ6ahO4wJuhygTIm3rs/edit?usp=sharing
    public static ChemistryCompound DEEPSLATE = ChemistryCompound.fromFormula(El(Al, 4), El(Ca, 2), El(Fe, 3), El(Mg, 14), El(O, 60), El(Si, 18)); // cr.: same as STONE
    public static ChemistryCompound BASALT = ChemistryCompound.fromFormula(El(Al, 10), El(Ca, 4), El(Fe, 3), El(K), El(Mg, 2), El(Na), El(O, 60), El(Si, 18)); // cr.: same as STONE
    public static ChemistryCompound ANDESITE = ChemistryCompound.fromFormula(El(Al, 11), El(Ca, 3), El(Fe, 2), El(K), El(Mg), El(Na, 2), El(O, 61), El(Si, 18)); // cr.: same as STONE
    public static ChemistryCompound GRANITE = ChemistryCompound.fromFormula(El(Al, 9), El(Ca), El(Fe, 2), El(K, 2), El(Na, 2), El(O, 62), El(Si, 22)); // cr.: same as STONE
    public static ChemistryCompound EMERALD = ChemistryCompound.fromFormula(El(Be, 3), El(Al, 2), El(Si, 6), El(O, 18)); // cr.: https://en.wikipedia.org/wiki/Emerald
    public static ChemistryCompound LAZURITE = ChemistryCompound.fromFormula(El(Na, 8), El(Ca, 8), El(S, 4), El(Cl, 2), El(O, 34), El(H, 2), El(Al, 6), El(Si, 6)); // cr.: https://en.wikipedia.org/wiki/Lazurite#Structure
}
