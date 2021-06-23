package by.epam.shape.reader;

import by.epam.shape.exception.RectangleException;

import java.util.List;

public interface RectangleReader {
    List<String> readStringFromFile(String pathToFile) throws RectangleException;
}
