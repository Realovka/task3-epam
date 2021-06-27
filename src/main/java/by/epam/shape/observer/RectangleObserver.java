package by.epam.shape.observer;

import by.epam.shape.exception.RectangleException;

public interface RectangleObserver {
    void changeParameters(RectangleEvent event) throws RectangleException;
}
