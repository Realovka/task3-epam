package by.epam.shape.repository.impl;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Rectangle;
import by.epam.shape.repository.RectangleSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.*;

public class PerimeterRangeSpecificationTest {

    Rectangle rectangle;
    RectangleSpecification specification;
    RectangleSpecification specificationFalse;
    Point leftTopPoint;
    Point rightTopPoint;
    Point rightBottomPoint;
    Point leftBottomPoint;

    @BeforeMethod
    public void setUp() {
        leftTopPoint = new Point(2, 4);
        rightTopPoint = new Point(5, 4);
        rightBottomPoint = new Point(5, 2);
        leftBottomPoint = new Point(2, 2);
        rectangle = new Rectangle(leftTopPoint, rightTopPoint, rightBottomPoint, leftBottomPoint);
        specification = new PerimeterRangeSpecification(BigDecimal.valueOf(1), BigDecimal.valueOf(10));
        specificationFalse = new PerimeterRangeSpecification(BigDecimal.valueOf(1), BigDecimal.valueOf(5));
    }

    @Test
    public void testSpecify() {
        boolean result = specification.specify(rectangle);
        assertTrue(result);
    }

    @Test
    public void testSpecifyFalse() {
        boolean result = specificationFalse.specify(rectangle);
        assertFalse(result);
    }
}