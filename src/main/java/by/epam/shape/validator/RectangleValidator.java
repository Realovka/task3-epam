package by.epam.shape.validator;

import by.epam.shape.entity.Point;
import by.epam.shape.exception.RectangleException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RectangleValidator {
    private static final Logger logger = LogManager.getLogger();

    public static boolean validateRectangle(List<Point> points) {
        return points.get(0).getX() == points.get(3).getX() &&
                points.get(0).getY() == points.get(1).getY() &&
                points.get(2).getX() == points.get(1).getX() &&
                points.get(2).getY() == points.get(3).getY();
    }
}
