package by.epam.shape.repository.impl;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Rectangle;
import by.epam.shape.repository.RectangleSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class FirstQuarterSpecificationTest {

    Rectangle rectangle;
    Point leftTopPoint;
    Point rightTopPoint;
    Point rightBottomPoint;
    Point leftBottomPoint;
    Rectangle rectangle1;
    Point leftTopPoint1;
    Point rightTopPoint1;
    Point rightBottomPoint1;
    Point leftBottomPoint1;
    RectangleSpecification specification;

    @BeforeMethod
    public void setUp() {
        leftTopPoint = new Point(-2.0, -1.0);
        rightTopPoint = new Point(-1.0, -1.0);
        rightBottomPoint = new Point(-1.0, -2.0);
        leftBottomPoint = new Point(-2.0, -2.0);
        rectangle = new Rectangle(leftTopPoint, rightTopPoint, rightBottomPoint, leftBottomPoint);
        leftTopPoint1 = new Point(2, 4);
        rightTopPoint1 = new Point(5, 4);
        rightBottomPoint1 = new Point(5, 2);
        leftBottomPoint1 = new Point(2, 2);
        rectangle1 = new Rectangle(leftTopPoint1, rightTopPoint1, rightBottomPoint1, leftBottomPoint1);
        specification = new FirstQuarterSpecification();
    }

    @Test
    public void testSpecify() {
        boolean result = specification.specify(rectangle1);
        assertTrue(result);
    }

    @Test
    public void testSpecifyFalse() {
        boolean result = specification.specify(rectangle);
        assertFalse(result);
    }
}