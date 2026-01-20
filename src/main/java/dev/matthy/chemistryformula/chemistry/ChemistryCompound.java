package dev.matthy.chemistryformula.chemistry;

import java.util.EnumMap;
import java.util.Map;

import static dev.matthy.chemistryformula.chemistry.ChemistryElement.*;

public class ChemistryCompound {
    // Maps element to number of atoms of that element in the compound
    public EnumMap<ChemistryElement, Integer> components = new EnumMap<>(ChemistryElement.class);
    // Hill order (C, H, then alphabetical)
    public ChemistryElement[] HILL_ORDER = {C, H, Ac, Ag, Al, Am, Ar, As, At, Au, B, Ba, Be, Bh, Bi, Bk, Br, Ca, Cd, Ce, Cf, Cl, Cm, Cn, Co, Cr, Cs, Cu, Db, Ds, Dy, Er, Es, Eu, F, Fe, Fl, Fm, Fr, Ga, Gd, Ge, He, Hf, Hg, Ho, Hs, I, In, Ir, K, Kr, La, Li, Lr, Lu, Lv, Mc, Md, Mg, Mn, Mo, Mt, N, Na, Nb, Nd, Ne, Nh, Ni, No, Np, O, Og, Os, P, Pa, Pb, Pd, Pm, Po, Pr, Pt, Pu, Ra, Rb, Re, Rf, Rg, Rh, Rn, Ru, S, Sb, Sc, Se, Sg, Si, Sm, Sn, Sr, Ta, Tb, Tc, Te, Th, Ti, Tl, Tm, Ts, U, V, W, Xe, Y, Yb, Zn, Zr};
    public static final ChemistryCompound EMPTY = ChemistryCompound.fromFormula(El(ChemistryElement.H, 0));
    public ChemistryCompound(EnumMap<ChemistryElement, Integer> components) {
        for(ChemistryElement element : ChemistryElement.values()) {
            this.components.put(element, components.getOrDefault(element, 0));
        }
    }
    public ChemistryCompound() {
        this(new EnumMap<>(ChemistryElement.class));
    }
    public void set(ChemistryElement element, int count) {
        if(components.containsKey(element)) components.put(element, count);
    }
    public int get(ChemistryElement element) {
        return components.getOrDefault(element, 0);
    }
    public void add(ChemistryCompound compound) {
        this.components = this.components.entrySet().stream().peek((Map.Entry<ChemistryElement, Integer> entry) -> entry.setValue(entry.getValue() + compound.get(entry.getKey()))).collect(() -> new EnumMap<>(ChemistryElement.class), (m, e) -> m.put(e.getKey(), e.getValue()), EnumMap::putAll);
    }
    public ChemistryCompound mix(ChemistryCompound compound) { // Same as add but creates a new ChemistryCompound
        EnumMap<ChemistryElement, Integer> components = this.components.clone();
        components = components.entrySet().stream().peek((Map.Entry<ChemistryElement, Integer> entry) -> entry.setValue(entry.getValue() + compound.get(entry.getKey()))).collect(() -> new EnumMap<>(ChemistryElement.class), (m, e) -> m.put(e.getKey(), e.getValue()), EnumMap::putAll);
        return new ChemistryCompound(components);
    }
    public ChemistryCompound mix(ChemistryElementalCompound element) { // Same as mix, but uses 1 element instead of another ChemsitryComputer
        EnumMap<ChemistryElement, Integer> components = this.components.clone();
        components.put(element.element(), components.getOrDefault(element.element(), 0)+element.count());
        return new ChemistryCompound(components);
    }
    public ChemistryCompound mix(ChemistryElement element) { // Same as mix, but uses 1 element instead of another ChemsitryComputer
        EnumMap<ChemistryElement, Integer> components = this.components.clone();
        components.put(element, components.getOrDefault(element, 0)+1);
        return new ChemistryCompound(components);
    }
    public void divide(int divisor) { // Divide compound amounts by divisor factor. If element count rounds down from <1 to 0, set it to 1
        components.replaceAll((e, v) -> (((double) components.get(e) / divisor < 0.5) && ((double) components.get(e) / divisor != 0)) ? 1 : components.get(e) / divisor);
    }
    public boolean isEmpty() { // Are all components counts equal to 0?
        return components.values().stream().noneMatch(v -> v != 0);
    }
    public static ChemistryCompound elemental(ChemistryElement element, int count) { // e.g ChemistryCompound.elemental(H, 2) for elemental hydrogen
        ChemistryCompound compound = new ChemistryCompound();
        compound.set(element, count);
        return compound;
    }
    public static ChemistryElementalCompound El(ChemistryElement element, int count) { // Used in fromFormula pretty much exclusively, e.g. .fromFormula(El(C, 6), El(H, 12), El(O, 6)) for C6H12O6/glucose
        return new ChemistryElementalCompound(element, count);
    }
    public static ChemistryElementalCompound El(ChemistryElement element) { // Same as El(ChemistryElement, count) but assumes count=1
        return new ChemistryElementalCompound(element, 1);
    }
    public static ChemistryCompound fromFormula(ChemistryElementalCompound... formula) { // Main utility to make compounds quickly. See El for usage example
        ChemistryCompound compound = new ChemistryCompound();
        for(ChemistryElementalCompound v : formula) compound.set(v.element(), v.count());
        return compound;
    }
    @Override
    public String toString() { // Convert to Hill-ordered chemical formula string. Uses Unicode subscripts
        StringBuilder formulaBuilder = new StringBuilder();
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
