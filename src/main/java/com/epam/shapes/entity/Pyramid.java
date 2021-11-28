package com.epam.shapes.entity;


import com.epam.shapes.exception.PyramidException;
import com.epam.shapes.observer.PyramidEvent;
import com.epam.shapes.observer.PyramidObservable;
import com.epam.shapes.observer.PyramidObserver;
import com.epam.shapes.util.IdGenerator;
import com.epam.shapes.validator.impl.PyramidParamValidatorImpl;

import java.util.ArrayList;
import java.util.List;

public class Pyramid implements PyramidObservable {
    private final int id;
    private Point baseCenter;
    private double baseSide;
    private double height;
    List<PyramidObserver> observers = new ArrayList<>();

    public Pyramid(Point baseCenter, double baseSide, double height) throws PyramidException {
        PyramidParamValidatorImpl paramValidator = new PyramidParamValidatorImpl();
        if (paramValidator.isValid(baseCenter, baseSide, height)) {
            id = IdGenerator.generateId();
            this.baseCenter = baseCenter;
            this.baseSide = baseSide;
            this.height = height;
        } else {
            throw new PyramidException("Incorrect coordinates");
        }
    }

    public int getId() {
        return id;
    }

    public Point getBaseCenter() {
        return baseCenter;
    }

    public void setBaseCenter(Point baseCenter) {
        this.baseCenter = baseCenter;
    }

    public double getBaseSide() {
        return baseSide;
    }

    public void setBaseSide(double baseSide) {
        this.baseSide = baseSide;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pyramid pyramid = (Pyramid) o;
        return pyramid.getBaseCenter().equals(this.baseCenter)
                && pyramid.getBaseSide() == this.baseSide && pyramid.getHeight() == this.height;
    }

    @Override
    public int hashCode() {
        int result = baseCenter.hashCode();
        result += 31 * result + Double.valueOf(baseSide).hashCode();
        result += 31 * result + Double.valueOf(height).hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pyramid{");
        sb.append("id=").append(id);
        sb.append(", baseCenter=").append(baseCenter);
        sb.append(", baseSide=").append(baseSide);
        sb.append(", height=").append(height);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void attach(PyramidObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(PyramidObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (PyramidObserver observer : observers) {
            if (observer != null) {
                PyramidEvent event = new PyramidEvent(this);
                observer.updateParameters(event);
            }
        }
    }

}
