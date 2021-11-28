package com.epam.shapes.parser;

import com.epam.shapes.exception.PyramidException;
import com.epam.shapes.factory.PyramidFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class PyramidLineParser {
    private static final Logger logger = LogManager.getLogger();
    public static final String REGEXP_DELIMITER = "\\s+";

    public List<Double> parseLine(String line) throws PyramidException {
        if (line == null || line.isEmpty()) {
            throw new PyramidException("Line is empty");
        }
        List<Double> coordinates;
        try {
            coordinates = Arrays.stream(line.split(REGEXP_DELIMITER))
                    .map(Double::parseDouble)
                    .toList();
        } catch (NumberFormatException e) {
            throw new PyramidException("Invalid line", e);
        }
        if (coordinates.size() != PyramidFactory.COORDINATES_NUMBER) {
            throw new PyramidException("Invalid coordinates number");
        }
        logger.log(Level.INFO, "Lines parsed successfully");
        return coordinates;
    }
}
