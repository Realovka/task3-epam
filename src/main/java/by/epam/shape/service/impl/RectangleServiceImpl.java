package by.epam.shape.service.impl;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Rectangle;
import by.epam.shape.service.RectangleService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;


public class RectangleServiceImpl implements RectangleService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean isRectangle(Rectangle rectangle) {
        if (areAllRightAngles(rectangle)) {
            logger.log(Level.INFO, "It is rectangle " + rectangle);
            return true;
        } else {
            logger.log(Level.INFO, "It isn't rectangle " + rectangle);
            return false;
        }
    }

    @Override
    public BigDecimal findPerimeter(Rectangle rectangle) {
        BigDecimal width = findWidth(rectangle);
        BigDecimal length = findLength(rectangle);
        BigDecimal perimeter = (width.add(length)).multiply(BigDecimal.valueOf(2));
        logger.log(Level.INFO, "Perimeter of rectangle is " + perimeter);
        return perimeter;
    }

    @Override
    public BigDecimal findArea(Rectangle rectangle) {
        BigDecimal area = findWidth(rectangle).multiply(findLength(rectangle));
        logger.log(Level.INFO, "Area of rectangle is " + area);
        return area;
    }

    //if all angles are 90 degrees
    @Override
    public boolean isConvex(Rectangle rectangle) {
        if (areAllRightAngles(rectangle)) {
            logger.log(Level.INFO, "Rectangle is convex");
            return true;
        } else {
            logger.log(Level.INFO, "Rectangle isn't convex");
        }
        return false;
    }

    @Override
    public boolean isRhombus(Rectangle rectangle) {
        if (findWidth(rectangle).equals(findLength(rectangle))) {
            logger.log(Level.INFO, "This shape is rhombus " + rectangle);
            return true;
        } else {
            logger.log(Level.INFO, "This shape isn't rhombus " + rectangle);
            return false;
        }
    }

    @Override
    public boolean isSquare(Rectangle rectangle) {
        if (findWidth(rectangle).equals(findLength(rectangle)) && areAllRightAngles(rectangle)) {
            logger.log(Level.INFO, "This shape is square " + rectangle);
            return true;
        } else {
            logger.log(Level.INFO, "This shape isn't square " + rectangle);
            return false;
        }
    }

    @Override
    public boolean isTrapeze(Rectangle rectangle) {
        if ((rectangle.getLeftTopPoint().getX() != rectangle.getLeftBottomPoint().getX() ||
                rectangle.getRightTopPoint().getX() != rectangle.getRightBottomPoint().getX() &&
                        rectangle.getLeftTopPoint().getY() == rectangle.getRightTopPoint().getY() &&
                        rectangle.getLeftBottomPoint().getY() == rectangle.getRightBottomPoint().getY()) ||
                (rectangle.getLeftTopPoint().getY() != rectangle.getRightTopPoint().getY() ||
                        rectangle.getLeftBottomPoint().getY() != rectangle.getRightBottomPoint().getY() &&
                                rectangle.getLeftTopPoint().getY() == rectangle.getLeftBottomPoint().getY() &&
                                rectangle.getRightTopPoint().getY() == rectangle.getRightBottomPoint().getY())) {
            logger.log(Level.INFO, "This shape is trapeze " + rectangle);
            return true;
        }
        logger.log(Level.INFO, "This shape isn't trapeze " + rectangle);
        return false;
    }

    @Override
    public BigDecimal findWidth(Rectangle rectangle) {
        double firstCoordinateVectorHeight = rectangle.getLeftTopPoint().getX() - rectangle.getLeftBottomPoint().getX();
        double secondCoordinateVectorHeight = rectangle.getLeftTopPoint().getY() - rectangle.getLeftBottomPoint().getY();
        double width = Math.sqrt(Math.pow(firstCoordinateVectorHeight, 2) + Math.pow(secondCoordinateVectorHeight, 2));
        logger.log(Level.INFO, "Height of rectangle is " + width);
        return BigDecimal.valueOf(width);
    }

    @Override
    public BigDecimal findLength(Rectangle rectangle) {
        double firstCoordinateVectorWidth = rectangle.getRightBottomPoint().getX() - rectangle.getLeftBottomPoint().getX();
        double secondCoordinateVectorWidth = rectangle.getRightBottomPoint().getY() - rectangle.getLeftBottomPoint().getY();
        double length = Math.sqrt(Math.pow(firstCoordinateVectorWidth, 2) + Math.pow(secondCoordinateVectorWidth, 2));
        logger.log(Level.INFO, "Width of rectangle is " + length);
        return BigDecimal.valueOf(length);
    }

    private double findTheFirstCoordinateVector(Point first, Point second) {
        return second.getX() - first.getX();
    }

    private double findTheSecondCoordinateVector(Point first, Point second) {
        return second.getY() - first.getY();
    }

    private boolean isRightAngleBetweenVectors(Point first, Point second, Point third) {
        double firstCoordinateFirstVector = findTheFirstCoordinateVector(first, second);
        double secondCoordinateFirstVector = findTheSecondCoordinateVector(first, second);
        double firstCoordinateSecondVector = findTheFirstCoordinateVector(first, third);
        double secondCoordinateSecondVector = findTheSecondCoordinateVector(first, third);
        if (firstCoordinateFirstVector * firstCoordinateSecondVector + secondCoordinateFirstVector * secondCoordinateSecondVector == 0) {
            logger.log(Level.INFO, "Angle between vector {}  is right", first, second, third);
            return true;
        } else {
            logger.log(Level.INFO, "Angle between vector {}  isn't right", first, second, third);
            return false;
        }
    }

    private boolean areAllRightAngles(Rectangle rectangle) {
        if (isRightAngleBetweenVectors(rectangle.getLeftTopPoint(), rectangle.getRightTopPoint(), rectangle.getLeftBottomPoint()) &&
                isRightAngleBetweenVectors(rectangle.getRightTopPoint(), rectangle.getRightBottomPoint(), rectangle.getLeftTopPoint()) &&
                isRightAngleBetweenVectors(rectangle.getLeftBottomPoint(), rectangle.getLeftTopPoint(), rectangle.getRightBottomPoint()) &&
                isRightAngleBetweenVectors(rectangle.getRightBottomPoint(), rectangle.getRightTopPoint(), rectangle.getLeftBottomPoint())) {
            logger.log(Level.INFO, "All angles of shape {} are right", rectangle);
            return true;
        } else {
            logger.log(Level.INFO, "Not all angles of shape {} are right", rectangle);
        }
        return false;
    }

}
