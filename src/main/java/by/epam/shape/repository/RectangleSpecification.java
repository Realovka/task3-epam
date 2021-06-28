package by.epam.shape.repository;

import by.epam.shape.entity.Rectangle;

@FunctionalInterface
public interface RectangleSpecification {
    boolean specify(Rectangle rectangle);
}
