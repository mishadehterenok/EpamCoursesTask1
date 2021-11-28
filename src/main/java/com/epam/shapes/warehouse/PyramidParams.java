package com.epam.shapes.warehouse;

public class PyramidParams {
    private double area;
    private double volume;

    public PyramidParams(double area, double volume) {
        this.area = area;
        this.volume = volume;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PyramidParams params = (PyramidParams) o;
        return Double.compare(params.getArea(), this.area) == 0
                && Double.compare(params.getVolume(), this.volume) == 0;
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(area);
        result = 31 * result + Double.hashCode(volume);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PyramidParams{");
        sb.append("area=").append(area);
        sb.append(", volume=").append(volume);
        sb.append('}');
        return sb.toString();
    }
}
