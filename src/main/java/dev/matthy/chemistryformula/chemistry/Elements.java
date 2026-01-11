package dev.matthy.chemistryformula.chemistry;

import java.util.*;
import java.util.stream.Collectors;

public class Elements {
    // Elements in order of atomic number:
    public static ChemistryElement[] ELEMENTS = {ChemistryElement.H, ChemistryElement.He, ChemistryElement.Li, ChemistryElement.Be, ChemistryElement.B, ChemistryElement.C, ChemistryElement.N, ChemistryElement.O, ChemistryElement.F, ChemistryElement.Ne, ChemistryElement.Na, ChemistryElement.Mg, ChemistryElement.Al, ChemistryElement.Si, ChemistryElement.P, ChemistryElement.S, ChemistryElement.Cl, ChemistryElement.Ar, ChemistryElement.K, ChemistryElement.Ca, ChemistryElement.Sc, ChemistryElement.Ti, ChemistryElement.V, ChemistryElement.Cr, ChemistryElement.Mn, ChemistryElement.Fe, ChemistryElement.Co, ChemistryElement.Ni, ChemistryElement.Cu, ChemistryElement.Zn, ChemistryElement.Ga, ChemistryElement.Ge, ChemistryElement.As, ChemistryElement.Se, ChemistryElement.Br, ChemistryElement.Kr, ChemistryElement.Rb, ChemistryElement.Sr, ChemistryElement.Y, ChemistryElement.Zr, ChemistryElement.Nb, ChemistryElement.Mo, ChemistryElement.Tc, ChemistryElement.Ru, ChemistryElement.Rh, ChemistryElement.Pd, ChemistryElement.Ag, ChemistryElement.Cd, ChemistryElement.In, ChemistryElement.Sn, ChemistryElement.Sb, ChemistryElement.Te, ChemistryElement.I, ChemistryElement.Xe, ChemistryElement.Cs, ChemistryElement.Ba, ChemistryElement.La, ChemistryElement.Ce, ChemistryElement.Pr, ChemistryElement.Nd, ChemistryElement.Pm, ChemistryElement.Sm, ChemistryElement.Eu, ChemistryElement.Gd, ChemistryElement.Tb, ChemistryElement.Dy, ChemistryElement.Ho, ChemistryElement.Er, ChemistryElement.Tm, ChemistryElement.Yb, ChemistryElement.Lu, ChemistryElement.Hf, ChemistryElement.Ta, ChemistryElement.W, ChemistryElement.Re, ChemistryElement.Os, ChemistryElement.Ir, ChemistryElement.Pt, ChemistryElement.Au, ChemistryElement.Hg, ChemistryElement.Tl, ChemistryElement.Pb, ChemistryElement.Bi, ChemistryElement.Po, ChemistryElement.At, ChemistryElement.Rn, ChemistryElement.Fr, ChemistryElement.Ra, ChemistryElement.Ac, ChemistryElement.Th, ChemistryElement.Pa, ChemistryElement.U, ChemistryElement.Np, ChemistryElement.Pu, ChemistryElement.Am, ChemistryElement.Cm, ChemistryElement.Bk, ChemistryElement.Cf, ChemistryElement.Es, ChemistryElement.Fm, ChemistryElement.Md, ChemistryElement.No, ChemistryElement.Lr, ChemistryElement.Rf, ChemistryElement.Db, ChemistryElement.Sg, ChemistryElement.Bh, ChemistryElement.Hs, ChemistryElement.Mt, ChemistryElement.Ds, ChemistryElement.Rg, ChemistryElement.Cn, ChemistryElement.Nh, ChemistryElement.Fl, ChemistryElement.Mc, ChemistryElement.Lv, ChemistryElement.Ts, ChemistryElement.Og};

    public static EnumMap<ChemistryElement, Integer> ATOMIC_NUMBERS = new EnumMap<>(ChemistryElement.class) {{ // Maps ChemistryElement to integer atomic number from 1-118
        ListIterator<ChemistryElement> iterator = Arrays.stream(ELEMENTS).toList().listIterator();
        while (iterator.hasNext()) {
            put(iterator.next(), iterator.nextIndex());
        }
    }};
    public static HashMap<Integer, String> subscripts = new HashMap<>() {{ // Maps integer (0-9) to subscript Unicode character
        put(1, "₁");
        put(2, "₂");
        put(3, "₃");
        put(4, "₄");
        put(5, "₅");
        put(6, "₆");
        put(7, "₇");
        put(8, "₈");
        put(9, "₉");
        put(0, "₀");
    }};
    public static String toSubscript(int num) { // Convert *any* integer, even above 9, to subscript string
        return Arrays.stream(String.valueOf(num).split("")).map((String c) -> subscripts.get(Integer.valueOf(c))).collect(Collectors.joining());
    }
}
