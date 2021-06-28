package by.epam.shape.parser.impl;

import by.epam.shape.exception.RectangleException;
import by.epam.shape.parser.RectangleParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RectangleParserImpl implements RectangleParser {

    private static final Logger logger = LogManager.getLogger();
    private static final String DELIMITER = "\\s";

    @Override
    public List<Double> parse(List<String> correctLines) throws RectangleException {
        List<Double> parameters = new ArrayList<>();
        if (correctLines.isEmpty()) {
            logger.log(Level.ERROR, "No lines for parsing");
            throw new RectangleException("No lines for parsing");
        }
        for (String item : correctLines) {
            parameters.addAll(generateElements(item)
                    .stream().map(Double::parseDouble)
                    .collect(Collectors.toList()));
        }
        return parameters;
    }

    private List<String> generateElements(String line) {
        return Stream.of(line.split(DELIMITER)).collect(Collectors.toList());
    }
}
