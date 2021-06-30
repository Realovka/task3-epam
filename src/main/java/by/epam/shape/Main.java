package by.epam.shape;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Rectangle;
import by.epam.shape.entity.RectangleParameters;
import by.epam.shape.entity.Warehouse;
import by.epam.shape.exception.RectangleException;
import by.epam.shape.factory.impl.RectangleFactoryImpl;
import by.epam.shape.filler.WarehouseFiller;
import by.epam.shape.observer.RectangleEvent;
import by.epam.shape.observer.RectangleObserver;
import by.epam.shape.observer.impl.RectangleObserverImpl;
import by.epam.shape.parser.impl.RectangleParserImpl;
import by.epam.shape.reader.impl.RectangleReaderImpl;
import by.epam.shape.repository.RectangleRepository;
import by.epam.shape.repository.RectangleSpecification;
import by.epam.shape.repository.impl.IdSpecification;
import by.epam.shape.service.impl.RectangleServiceImpl;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws RectangleException {
        URL fileURL = Main.class.getClassLoader().getResource("file/rectangle.txt");
        File file = new File(fileURL.getFile());
        String filePath = file.getAbsolutePath();
        List<String> lines = new RectangleReaderImpl().readStringFromFile(filePath);
        List<Double> parameters = new RectangleParserImpl().parse(lines);
        RectangleObserver observer = new RectangleObserverImpl();
        RectangleRepository repository = RectangleRepository.getInstance();
        while (!parameters.isEmpty()) {
            Rectangle rectangle = new RectangleFactoryImpl().createRectangle(parameters);
            rectangle.attach(observer);
            WarehouseFiller filler = new WarehouseFiller();
            filler.fillWarehouse(rectangle);
            parameters.remove(0);
            parameters.remove(0);
            parameters.remove(0);
            parameters.remove(0);
            parameters.remove(0);
            parameters.remove(0);
            parameters.remove(0);
            parameters.remove(0);
            repository.addRectangle(rectangle);
        }
        RectangleSpecification specification = new IdSpecification(1L);
        List<Rectangle> rectangles = repository.query(specification);
        rectangles.forEach(System.out::println);


    }
}
