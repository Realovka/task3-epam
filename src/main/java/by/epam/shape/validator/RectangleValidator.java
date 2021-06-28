package by.epam.shape.validator;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Rectangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RectangleValidator {
    private static final Logger logger = LogManager.getLogger();

    public static boolean validateRectangle(List<Point> points) {
        boolean fistAngle = isRightAngleBetweenVectors(points.get(0), points.get(1), points.get(2));
        boolean secondAngle = isRightAngleBetweenVectors(points.get(1), points.get(2), points.get(3));
        boolean thirdAngle = isRightAngleBetweenVectors(points.get(2), points.get(3), points.get(0));
        boolean forthAngle = isRightAngleBetweenVectors(points.get(3), points.get(0), points.get(1));
        if ((fistAngle && secondAngle && thirdAngle && forthAngle) &&
                (!points.get(0).equals(points.get(1)) && !points.get(0).equals(points.get(2)) && !points.get(0).equals(points.get(3)))) {
            return true;
        }
        return false;
    }


    private static boolean isRightAngleBetweenVectors(Point first, Point second, Point third) {
        double firstCoordinateFirstVector = findTheFirstCoordinateVector(first, second);
        double secondCoordinateFirstVector = findTheSecondCoordinateVector(first, second);
        double firstCoordinateSecondVector = findTheFirstCoordinateVector(third, second);
        double secondCoordinateSecondVector = findTheSecondCoordinateVector(third, second);
        if (firstCoordinateFirstVector * firstCoordinateSecondVector + secondCoordinateFirstVector * secondCoordinateSecondVector == 0) {
            logger.log(Level.INFO, "Angle between vector {}  is right", first, second, third);
            return true;
        } else {
            logger.log(Level.INFO, "Angle between vector {}  isn't right", first, second, third);
            return false;
        }
    }

    private static double findTheFirstCoordinateVector(Point second, Point first) {
        return second.getX() - first.getX();
    }

    private static double findTheSecondCoordinateVector(Point second, Point first) {
        return second.getY() - first.getY();
    }

}
