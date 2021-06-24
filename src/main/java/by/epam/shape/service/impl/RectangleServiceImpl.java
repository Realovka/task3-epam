package by.epam.shape.service.impl;

import by.epam.shape.entity.Rectangle;
import by.epam.shape.service.RectangleService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class RectangleServiceImpl implements RectangleService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean isRectangle(Rectangle rectangle) {
        if (!(rectangle.getLeftTopPoint().getX() - rectangle.getRightTopPoint().getX() /
                rectangle.getRightBottomPoint().getX() - rectangle.getRightTopPoint().getX() ==
                rectangle.getLeftTopPoint().getY() - rectangle.getRightTopPoint().getY() /
                        rectangle.getRightBottomPoint().getY() - rectangle.getRightTopPoint().getY())) {
            logger.log(Level.INFO, "It is rectangle " + rectangle);
            return true;
        } else {
            logger.log(Level.INFO, "It isn't rectangle " + rectangle);
            return false;
        }
    }

    @Override
    public double findPerimeter(Rectangle rectangle) {
        double height = findHeight(rectangle);
        double width = findWidth(rectangle);
        double perimeter = (height + width) * 2;
        logger.log(Level.INFO, "Perimeter of rectangle is " + perimeter);
        return perimeter;
    }

    @Override
    public double findArea (Rectangle rectangle) {
        double area = findHeight(rectangle) * findWidth(rectangle);
        logger.log(Level.INFO, "Area of rectangle is " + area);
        return area;
    }



    private double findHeight(Rectangle rectangle) {
        double height = rectangle.getLeftTopPoint().getY() - rectangle.getRightBottomPoint().getY();
        logger.log(Level.INFO, "Height of rectangle is " + height);
        return height;
    }

    private double findWidth(Rectangle rectangle) {
        double width = rectangle.getRightBottomPoint().getX() - rectangle.getLeftTopPoint().getX();
        logger.log(Level.INFO, "Width of rectangle is " + width);
        return width;
    }
}
