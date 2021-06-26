package by.epam.shape.service;

import by.epam.shape.entity.Rectangle;

import java.math.BigDecimal;

public interface RectangleService {
    boolean isRectangle(Rectangle rectangle);
    BigDecimal findPerimeter(Rectangle rectangle);
    BigDecimal findArea (Rectangle rectangle);
    boolean isConvex(Rectangle rectangle);
    boolean isRhombus(Rectangle rectangle);
    boolean isSquare(Rectangle rectangle);
    boolean isTrapeze(Rectangle rectangle);
}
