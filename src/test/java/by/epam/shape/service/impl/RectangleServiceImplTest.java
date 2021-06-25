package by.epam.shape.service.impl;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Rectangle;
import by.epam.shape.service.RectangleService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RectangleServiceImplTest {

    Rectangle rectangle;
    RectangleService service;

    @BeforeClass
    public void setUp() {
      rectangle = new Rectangle(new Point(-2, -1), new Point(-1, -1), new Point(-1, -2), new Point(-2, -2));
      service = new RectangleServiceImpl();
    }

    @Test
    public void testIsRectangle() {
    }

    @Test
    public void testFindPerimeter() {
    }

    @Test
    public void testFindArea() {
    }

    @Test
    public void testIsConvex() {
    }

    @Test
    public void testIsRhombus() {
    }

    @Test
    public void testIsSquare() {
        boolean result = service.isSquare(rectangle);
        assertTrue(result);
    }
}