package by.epam.shape;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Rectangle;
import by.epam.shape.exception.RectangleException;
import by.epam.shape.factory.impl.RectangleFactoryImpl;
import by.epam.shape.parser.impl.RectangleParserImpl;
import by.epam.shape.reader.RectangleReader;
import by.epam.shape.reader.impl.RectangleReaderImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) throws RectangleException {
        List<String> lines = new RectangleReaderImpl().readStringFromFile("src//main//resources//file//rectangle.txt");
        List<Double> parameters = new RectangleParserImpl().parse(lines);
        Rectangle rectangle = new RectangleFactoryImpl().createRectangle(parameters);
        System.out.println(rectangle);

        Point i = new Point(2, 3);
        Point i2 = new Point(2, 3);
        System.out.println(i.equals(i2));

    }
}
