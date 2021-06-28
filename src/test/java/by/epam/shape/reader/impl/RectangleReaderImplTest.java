package by.epam.shape.reader.impl;

import by.epam.shape.exception.RectangleException;
import by.epam.shape.reader.RectangleReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static org.testng.Assert.*;

public class RectangleReaderImplTest {

    RectangleReader reader;

    @BeforeClass
    public void setUp() {
        reader = new RectangleReaderImpl();
    }

    @Test
    public void testReadStringFromFile() throws RectangleException {
        File file = new File(getClass().getClassLoader().getResource("file/rectangle_data.txt").getFile());
        String path = file.getAbsolutePath();
        List<String> actual = reader.readStringFromFile(path);
        List<String> expected = List.of("-2.0 -1.0 -1.0 -1.0 -1.0 -2.0 -2.0 -2.0", "-3.0 2.0 3.0 2.0 3.0 0.0 -3.0 0.0");
        assertEquals(actual, expected);
    }

    @Test
    public void testReadStringFromFileException() {
        Assert.expectThrows(RectangleException.class, () -> reader.readStringFromFile("file/rectangle.txt"));
    }
}