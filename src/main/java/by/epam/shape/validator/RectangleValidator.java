package by.epam.shape.validator;

import by.epam.shape.entity.Point;

import java.util.List;

public class RectangleValidator {

    public static boolean validateRectangle(List<Point> points) {
        return points.get(0).getX() == points.get(3).getX() &&
                points.get(0).getY() == points.get(1).getY() &&
                points.get(2).getX() == points.get(1).getX() &&
                points.get(2).getY() == points.get(3).getY();

    }
}
