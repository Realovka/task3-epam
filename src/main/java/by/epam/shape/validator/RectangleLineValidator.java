package by.epam.shape.validator;

public class RectangleLineValidator {
    private static final String VALIDATING_RECTANGLE_PARAMETERS = "^[-+]?\\d+\\.\\d+\\s+[-+]?\\d+\\.\\d+\\s+[-+]?\\d+\\.\\d+\\s+[-+]?\\d+\\.\\d+\\s+[-+]?\\d+\\.\\d+\\s+[-+]?\\d+\\.\\d+\\s+[-+]?\\d+\\.\\d+\\s+[-+]?\\d+\\.\\d+$";

    public static boolean validateParameters (String line) {
        return line.matches(VALIDATING_RECTANGLE_PARAMETERS);
    }
}
