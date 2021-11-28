package com.epam.shapes.service.impl;

import com.epam.shapes.entity.Pyramid;
import com.epam.shapes.exception.PyramidException;
import com.epam.shapes.factory.PyramidFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PyramidServiceImplTest {
    private final PyramidFactory pyramidFactory = PyramidFactory.getInstance();
    private final PyramidServiceImpl pyramidService = new PyramidServiceImpl();

    @Test
    public void testIsPyramidValid() throws PyramidException {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(4.0);
        coordinates.add(4.0);
        coordinates.add(4.0);
        coordinates.add(5.0);
        coordinates.add(10.0);
        Pyramid pyramid = pyramidFactory.getPyramid(coordinates);
        assertTrue(pyramidService.isPyramidValid(pyramid));
    }

    @Test
    public void testCalculateArea() throws PyramidException {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(2.0);
        coordinates.add(3.0);
        coordinates.add(4.0);
        coordinates.add(5.0);
        coordinates.add(6.0);
        Pyramid pyramid = pyramidFactory.getPyramid(coordinates);
        assertEquals(0, Double.compare(pyramidService.calculateArea(pyramid), 5d*5d + 2*5d * Math.sqrt(6d*6d + 5d*5d/4)));
    }

    @Test
    public void testCalculateVolume() throws PyramidException {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(4.0);
        coordinates.add(4.0);
        coordinates.add(4.0);
        coordinates.add(5.0);
        coordinates.add(10.0);
        Pyramid pyramid = pyramidFactory.getPyramid(coordinates);
        assertEquals(0, Double.compare(pyramidService.calculateVolume(pyramid), (10d/3) * 5*5));
    }


}