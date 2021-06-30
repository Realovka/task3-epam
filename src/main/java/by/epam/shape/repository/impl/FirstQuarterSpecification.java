package by.epam.shape.repository.impl;

import by.epam.shape.entity.Rectangle;
import by.epam.shape.repository.RectangleSpecification;

public class FirstQuarterSpecification implements RectangleSpecification {

    @Override
    public boolean specify(Rectangle rectangle) {
        return rectangle.getLeftTopPoint().getX() > 0 && rectangle.getLeftTopPoint().getY() > 0 &&
                rectangle.getRightBottomPoint().getX() > 0 && rectangle.getRightBottomPoint().getY() > 0 &&
                rectangle.getRightBottomPoint().getX() > 0 && rectangle.getRightBottomPoint().getY() > 0 &&
                rectangle.getLeftBottomPoint().getX() > 0 && rectangle.getLeftBottomPoint().getY() > 0;
    }
}

