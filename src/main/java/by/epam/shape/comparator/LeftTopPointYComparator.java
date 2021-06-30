package by.epam.shape.comparator;

import by.epam.shape.entity.Rectangle;

import java.util.Comparator;

public class LeftTopPointYComparator implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        return Double.compare(o1.getLeftTopPoint().getY(), o2.getLeftTopPoint().getY());
    }
}
