package by.epam.shape.entity;

import by.epam.shape.exception.RectangleException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<Long, RectangleParameters> map;
    private static Warehouse instance;
    private static final Logger logger = LogManager.getLogger();

    private Warehouse() {
        this.map = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public RectangleParameters getRectangleParameters(long id) throws RectangleException {
        RectangleParameters rectangleParameters = map.get(id);
        if (rectangleParameters == null) {
            logger.log(Level.ERROR, "No such key in warehouse " + id);
            throw new RectangleException("No such key in warehouse" + id);
        }
        return rectangleParameters;
    }

    public void putNewParameters(Long id, RectangleParameters parameters) {
        logger.log(Level.INFO, "Put new parameters " + parameters);
        map.put(id, parameters);
    }
}
