package com.epam.shapes.warehouse;

import com.epam.shapes.exception.PyramidException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class WareHouse {
    private static final Logger logger = LogManager.getLogger();
    private static final WareHouse instance = new WareHouse();
    private final Map<Integer, PyramidParams> parametersStorage = new HashMap<Integer, PyramidParams>();

    private WareHouse() {
    }
    public static WareHouse getInstance() {
        return instance;
    }

    public void putParameters(int id, double area, double volume) {
        PyramidParams pyramidParams = new PyramidParams(area, volume);
        parametersStorage.putIfAbsent(id, pyramidParams);
        logger.log(Level.INFO, "Parameters added successfully");
    }

    public PyramidParams receiveParameters(int id) throws PyramidException {
        PyramidParams pyramidParams = parametersStorage.get(id);
        if (pyramidParams == null) {
            throw new PyramidException("There is no pyramid with such id");
        }
        return pyramidParams;
    }

    public void updateParameters(int id, double area, double volume) throws PyramidException {
        PyramidParams pyramidParams = parametersStorage.get(id);
        if (pyramidParams == null) {
            throw new PyramidException("There is no ellipse with such id");
        }
        pyramidParams.setArea(area);
        pyramidParams.setVolume(volume);
        logger.log(Level.INFO, "Parameters updated successfully");
    }

    public boolean containsPyramid(int id) {
        return parametersStorage.containsKey(id);
    }
}
