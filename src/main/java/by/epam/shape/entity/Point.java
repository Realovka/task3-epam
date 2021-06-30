package by.epam.shape.entity;

public class Point {

    private double x;
    private double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0 &&
                point.x == x && point.y == y;
    }

    @Override
    public int hashCode() {
        int result = 1;
        long bits = Double.doubleToLongBits(this.x);
        result = (int) (bits ^ (bits >>> 32));
        bits = Double.doubleToLongBits(this.y);
        result = (int) (bits ^ (bits >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Point{");
        builder.append(x).append(", ");
        builder.append(y).append("}");
        return builder.toString();
    }
}
