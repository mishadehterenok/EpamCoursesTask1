package com.epam.shapes.specification.impl;

import com.epam.shapes.entity.Pyramid;
import com.epam.shapes.exception.PyramidException;
import com.epam.shapes.service.impl.PyramidServiceImpl;
import com.epam.shapes.specification.BaseSpecification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PyramidVolumeSpecification implements BaseSpecification<Pyramid> {

    private static final Logger logger = LogManager.getLogger();
    private final double volumeFrom;
    private final double volumeTo;

    public PyramidVolumeSpecification(double volumeFrom, double volumeTo) {
        this.volumeFrom = volumeFrom;
        this.volumeTo = volumeTo;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        double volume = 0;
        try {
            PyramidServiceImpl pyramidService = new PyramidServiceImpl();
            volume = pyramidService.calculateVolume(pyramid);
        } catch (PyramidException e) {
            logger.log(Level.ERROR, e);
        }
        return (Double.compare(volume, volumeFrom) == 1 && Double.compare(volume, volumeTo) == -1);
    }
}
