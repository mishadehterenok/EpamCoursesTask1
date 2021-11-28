package com.epam.shapes.observer.impl;

import com.epam.shapes.entity.Point;
import com.epam.shapes.entity.Pyramid;
import com.epam.shapes.exception.PyramidException;
import com.epam.shapes.factory.PyramidFactory;
import com.epam.shapes.filler.impl.WareHouseFiller;
import com.epam.shapes.warehouse.PyramidParams;
import com.epam.shapes.warehouse.WareHouse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PyramidObserverImplTest {
    private final WareHouse warehouse = WareHouse.getInstance();
    private static final PyramidObserverImpl observer = new PyramidObserverImpl();
    private static final PyramidFactory pyramidFactory = PyramidFactory.getInstance();
    private static Pyramid pyramid;

    @BeforeAll
    static void setUp() throws PyramidException {
        WareHouseFiller warehouseFiller = new WareHouseFiller();
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(4.0);
        coordinates.add(4.0);
        coordinates.add(4.0);
        coordinates.add(5.0);
        coordinates.add(10.0);
        pyramid = pyramidFactory.getPyramid(coordinates);
        pyramid.attach(observer);
        List<Pyramid> pyramids = new ArrayList<>();
        pyramids.add(pyramid);
        warehouseFiller.fill(pyramids);
    }

    @Test
    public void ifDataIsChanged() throws PyramidException {
        PyramidParams oldParams = warehouse.receiveParameters(pyramid.getId());
        double oldArea = oldParams.getArea();
        double oldVolume = oldParams.getVolume();
        pyramid.setBaseCenter(new Point(1.0, 20.0, 3.0));
        pyramid.setBaseSide(10.0);
        pyramid.notifyObservers();
        PyramidParams newParams = warehouse.receiveParameters(pyramid.getId());
        double newArea = newParams.getArea();
        double newVolume = newParams.getVolume();
        Assertions.assertTrue((Double.compare(oldArea, newArea) != 0)
                && (Double.compare(oldVolume, newVolume) != 0));

    }

}