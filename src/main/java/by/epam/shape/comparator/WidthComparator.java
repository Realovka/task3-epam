package by.epam.shape.comparator;

import by.epam.shape.entity.Rectangle;
import by.epam.shape.service.RectangleService;
import by.epam.shape.service.impl.RectangleServiceImpl;

import java.util.Comparator;

public class WidthComparator implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        RectangleService service = new RectangleServiceImpl();
        return service.findWidth(o1).compareTo(service.findWidth(o2));
    }
}
