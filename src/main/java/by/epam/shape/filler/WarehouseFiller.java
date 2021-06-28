package by.epam.shape.filler;

import by.epam.shape.entity.Rectangle;
import by.epam.shape.entity.RectangleParameters;
import by.epam.shape.entity.Warehouse;
import by.epam.shape.service.RectangleService;
import by.epam.shape.service.impl.RectangleServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class WarehouseFiller {

    private static final Logger logger = LogManager.getLogger();

    public void fillWarehouse(Rectangle rectangle) {
        Long id = rectangle.getRectangleId();
        RectangleService service = new RectangleServiceImpl();
        BigDecimal perimeter = service.findPerimeter(rectangle);
        BigDecimal area = service.findArea(rectangle);
        RectangleParameters parameters = new RectangleParameters(perimeter, area);
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.putNewParameters(id, parameters);
        logger.log(Level.INFO, "New rectangleParameters add to warehouse "+ parameters);
    }
}
