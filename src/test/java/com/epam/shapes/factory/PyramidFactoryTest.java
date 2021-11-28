package com.epam.shapes.factory;

import com.epam.shapes.entity.Point;
import com.epam.shapes.entity.Pyramid;
import com.epam.shapes.exception.PyramidException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class PyramidFactoryTest {
    private static final PyramidFactory pyramidFactory = PyramidFactory.getInstance();

    @Test
    public void testGetPyramid() throws PyramidException {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(4.0);
        coordinates.add(4.0);
        coordinates.add(4.0);
        coordinates.add(5.0);
        coordinates.add(10.0);
        Pyramid pyramid = pyramidFactory.getPyramid(coordinates);
        Assert.assertEquals(pyramid, new Pyramid(new Point(4d, 4d, 4d), 5d, 10d));
    }

}