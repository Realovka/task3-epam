package by.epam.shape.observer;

import by.epam.shape.entity.Rectangle;

import java.util.EventObject;

public class RectangleEvent extends EventObject {

    public RectangleEvent(Object source) {
        super(source);
    }

    @Override
    public Rectangle getSource() {
        return (Rectangle) super.getSource();
    }
}
