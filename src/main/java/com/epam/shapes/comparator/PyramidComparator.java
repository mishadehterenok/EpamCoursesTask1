package com.epam.shapes.comparator;

import com.epam.shapes.entity.Pyramid;
import com.epam.shapes.exception.PyramidException;
import com.epam.shapes.service.impl.PyramidServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public enum PyramidComparator implements Comparator<Pyramid> {
    ID {
        @Override
        public int compare(Pyramid o1, Pyramid o2) {
            return o1.getId() - o2.getId();
        }
    },

    X_COORDINATE {
        @Override
        public int compare(Pyramid o1, Pyramid o2) {
            return Double.compare(o1.getBaseCenter().getX(), o2.getBaseCenter().getX());
        }
    },

    Y_COORDINATE {
        @Override
        public int compare(Pyramid o1, Pyramid o2) {
            return Double.compare(o1.getBaseCenter().getY(), o2.getBaseCenter().getY());
        }
    },

    Z_COORDINATE {
        @Override
        public int compare(Pyramid o1, Pyramid o2) {
            return Double.compare(o1.getBaseCenter().getZ(), o2.getBaseCenter().getZ());
        }
    },

    AREA {
        @Override
        public int compare(Pyramid o1, Pyramid o2) {
            double area1 = 0;
            double area2 = 0;
            try {
                PyramidServiceImpl pyramidService = new PyramidServiceImpl();
                area1 = pyramidService.calculateArea(o1);
                area2 = pyramidService.calculateArea(o2);
            } catch (PyramidException e) {
                logger.log(Level.ERROR, e);
            }
            return Double.compare(area1, area2);
        }
    },

    VOLUME {
        @Override
        public int compare(Pyramid o1, Pyramid o2) {
            double volume1 = 0;
            double volume2 = 0;
            try {
                PyramidServiceImpl pyramidService = new PyramidServiceImpl();
                volume1 = pyramidService.calculateVolume(o1);
                volume2 = pyramidService.calculateVolume(o2);
            } catch (PyramidException e) {
                logger.log(Level.ERROR, e);
            }
            return Double.compare(volume1, volume2);
        }
    };

    private static final Logger logger = LogManager.getLogger();
}
