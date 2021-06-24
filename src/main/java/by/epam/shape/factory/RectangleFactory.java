package by.epam.shape.factory;

import by.epam.shape.entity.Rectangle;
import by.epam.shape.exception.RectangleException;

import java.util.List;

public interface RectangleFactory {
    Rectangle createRectangle(List<Double> parameters) throws RectangleException;
}
