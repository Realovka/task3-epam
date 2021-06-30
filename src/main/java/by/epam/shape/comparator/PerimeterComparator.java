package by.epam.shape.comparator;

import by.epam.shape.entity.Rectangle;
import by.epam.shape.service.RectangleService;
import by.epam.shape.service.impl.RectangleServiceImpl;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        RectangleService service = new RectangleServiceImpl();
        return service.findPerimeter(o1).compareTo(service.findPerimeter(o2));
    }
}
