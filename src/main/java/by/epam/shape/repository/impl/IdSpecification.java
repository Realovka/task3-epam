package by.epam.shape.repository.impl;

import by.epam.shape.entity.Rectangle;
import by.epam.shape.repository.RectangleSpecification;

public class IdSpecification implements RectangleSpecification {
    private Long id;

    public IdSpecification(Long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Rectangle rectangle) {
        return rectangle.getRectangleId() > id;
    }
}
