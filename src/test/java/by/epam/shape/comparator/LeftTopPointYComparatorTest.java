package by.epam.shape.comparator;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Rectangle;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LeftTopPointYComparatorTest {

    Rectangle first;
    Rectangle second;
    Rectangle third;
    LeftTopPointYComparator comparator;

    @BeforeMethod
    public void setUp() {
        first = new Rectangle(new Point(2.0, 4.0), new Point(5.0, 4.0), new Point(5.0, 2.0), new Point(2.0, 2.0));
        second = new Rectangle(new Point(-2.0, -1.0), new Point(-1.0, -1.0), new Point(-1.0, -2.0), new Point(-2.0, -2.0));
        third = new Rectangle(new Point(-2.0, -1.0), new Point(0.0, -1.0), new Point(0.0, -2.0), new Point(-2.0, -2.0));
        comparator = new LeftTopPointYComparator();
    }

    @Test
    public void testCompareFirstGreaterSecond() {
        int result = comparator.compare(first, third);
        boolean actual = result > 0;
        assertTrue(actual);
    }

    @Test
    public void testCompareSecondGreaterFirst() {
        int result = comparator.compare(second, first);
        boolean actual = result < 0;
        assertTrue(actual);
    }


    @Test
    public void testCompareEquals() {
        int result = comparator.compare(second, third);
        boolean actual = result == 0;
        assertTrue(actual);
    }

}