package com.epam.shapes.factory;

import com.epam.shapes.entity.Point;
import com.epam.shapes.entity.Pyramid;
import com.epam.shapes.exception.PyramidException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PyramidFactory {
    private static final PyramidFactory INSTANCE = new PyramidFactory();
    private static final Logger logger = LogManager.getLogger();
    public static final int COORDINATES_NUMBER = 5;

    private PyramidFactory() {
    }
    public Pyramid getPyramid(List<Double> numbers) throws PyramidException {
        if (numbers.size() != COORDINATES_NUMBER) {
            throw new PyramidException("Invalid number of params: " + numbers);
        }
        Point baseCenter = new Point(numbers.get(0), numbers.get(1), numbers.get(2));
        double baseSide = numbers.get(3);
        double height = numbers.get(4);
        Pyramid pyramid = new Pyramid(baseCenter, baseSide, height);
        logger.log(Level.INFO, "Pyramid was created successfully");
        return pyramid;
    }

    public static PyramidFactory getInstance() {
        return INSTANCE;
    }
}
