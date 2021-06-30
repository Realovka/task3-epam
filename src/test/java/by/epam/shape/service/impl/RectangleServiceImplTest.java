package by.epam.shape.service.impl;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Rectangle;
import by.epam.shape.service.RectangleService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.*;

public class RectangleServiceImplTest {

    Rectangle square;
    Rectangle rectangle;
    Rectangle rhombus;
    Rectangle quadrangle;
    RectangleService service;

    @BeforeClass
    public void setUp() {
      square = new Rectangle(new Point(-2, -1), new Point(-1, -1), new Point(-1, -2), new Point(-2, -2));
      rectangle = new Rectangle(new Point(-7,-2), new Point(-3, -2), new Point(-3, -4), new Point(-7, -4));
      rhombus = new Rectangle(new Point(2,3), new Point(3,5), new Point(4, 3), new Point(3, 1));
      quadrangle = new Rectangle(new Point(1, 4), new Point(6,3), new Point(1, 0), new Point(2, 2));
      service = new RectangleServiceImpl();
    }

    @Test
    public void testIsRectangleTrue() {
        boolean result = service.isRectangle(rectangle);
        assertTrue(result);
    }


    @Test
    public void testIsRectangleFalse() {
        boolean result = service.isRectangle(rhombus);
        assertFalse(result);
    }

    @Test
    public void testFindPerimeter() {
        BigDecimal actual = service.findPerimeter(rectangle);
        int result = actual.compareTo(BigDecimal.valueOf(12));
        assertEquals(result, 0);
    }

    @Test
    public void testFindArea() {
        BigDecimal actual = service.findArea(square);
        int result = actual.compareTo(BigDecimal.valueOf(1));
        assertEquals(result, 0);
    }

    @Test
    public void testIsConvexTrue() {
        boolean result = service.isConvex(rectangle);
        assertTrue(result);
    }

    @Test
    public void testIsConvexTestFalse() {
        boolean result = service.isConvex(quadrangle);
        assertFalse(result);
    }

    @Test
    public void testIsRhombusTrue() {
       boolean result = service.isRhombus(rhombus);
       assertTrue(result);
    }

    @Test
    public void testIsRhombusWhenItIsSquareTrue() {
       boolean result = service.isRhombus(square);
       assertTrue(result);
    }


    @Test
    public void testIsSquareTrue() {
        boolean result = service.isSquare(square);
        assertTrue(result);
    }

    @Test
    public void testIsSquareFalse() {
        boolean result = service.isSquare(rectangle);
        assertFalse(result);
    }

    @Test
    public void testIsTrapeze() {
        boolean result = service.isTrapeze(rectangle);
        assertFalse(result);
    }

    @Test
    public void testIsTrapezeWhenItIsRhombus() {
        boolean result = service.isTrapeze(rhombus);
        assertTrue(result);
    }
}