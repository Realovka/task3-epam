package by.epam.shape.validator;

public class RectangleLineValidator {
    private static final String VALIDATING_RECTANGLE_PARAMETERS = "\\^[-+]?\\d+\\.\\d+\\s+[-+]?\\d+\\.\\d+\\s+\\d+\\.\\d+\\s+\\d+\\.\\d+$";
    private static final String VALIDATING_RECTANGLE_ZERO_PARAMETERS = "^[-+]?\\d+\\.\\d+\\s+[-+]?\\d+\\.\\d+\\s+0+\\.0+\\s+0+\\.0+$";


    public static boolean validateParameters (String line) {
        return (line.matches(VALIDATING_RECTANGLE_PARAMETERS) && !line.matches(VALIDATING_RECTANGLE_ZERO_PARAMETERS));
    }
}
