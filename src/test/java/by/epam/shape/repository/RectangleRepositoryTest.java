package by.epam.shape.repository;

import by.epam.shape.comparator.*;
import by.epam.shape.entity.Point;
import by.epam.shape.entity.Rectangle;
import by.epam.shape.repository.impl.AreaRangeSpecification;
import by.epam.shape.repository.impl.FirstQuarterSpecification;
import by.epam.shape.repository.impl.IdSpecification;
import by.epam.shape.repository.impl.PerimeterRangeSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class RectangleRepositoryTest {
    Rectangle first;
    Rectangle second;
    Rectangle third;
    List<Rectangle> rectangles;
    RectangleRepository repository;
    RectangleSpecification firstQuarterSpecification;
    RectangleSpecification idSpecification;
    RectangleSpecification perimeterSpecification;
    RectangleSpecification perimeterSpecification2;
    RectangleSpecification perimeterSpecification3;
    RectangleSpecification areaSpecification;
    RectangleSpecification areaSpecification2;
    RectangleSpecification areaSpecification3;
    LeftTopPointXComparator leftTopPointXComparator;
    LeftTopPointYComparator leftTopPointYComparator;
    LengthComparator lengthComparator;
    WidthComparator widthComparator;
    PerimeterComparator perimeterComparator;
    AreaComparator areaComparator;
    List<Rectangle> actual;


    @BeforeMethod
    public void setUp() {
        actual = new ArrayList<>();
        repository = RectangleRepository.getInstance();
        firstQuarterSpecification = new FirstQuarterSpecification();
        idSpecification = new IdSpecification(5L);
        perimeterSpecification = new PerimeterRangeSpecification(BigDecimal.valueOf(6), BigDecimal.valueOf(18));
        perimeterSpecification2 = new PerimeterRangeSpecification(BigDecimal.valueOf(3), BigDecimal.valueOf(11));
        perimeterSpecification3 = new PerimeterRangeSpecification(BigDecimal.valueOf(40), BigDecimal.valueOf(45));
        areaSpecification = new AreaRangeSpecification(BigDecimal.valueOf(1), BigDecimal.valueOf(19));
        areaSpecification2 = new AreaRangeSpecification(BigDecimal.valueOf(2), BigDecimal.valueOf(6));
        areaSpecification3 = new AreaRangeSpecification(BigDecimal.valueOf(20), BigDecimal.valueOf(26));
        leftTopPointXComparator = new LeftTopPointXComparator();
        leftTopPointYComparator = new LeftTopPointYComparator();
        lengthComparator = new LengthComparator();
        widthComparator = new WidthComparator();
        perimeterComparator = new PerimeterComparator();
        areaComparator = new AreaComparator();
        rectangles = new ArrayList<>();
        first = new Rectangle(new Point(2.0, 4.0), new Point(5.0, 4.0), new Point(5.0, 2.0), new Point(2.0, 2.0));
        second = new Rectangle(new Point(-3.0, 3.0), new Point(3.0, 3.0), new Point(3.0, 0.0), new Point(-3.0, 0.0));
        third = new Rectangle(new Point(-2.0, -1.0), new Point(0.0, -1.0), new Point(0.0, -2.0), new Point(-2.0, -2.0));
        rectangles.add(first);
        rectangles.add(second);
        rectangles.add(third);
        repository.addAllRectangles(rectangles);
    }

    @AfterMethod
    public void tearDown(){
        repository.removeAll(rectangles);
    }

    @Test(priority = 2)
    public void testQueryFirstQuarterSpecification() {
        List<Rectangle> actual = repository.query(firstQuarterSpecification);
        List<Rectangle> expected = List.of(new Rectangle(new Point(2.0, 4.0), new Point(5.0, 4.0), new Point(5.0, 2.0), new Point(2.0, 2.0)));
        assertEquals(actual.get(0).getLeftTopPoint(), expected.get(0).getLeftTopPoint());
    }

    @Test
    public void testQueryIdSpecification() {
        List<Rectangle> actual = repository.query(idSpecification);
        assertEquals(actual.size(), 0);
    }

    @Test(priority = 2)
    public void testQueryPerimeterRangeSpecificationAllRectanglesRight() {
        List<Rectangle> actual = repository.query(perimeterSpecification);
        assertEquals(actual.size(), 3);
    }

    @Test(priority = 2)
    public void testQueryPerimeterRangeSpecificationTwoRectanglesRight() {
        List<Rectangle> actual = repository.query(perimeterSpecification2);
        assertEquals(actual.size(), 2);
    }

    @Test(priority = 2)
    public void testQueryPerimeterRangeSpecificationNoRightRectangle() {
        List<Rectangle> actual = repository.query(perimeterSpecification3);
        assertEquals(actual.size(), 0);
    }

    @Test(priority = 2)
    public void testQueryAreaRangeSpecificationAllRectanglesRight() {
        List<Rectangle> actual = repository.query(areaSpecification);
        assertEquals(actual.size(), 3);
    }

    @Test(priority = 2)
    public void testQueryAreaRangeSpecificationTwoRectanglesRight() {
        List<Rectangle> actual = repository.query(areaSpecification2);
        assertEquals(actual.size(), 2);
    }

    @Test(priority = 2)
    public void testQueryAreaRangeSpecificationNoRightRectangle() {
        List<Rectangle> actual = repository.query(areaSpecification3);
        assertEquals(actual.size(), 0);
    }

    @Test(priority = 2)
    public void testSortLeftTopPointXComparator() {
        List<Rectangle> actual = new ArrayList<>();
        actual = repository.sort(leftTopPointXComparator);
        List<Rectangle> expected = new ArrayList<>();
        expected.add(second);
        expected.add(third);
        expected.add(first);
        assertEquals(actual, expected);
    }

    @Test(priority = 2)
    public void testSortLeftTopPointYComparator() {
        List<Rectangle> actual = repository.sort(leftTopPointYComparator);
        List<Rectangle> expected = new ArrayList<>();
        expected.add(third);
        expected.add(second);
        expected.add(first);
        assertEquals(actual, expected);
    }

    @Test(priority = 2)
    public void testSortLengthComparator() {
        List<Rectangle> actual = repository.sort(lengthComparator);
        List<Rectangle> expected = new ArrayList<>();
        expected.add(third);
        expected.add(first);
        expected.add(second);
        assertEquals(actual, expected);
    }
}