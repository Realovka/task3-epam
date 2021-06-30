package by.epam.shape.repository.impl;

import by.epam.shape.entity.Rectangle;
import by.epam.shape.repository.RectangleSpecification;
import by.epam.shape.service.RectangleService;
import by.epam.shape.service.impl.RectangleServiceImpl;

import java.math.BigDecimal;

public class AreaRangeSpecification implements RectangleSpecification {

    private BigDecimal minArea;
    private BigDecimal maxArea;

    public AreaRangeSpecification(BigDecimal minArea, BigDecimal maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specify(Rectangle rectangle) {
        RectangleService service = new RectangleServiceImpl();
        BigDecimal area = service.findArea(rectangle);
        BigDecimal answerMax = area.max(maxArea);
        BigDecimal answerMin = area.min(minArea);
        return answerMax.equals(maxArea) && answerMin.equals(minArea);
    }
}
