package com.epam.shapes.observer.impl;

import com.epam.shapes.entity.Pyramid;
import com.epam.shapes.exception.PyramidException;
import com.epam.shapes.observer.PyramidEvent;
import com.epam.shapes.observer.PyramidObserver;
import com.epam.shapes.service.impl.PyramidServiceImpl;
import com.epam.shapes.warehouse.WareHouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PyramidObserverImpl implements PyramidObserver {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void updateParameters(PyramidEvent event) {
        Pyramid pyramid = event.getSource();
        int pyramidId = pyramid.getId();
        WareHouse warehouse = WareHouse.getInstance();
        PyramidServiceImpl pyramidService = new PyramidServiceImpl();
        try {
            double pyramidArea = pyramidService.calculateArea(pyramid);
            double pyramidVolume = pyramidService.calculateVolume(pyramid);
            warehouse.updateParameters(pyramidId, pyramidArea, pyramidVolume);
        } catch (PyramidException e) {
            logger.log(Level.ERROR, "Error while changing warehouse ", e);
        }
    }
}
