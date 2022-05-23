package pl.luckit.test.validator;

public final class AddInputValidator {

    private AddInputValidator() {
    }

    public static boolean isValid(Double val1, Double val2) {
        return val1 != null && val2 != null;
    }
}
