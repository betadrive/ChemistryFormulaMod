package dev.matthy.chemistryformula.chemistry;

import java.util.EnumMap;
import java.util.Map;

import static dev.matthy.chemistryformula.chemistry.ChemistryElement.*;

public class ChemistryCompound {

    public EnumMap<ChemistryElement, Integer> components = new EnumMap<>(ChemistryElement.class);
    public ChemistryElement[] HILL_ORDER = {C, H, Ac, Ag, Al, Am, Ar, As, At, Au, B, Ba, Be, Bh, Bi, Bk, Br, Ca, Cd, Ce, Cf, Cl, Cm, Cn, Co, Cr, Cs, Cu, Db, Ds, Dy, Er, Es, Eu, F, Fe, Fl, Fm, Fr, Ga, Gd, Ge, He, Hf, Hg, Ho, Hs, I, In, Ir, K, Kr, La, Li, Lr, Lu, Lv, Mc, Md, Mg, Mn, Mo, Mt, N, Na, Nb, Nd, Ne, Nh, Ni, No, Np, O, Og, Os, P, Pa, Pb, Pd, Pm, Po, Pr, Pt, Pu, Ra, Rb, Re, Rf, Rg, Rh, Rn, Ru, S, Sb, Sc, Se, Sg, Si, Sm, Sn, Sr, Ta, Tb, Tc, Te, Th, Ti, Tl, Tm, Ts, U, V, W, Xe, Y, Yb, Zn, Zr};
    public int visualDivisor;
    public static final ChemistryCompound EMPTY = ChemistryCompound.fromFormula(El(ChemistryElement.H, 0));
    public ChemistryCompound(EnumMap<ChemistryElement, Integer> components, int visualDivisor) {
        for(ChemistryElement element : ChemistryElement.values()) {
            this.components.put(element, components.getOrDefault(element, 0));
        }
        this.visualDivisor = visualDivisor;
    }
    public ChemistryCompound(EnumMap<ChemistryElement, Integer> components) {
        this(components, 1);
    }
    public ChemistryCompound(int visualDivisor) {
        this(new EnumMap<>(ChemistryElement.class), visualDivisor);
    }
    public ChemistryCompound() {
        this(new EnumMap<>(ChemistryElement.class), 1);
    }
    public void set(ChemistryElement element, int count) {
        if(components.containsKey(element)) components.put(element, count);
    }
    public int get(ChemistryElement element) {
        return components.getOrDefault(element, 0);
    }
    public void add(ChemistryCompound compound) {
        this.components = this.components.entrySet().stream().map((Map.Entry<ChemistryElement, Integer> entry) -> {
            entry.setValue(entry.getValue() + compound.get(entry.getKey()));
            return entry;
        }).collect(() -> new EnumMap<>(ChemistryElement.class), (m, e) -> m.put(e.getKey(), e.getValue()), EnumMap::putAll);
    }
    public void divide(int divisor) {
        for(ChemistryElement element : components.keySet()) {
            components.put(element, (((double) components.get(element)/divisor < 0.5) && ((double) components.get(element)/divisor != 0)) ? 1 : components.get(element)/divisor);
        }
    }
    public boolean isEmpty() {
        return components.values().stream().noneMatch(v -> v != 0);
    }
    public static ChemistryCompound elemental(ChemistryElement element, int count) {
        ChemistryCompound compound = new ChemistryCompound();
        compound.set(element, count);
        return compound;
    }
    public static ChemistryElementalCompound El(ChemistryElement element, int count) {
        return new ChemistryElementalCompound(element, count);
    }
    public static ChemistryCompound fromFormula(ChemistryElementalCompound... formula) {
        ChemistryCompound compound = new ChemistryCompound();
        for(ChemistryElementalCompound v : formula) compound.set(v.element(), v.count());
        return compound;
    }
    @Override
    public String toString() {
        StringBuilder formulaBuilder = new StringBuilder();
        EnumMap<ChemistryElement, Integer> componentsClone = components.clone();
        for(ChemistryElement element : HILL_ORDER) {
            int count = components.getOrDefault(element,0);
            if(count <= 0) continue;
            if(count == 1) { formulaBuilder.append(element.name()); continue; }
            formulaBuilder.append(element.name());
            formulaBuilder.append(Elements.toSubscript(count));
        }
        return formulaBuilder.toString();
    }
}
