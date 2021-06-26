package by.epam.shape;

import by.epam.shape.entity.Rectangle;
import by.epam.shape.exception.RectangleException;
import by.epam.shape.factory.impl.RectangleFactoryImpl;
import by.epam.shape.parser.impl.RectangleParserImpl;
import by.epam.shape.reader.impl.RectangleReaderImpl;
import by.epam.shape.service.impl.RectangleServiceImpl;

import java.io.File;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws RectangleException {
        URL fileURL = Main.class.getClassLoader().getResource("file/rectangle.txt");
        File file = new File(fileURL.getFile());
        String filePath = file.getAbsolutePath();
        List<String> lines = new RectangleReaderImpl().readStringFromFile(filePath);
        List<Double> parameters = new RectangleParserImpl().parse(lines);
        Rectangle rectangle = new RectangleFactoryImpl().createRectangle(parameters);

//        new RectangleServiceImpl().isRectangle(rectangle);
//        new RectangleServiceImpl().findPerimeter(rectangle);
        new RectangleServiceImpl().findArea(rectangle);
//        new RectangleServiceImpl().isConvex(rectangle);
//        new RectangleServiceImpl().isRhombus(rectangle);
//        new RectangleServiceImpl().isSquare(rectangle);

    }
}
