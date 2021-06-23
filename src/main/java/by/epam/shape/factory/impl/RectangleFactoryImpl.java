package by.epam.shape.factory.impl;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Rectangle;
import by.epam.shape.exception.RectangleException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RectangleFactoryImpl {
    private static final Logger logger = LogManager.getLogger();
    private static final int NUMBER_PARAMETERS = 8;

    public Rectangle createRectangle(List<Double> parameters) throws RectangleException{
        if (parameters.size() < NUMBER_PARAMETERS) {
            logger.log(Level.ERROR, "Invalid argument count " + parameters);
            throw new RectangleException();
        }
        Point leftTopPoint = new Point(parameters.get(0), parameters.get(1));
        Point rightTopPoint = new Point(parameters.get(2), parameters.get(3));
        Point rightBottomPoint = new Point(parameters.get(4), parameters.get(5));
        Point leftBottomPoint = new Point(parameters.get(6), parameters.get(7));
        return new Rectangle(leftTopPoint, rightTopPoint, rightBottomPoint, leftBottomPoint);
    }

}
