package by.epam.shape.observer.impl;

import by.epam.shape.entity.Rectangle;
import by.epam.shape.entity.RectangleParameters;
import by.epam.shape.entity.Warehouse;
import by.epam.shape.exception.RectangleException;
import by.epam.shape.observer.RectangleEvent;
import by.epam.shape.observer.RectangleObserver;
import by.epam.shape.service.RectangleService;
import by.epam.shape.service.impl.RectangleServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class RectangleObserverImpl implements RectangleObserver {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void changeParameters(RectangleEvent event) throws RectangleException {
        Rectangle rectangle = event.getSource();
        long id = rectangle.getRectangleId();
        Warehouse warehouse = Warehouse.getInstance();
        RectangleParameters parameters = warehouse.getRectangleParameters(id);
        RectangleService service = new RectangleServiceImpl();
        BigDecimal perimeter = service.findPerimeter(rectangle);
        parameters.setPerimeter(perimeter);
        BigDecimal area = service.findArea(rectangle);
        parameters.setArea(area);
        warehouse.putNewParameters(id, parameters);
        logger.log(Level.INFO,"Update perimeter and area in rectangle " + rectangle);
    }

}
