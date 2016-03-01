package ivan.pronin.c2.accounting.model.enums;

/**
 * Created by Администратор on 26.02.2016.
 */
public enum TaxType {

    NDS, PODOHODNY;

    public static TaxType parse(String name) {
        for (TaxType t : TaxType.values()) {
            if (name.equalsIgnoreCase(t.name())) {
                return t;
            }
        }
        throw new IllegalArgumentException("Failed to find TaxType for name: " + name);
    }
}
