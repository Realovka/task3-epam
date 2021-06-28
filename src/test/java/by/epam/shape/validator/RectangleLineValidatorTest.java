package by.epam.shape.validator;

import by.epam.shape.entity.Point;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class RectangleLineValidatorTest {

    @Test
    public void testValidateRectangle() {
        List<Point> points = List.of(new Point(-2.0, -2.0), new Point(-2.0, -2.0), new Point( -2.0, -2.0), new Point( -2.0, -2.0));
        boolean result = RectangleValidator.validateRectangle(points);
        assertFalse(result);
    }

    @Test
    public void testValidateRectangleTrue() {
        List<Point> points = List.of(new Point(-2.0, 1.0), new Point( 2.0, 1.0), new Point(  2.0, -1.0), new Point(  -2.0, -1.0));
        boolean result = RectangleValidator.validateRectangle(points);
        assertTrue(result);
    }
}
