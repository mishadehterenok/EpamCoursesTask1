package com.epam.shapes.specification.impl;

import com.epam.shapes.entity.Pyramid;
import com.epam.shapes.exception.PyramidException;
import com.epam.shapes.service.impl.PyramidServiceImpl;
import com.epam.shapes.specification.BaseSpecification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PyramidAreaSpecification implements BaseSpecification<Pyramid> {

    private static final Logger logger = LogManager.getLogger();
    private final double areaFrom;
    private final double areaTo;

    public PyramidAreaSpecification(double areaFrom, double areaTo) {
        this.areaFrom = areaFrom;
        this.areaTo = areaTo;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        double area = 0;
        try {
            PyramidServiceImpl pyramidService = new PyramidServiceImpl();
            area = pyramidService.calculateArea(pyramid);
        } catch (PyramidException e) {
            logger.log(Level.ERROR, e);
        }
        return (Double.compare(area, areaFrom) == 1 && Double.compare(area, areaTo) == -1);
    }
}
