package by.epam.shape.factory.impl;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Rectangle;
import by.epam.shape.exception.RectangleException;
import by.epam.shape.factory.RectangleFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class RectangleFactoryImplTest {

    List<Double> values;
    List<Double> invalidValues;
    List<Double> invalidValuesNotRectangle;
    Rectangle rectangle;
    Point leftTopPoint;
    Point rightTopPoint;
    Point rightBottomPoint;
    Point leftBottomPoint;
    RectangleFactory factory;

    @BeforeClass
    public void setUp() {
        values = List.of(-2.0, -1.0, -1.0, -1.0, -1.0, -2.0, -2.0, -2.0);
        invalidValues = List.of(-2.0, -1.0, -1.0);
        invalidValuesNotRectangle = List.of(-2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0);
        leftTopPoint = new Point(-2.0, -1.0);
        rightTopPoint = new Point(-1.0, -1.0);
        rightBottomPoint = new Point(-1.0, -2.0);
        leftBottomPoint = new Point(-2.0,-2.0);
        rectangle = new Rectangle(leftTopPoint, rightTopPoint, rightBottomPoint, leftBottomPoint);
        factory = new RectangleFactoryImpl();
    }

    @Test
    public void testCreateRectangle() throws RectangleException {
        rectangle.setRectangleId(2);
        Rectangle actual = factory.createRectangle(values);
        assertEquals(actual, rectangle);
    }

    @Test
    public void testCreateRectangleException() {
        Assert.expectThrows(RectangleException.class, () -> factory.createRectangle(invalidValues));
    }

    @Test
    public void testCreateRectangleWhenRectangleIsInvalid() {
        Assert.expectThrows(RectangleException.class, () -> factory.createRectangle(invalidValuesNotRectangle));
    }
}