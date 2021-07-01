package by.epam.shape.repository.impl;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Rectangle;
import by.epam.shape.repository.RectangleSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.*;

public class AreaRangeSpecificationTest {

    Rectangle rectangle;
    RectangleSpecification specification;
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
        specification = new AreaRangeSpecification(BigDecimal.valueOf(4), BigDecimal.valueOf(6));

    }

    @Test
    public void testSpecify() {
        boolean result = specification.specify(rectangle);
        assertTrue(result);
    }
}