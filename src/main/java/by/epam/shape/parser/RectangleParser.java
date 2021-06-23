package by.epam.shape.parser;

import by.epam.shape.exception.RectangleException;

import java.util.List;

public interface RectangleParser {
    List<Double> parse (List<String> correctLines) throws RectangleException;
}
