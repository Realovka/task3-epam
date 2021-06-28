package by.epam.shape.entity;

import by.epam.shape.exception.RectangleException;
import by.epam.shape.observer.RectangleEvent;
import by.epam.shape.observer.RectangleObservable;
import by.epam.shape.observer.RectangleObserver;
import by.epam.shape.util.RectangleIdGenerator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements RectangleObservable {
    private long rectangleId;
    private Point leftTopPoint;
    private Point rightTopPoint;
    private Point rightBottomPoint;
    private Point leftBottomPoint;
    private List<RectangleObserver> observers = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger();

    public Rectangle() {
    }

    public Rectangle(Point leftTopPoint, Point rightTopPoint, Point rightBottomPoint, Point leftBottomPoint) {
        this.rectangleId = RectangleIdGenerator.generateId();
        this.leftTopPoint = leftTopPoint;
        this.rightTopPoint = rightTopPoint;
        this.rightBottomPoint = rightBottomPoint;
        this.leftBottomPoint = leftBottomPoint;
    }

    public long getRectangleId() {
        return rectangleId;
    }

    public void setRectangleId(long rectangleId) {
        this.rectangleId = rectangleId;
    }

    public Point getLeftTopPoint() {
        return leftTopPoint;
    }

    public void setLeftTopPoint(Point leftTopPoint) throws RectangleException{
        this.leftTopPoint = leftTopPoint;
        logger.log(Level.INFO, "Set new leftTopPoint to rectangle " + leftTopPoint);
        notifyObservers();
    }

    public Point getRightTopPoint() {
        return rightTopPoint;
    }

    public void setRightTopPoint(Point rightTopPoint) throws RectangleException{
        this.rightTopPoint = rightTopPoint;
        logger.log(Level.INFO, "Set new rightTopPoint to rectangle " + rightTopPoint);
        notifyObservers();
    }

    public Point getRightBottomPoint() {
        return rightBottomPoint;
    }

    public void setRightBottomPoint(Point rightBottomPoint) throws RectangleException{
        this.rightBottomPoint = rightBottomPoint;
        logger.log(Level.INFO, "Set new rightBottomPoint to rectangle " + rightBottomPoint);
        notifyObservers();
    }

    public Point getLeftBottomPoint() {
        return leftBottomPoint;
    }

    public void setLeftBottomPoint(Point leftBottomPoint) throws RectangleException{
        this.leftBottomPoint = leftBottomPoint;
        logger.log(Level.INFO, "Set new leftBottomPoint to rectangle " + leftBottomPoint);
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return rectangle.rectangleId == rectangleId &&
               rectangle.getLeftTopPoint().equals(leftTopPoint) &&
               rectangle.getRightTopPoint().equals(rightTopPoint) &&
               rectangle.getRightBottomPoint().equals(rightBottomPoint) &&
               rectangle.getLeftBottomPoint().equals(leftBottomPoint);
    }

    @Override
    public int hashCode() {
        return (int) rectangleId * leftTopPoint.hashCode()
                * rightTopPoint.hashCode() * rightBottomPoint.hashCode() * leftBottomPoint.hashCode();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Rectangle {");
        builder.append("rectangleId = ").append(rectangleId);
        builder.append(" leftTopPoint = [").append(leftTopPoint.getX()).append("; ").append(leftTopPoint.getY()).append("]");
        builder.append(" rightTopPoint = [").append(rightTopPoint.getX()).append("; ").append(rightTopPoint.getY()).append("]");
        builder.append(" rightBottomPoint = [").append(rightBottomPoint.getX()).append("; ").append(rightBottomPoint.getY()).append("]");
        builder.append(" leftBottomPoint = [").append(leftBottomPoint.getX()).append("; ").append(leftBottomPoint.getY()).append("]}");
        return builder.toString();
    }

    @Override
    public void attach(RectangleObserver observer) {
            observers.add(observer);
    }

    @Override
    public void detach(RectangleObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() throws RectangleException {
        RectangleEvent event = new RectangleEvent(this);
        for (RectangleObserver observer : observers) {
            observer.changeParameters(event);
        }
    }
}
