package by.epam.shape.entity;

import by.epam.shape.util.RectangleIdGenerator;

public class Rectangle {
    private long rectangleId;
    private Point leftTopPoint;
    private double side1;
    private double side2;

    public Rectangle(long rectangleId, Point leftTopPoint, double side1, double side2) {
        this.rectangleId = RectangleIdGenerator.generateId();
        this.leftTopPoint = leftTopPoint;
        this.side1 = side1;
        this.side2 = side2;
    }
}
