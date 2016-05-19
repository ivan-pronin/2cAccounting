package ivan.pronin.c2.accounting.util;

/**
 * Created by Администратор on 16.05.2016.
 */
public enum TransactionDirection {

    IN, OUT;

    public static TransactionDirection getDirection(int tabIndex) {
        if (0 == tabIndex) {
            return IN;
        } else if (1 == tabIndex) {
            return OUT;
        } else {
            throw new IllegalArgumentException("Could not define TransactionDirection for tabIndex: " + tabIndex);
        }
    }

    public static boolean isInDirection(int tabIndex) {
        return 0 == tabIndex;
    }

    public static boolean isOutDirection(int tabIndex) {
        return 1 == tabIndex;
    }

}
