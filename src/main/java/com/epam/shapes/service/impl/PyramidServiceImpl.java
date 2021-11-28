package com.epam.shapes.service.impl;

import com.epam.shapes.entity.Pyramid;
import com.epam.shapes.exception.PyramidException;
import com.epam.shapes.service.PyramidService;
import com.epam.shapes.validator.impl.PyramidParamValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PyramidServiceImpl implements PyramidService {
    private static final String ERROR_MESSAGE = "Invalid pyramid";
    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean isPyramidValid(Pyramid pyramid) throws PyramidException {
        if (pyramid == null) {
            throw new PyramidException(ERROR_MESSAGE);
        }
        PyramidParamValidatorImpl paramValidator = new PyramidParamValidatorImpl();
        boolean result = paramValidator.isValid(pyramid.getBaseCenter(), pyramid.getBaseSide(), pyramid.getHeight());
        logger.log(Level.INFO, "Pyramid is valid: {}", result);
        return result;
    }

    @Override
    public double calculateArea(Pyramid pyramid) throws PyramidException {
        if (pyramid == null) {
            throw new PyramidException(ERROR_MESSAGE);
        }
        double a = pyramid.getBaseSide();
        double h = pyramid.getHeight();
        double result = a*a + 2*a * Math.sqrt(h*h + a*a/4);
        logger.log(Level.INFO, "Calculated area: {}", result);
        return result;
    }

    @Override
    public double calculateVolume(Pyramid pyramid) throws PyramidException {
        if (pyramid == null) {
            throw new PyramidException(ERROR_MESSAGE);
        }
        double a = pyramid.getBaseSide();
        double h = pyramid.getHeight();
        double result =  Math.abs(h/3) * a*a;
        logger.log(Level.INFO, "Calculated volume: {}", result);
        return result;
    }
}
