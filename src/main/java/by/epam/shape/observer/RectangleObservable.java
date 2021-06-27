package by.epam.shape.observer;

import by.epam.shape.exception.RectangleException;

public interface RectangleObservable {
    void attach(RectangleObserver observer);
    void detach(RectangleObserver observer);
    void notifyObservers() throws RectangleException;
}
