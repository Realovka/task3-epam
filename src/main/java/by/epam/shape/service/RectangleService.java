package by.epam.shape.service;

import by.epam.shape.entity.Rectangle;

public interface RectangleService {
    boolean isRectangle(Rectangle rectangle);
    double findPerimeter(Rectangle rectangle);
    double findArea (Rectangle rectangle);
}
