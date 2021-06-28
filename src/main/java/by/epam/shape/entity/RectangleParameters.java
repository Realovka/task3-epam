package by.epam.shape.entity;

import java.math.BigDecimal;

public class RectangleParameters {
    private BigDecimal perimeter;
    private BigDecimal area;

    public RectangleParameters(BigDecimal perimeter, BigDecimal area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    public BigDecimal getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(BigDecimal perimeter) {
        this.perimeter = perimeter;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectangleParameters rectangleParameters = (RectangleParameters) o;
        return rectangleParameters.getPerimeter().equals(perimeter) &&
                rectangleParameters.getArea().equals(area);
    }

    @Override
    public int hashCode() {
        return perimeter.hashCode() * area.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RectangleParameters {")
                .append("perimeter = ").append(perimeter)
                .append(", area = ").append(area)
                .append('}');
        return builder.toString();
    }
}
