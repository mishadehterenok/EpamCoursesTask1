package com.epam.shapes.filler.impl;

import com.epam.shapes.entity.Pyramid;
import com.epam.shapes.exception.PyramidException;
import com.epam.shapes.filler.BaseFiller;
import com.epam.shapes.service.impl.PyramidServiceImpl;
import com.epam.shapes.warehouse.WareHouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class WareHouseFiller implements BaseFiller<Pyramid> {
    private static final Logger logger = LogManager.getLogger();
    private final WareHouse warehouse = WareHouse.getInstance();

    @Override
    public void fill(List<Pyramid> pyramids) {
        PyramidServiceImpl pyramidService = new PyramidServiceImpl();
        for (Pyramid pyramid : pyramids) {
            int pyramidId = pyramid.getId();
            if (warehouse.containsPyramid(pyramidId)) {
                continue;
            }
            try {
                double volume = pyramidService.calculateVolume(pyramid);
                double area = pyramidService.calculateArea(pyramid);
                warehouse.putParameters(pyramidId, area, volume);
            } catch (PyramidException e) {
                logger.log(Level.ERROR, "Error while filling warehouse ", e);
            }
        }
    }
}
