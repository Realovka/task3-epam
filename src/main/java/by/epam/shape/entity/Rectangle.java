package by.epam.shape.entity;

import by.epam.shape.util.RectangleIdGenerator;

public class Rectangle {
    private long rectangleId;
    private Point leftTopPoint;
    private Point rightTopPoint;
    private Point rightBottomPoint;
    private Point leftBottomPoint;

    public Rectangle(long rectangleId, Point leftTopPoint, Point rightTopPoint, Point rightBottomPoint, Point leftBottomPoint) {
        this.rectangleId = RectangleIdGenerator.generateId();
        this.leftTopPoint = leftTopPoint;
        this.rightTopPoint = rightTopPoint;
        this.rightBottomPoint = rightBottomPoint;
        this.leftBottomPoint = leftBottomPoint;
    }

    public Rectangle(Point leftTopPoint, Point rightTopPoint, Point rightBottomPoint, Point leftBottomPoint) {
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

    public void setLeftTopPoint(Point leftTopPoint) {
        this.leftTopPoint = leftTopPoint;
    }

    public Point getRightTopPoint() {
        return rightTopPoint;
    }

    public void setRightTopPoint(Point rightTopPoint) {
        this.rightTopPoint = rightTopPoint;
    }

    public Point getRightBottomPoint() {
        return rightBottomPoint;
    }

    public void setRightBottomPoint(Point rightBottomPoint) {
        this.rightBottomPoint = rightBottomPoint;
    }

    public Point getLeftBottomPoint() {
        return leftBottomPoint;
    }

    public void setLeftBottomPoint(Point leftBottomPoint) {
        this.leftBottomPoint = leftBottomPoint;
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
}
