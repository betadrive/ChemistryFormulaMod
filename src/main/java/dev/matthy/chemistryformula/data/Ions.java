package dev.matthy.chemistryformula.data;

import dev.matthy.chemistryformula.chemistry.ChemistryCompound;

import static dev.matthy.chemistryformula.chemistry.ChemistryCompound.El;
import static dev.matthy.chemistryformula.chemistry.ChemistryCompound.fromFormula;
import static dev.matthy.chemistryformula.chemistry.ChemistryElement.*;

public class Ions { // cr.: https://www.cgc.edu/sites/default/files/inline-files/names-and-formulas-of-common-lons.pdf

    // 14 nonmetals
    // C
    public static ChemistryCompound CARBIDE = fromFormula(El(C));
    public static ChemistryCompound CARBONATE = fromFormula(El(O, 3)).mix(C);
    // Si
    public static ChemistryCompound SILICIDE = fromFormula(El(Si));
    public static ChemistryCompound SILICATE = fromFormula(El(O, 3)).mix(Si);

    // 15 nonmetals
    // N
    public static ChemistryCompound NITRIDE = fromFormula(El(N));
    public static ChemistryCompound NITRATE = fromFormula(El(O, 3)).mix(N);
    public static ChemistryCompound NITRITE = fromFormula(El(O, 2)).mix(N);
    // P
    public static ChemistryCompound PHOSPHIDE = fromFormula(El(P));
    public static ChemistryCompound PHOSPHATE = fromFormula(El(O, 4)).mix(P);
    public static ChemistryCompound PHOSPHITE = fromFormula(El(O, 3)).mix(P);
    // As
    public static ChemistryCompound ARSENIDE = fromFormula(El(As));
    public static ChemistryCompound ARSENATE = fromFormula(El(O, 4)).mix(As);
    public static ChemistryCompound ARSENITE = fromFormula(El(O, 3)).mix(As);

    // 16 nonmetals
    // O
    public static ChemistryCompound OXIDE = fromFormula(El(O));
    public static ChemistryCompound DIOXIDE = fromFormula(El(O, 2));
    public static ChemistryCompound TRIOXIDE = fromFormula(El(O, 3));
    public static ChemistryCompound TETROXIDE = fromFormula(El(O, 4));
    // S
    public static ChemistryCompound SULFIDE = fromFormula(El(S));
    public static ChemistryCompound SULFATE = TETROXIDE.mix(S);
    public static ChemistryCompound SULFITE = TRIOXIDE.mix(S);
    // Se
    public static ChemistryCompound SELENIDE = fromFormula(El(Se));
    public static ChemistryCompound SELENATE = TETROXIDE.mix(Se);
    public static ChemistryCompound SELENITE = TRIOXIDE.mix(Se);

    // 17 nonmetals
    // F
    public static ChemistryCompound FLUORIDE = fromFormula(El(F));
    // Cl
    public static ChemistryCompound CHLORIDE = fromFormula(El(Cl));
    public static ChemistryCompound CHLORATE = TRIOXIDE.mix(Cl);
    public static ChemistryCompound PERCHLORATE = TETROXIDE.mix(Cl);
    public static ChemistryCompound CHLORITE = DIOXIDE.mix(Cl);
    public static ChemistryCompound HYPOCHLORITE = OXIDE.mix(Cl);
    // Br
    public static ChemistryCompound BROMIDE = fromFormula(El(Br));
    public static ChemistryCompound BROMATE = TRIOXIDE.mix(Br);
    public static ChemistryCompound PERBROMATE = TETROXIDE.mix(Cl);
    public static ChemistryCompound BROMITE = DIOXIDE.mix(Br);
    public static ChemistryCompound HYPOBROMITE = OXIDE.mix(Br);
    // I
    public static ChemistryCompound IODIDE = fromFormula(El(I));
    public static ChemistryCompound IODATE = TRIOXIDE.mix(I);
    public static ChemistryCompound PERIODATE = TETROXIDE.mix(I);
    public static ChemistryCompound IODITE = DIOXIDE.mix(I);
    public static ChemistryCompound HYPOIODITE = OXIDE.mix(I);
    // H
    public static ChemistryCompound HYDRIDE = fromFormula(El(H));

    // Metals
    // Cr
    public static ChemistryCompound CHROMATE = TETROXIDE.mix(Cr);
    public static ChemistryCompound DICHROMATE = fromFormula(El(Cr, 2), El(O, 7));
    // Mn
    public static ChemistryCompound MANGANATE = TETROXIDE.mix(Mn);
    public static ChemistryCompound PERMANGANATE = MANGANATE;

    // Other
    public static ChemistryCompound ACETATE = fromFormula(El(C, 2), El(H, 3), El(O, 2));
    public static ChemistryCompound HYDROXIDE = OXIDE.mix(H);
    public static ChemistryCompound CYANIDE = NITRIDE.mix(H);
    public static ChemistryCompound CYANATE = CYANIDE.mix(O);
    public static ChemistryCompound THIOCYANATE = CYANIDE.mix(S);
    public static ChemistryCompound PEROXIDE = DIOXIDE;

    // Polyatomic anions
    public static ChemistryCompound AMMONIUM = fromFormula(El(N), El(H, 4));
    public static ChemistryCompound HYDRONIUM = fromFormula(El(H, 3), El(O));
}
