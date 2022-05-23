package pl.luckit.test.validator;

public final class DivideInputValidator {

    private DivideInputValidator() {
    }

    public static boolean isValid(Double val1, Double val2) {
        if (val1 == null || val2 == null) {
            return false;
        }
        return val2 != 0;
    }
}
