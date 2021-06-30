package by.epam.shape.repository.impl;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Rectangle;
import by.epam.shape.repository.RectangleSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IdSpecificationTest {

    Rectangle rectangle;
    RectangleSpecification specification;
    RectangleSpecification rectangleSpecification;

    @BeforeMethod
    public void setUp() {
        specification = new IdSpecification(4L);
        rectangleSpecification = new IdSpecification(8L);
        rectangle = new Rectangle(new Point(), new Point(), new Point(), new Point());
        rectangle.setRectangleId(5L);
    }

    @Test
    public void testSpecify() {
       boolean result = specification.specify(rectangle);
       assertTrue(result);
    }

    @Test
    public void testSpecifyFalse() {
        boolean result = rectangleSpecification.specify(rectangle);
        assertFalse(result);
    }
}