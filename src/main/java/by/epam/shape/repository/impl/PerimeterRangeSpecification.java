package by.epam.shape.repository.impl;

import by.epam.shape.entity.Rectangle;
import by.epam.shape.repository.RectangleSpecification;
import by.epam.shape.service.RectangleService;
import by.epam.shape.service.impl.RectangleServiceImpl;

import java.math.BigDecimal;

public class PerimeterRangeSpecification implements RectangleSpecification {

    private BigDecimal minPerimeter;
    private BigDecimal maxPerimeter;

    public PerimeterRangeSpecification(BigDecimal minPerimeter, BigDecimal maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    @Override
    public boolean specify(Rectangle rectangle) {
        RectangleService service = new RectangleServiceImpl();
        BigDecimal perimeter = service.findPerimeter(rectangle);
        BigDecimal answerMax = perimeter.max(maxPerimeter);
        BigDecimal answerMin = perimeter.min(minPerimeter);
        int resultMax = answerMax.compareTo(maxPerimeter);
        int resultMin = answerMin.compareTo(minPerimeter);
        if(resultMax <= 0 && resultMin >= 0) {
            return true;
        }
        return false;
    }
}
