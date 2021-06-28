package by.epam.shape.parser.impl;

import by.epam.shape.exception.RectangleException;
import by.epam.shape.parser.RectangleParser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class RectangleParserImplTest {

    RectangleParser parser;
    List<String> lines;
    List<String> emptyList;

    @BeforeMethod
    public void setUp() {
        parser = new RectangleParserImpl();
        lines = List.of("-2.0 -1.0 -1.0 -1.0 -1.0 -2.0 -2.0 -2.0", "-3.0 2.0 3.0 2.0 3.0 0.0 -3.0 0.0");
        emptyList = new ArrayList<>();
    }

    @Test
    public void testParse() throws RectangleException {
        List<Double> values = parser.parse(lines);
        List<Double> expected =  List.of(-2.0, -1.0, -1.0, -1.0, -1.0, -2.0, -2.0, -2.0, -3.0, 2.0, 3.0, 2.0, 3.0, 0.0, -3.0, 0.0);
        assertEquals(values, expected);
    }

    @Test
    public void testParseException() {
        Assert.expectThrows(RectangleException.class, () -> parser.parse(emptyList));
    }
}