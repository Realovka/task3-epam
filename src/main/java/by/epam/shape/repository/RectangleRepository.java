package by.epam.shape.repository;

import by.epam.shape.entity.Rectangle;
import by.epam.shape.exception.RectangleException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RectangleRepository {
    private List<Rectangle> rectangles;
    private static RectangleRepository instance;
    private static final Logger logger = LogManager.getLogger();


    private RectangleRepository() {
        this.rectangles = new ArrayList<>();
    }

    public static RectangleRepository getInstance() {
        if (instance == null) {
            instance = new RectangleRepository();
        }
        return instance;
    }

    public void addRectangle(Rectangle rectangle) {
        rectangles.add(rectangle);
        logger.log(Level.INFO, "New rectangle add to repository " + rectangle);
    }

    public void addAllRectangles(List<Rectangle> newRectangles) {
        rectangles.addAll(newRectangles);
    }

    public Rectangle findRectangleById(Long id) throws RectangleException {
        Rectangle rectangle = rectangles.stream().filter(o -> o.getRectangleId() == id).findAny().orElseThrow(RectangleException::new);
        logger.log(Level.INFO, "Find rectangle by id " + rectangle);
        return rectangle;
    }

    public boolean remove(Rectangle rectangle) {
        return rectangles.remove(rectangle);
    }

    public boolean removeAll(List<Rectangle> removeRectangles) {
        return rectangles.removeAll(removeRectangles);
    }

    public int getSize() {
        return rectangles.size();
    }

    public List<Rectangle> query(RectangleSpecification specification) {
        return rectangles.stream().filter(specification::specify).collect(Collectors.toList());
    }

    public List<Rectangle> sort(Comparator<Rectangle> comparator) {
        List<Rectangle> rectanglesCopy = new ArrayList<>(rectangles);
        rectanglesCopy.sort(comparator);
        return rectanglesCopy;
    }
}
