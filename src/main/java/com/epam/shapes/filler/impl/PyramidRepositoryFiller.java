package com.epam.shapes.filler.impl;

import com.epam.shapes.entity.Pyramid;
import com.epam.shapes.filler.BaseFiller;
import com.epam.shapes.repository.impl.PyramidRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PyramidRepositoryFiller implements BaseFiller<Pyramid> {
    private static final Logger logger = LogManager.getLogger();
    private final PyramidRepository pyramidRepository = PyramidRepository.getInstance();

    @Override
    public void fill(List<Pyramid> pyramids) {
        for (Pyramid pyramid : pyramids) {
            pyramidRepository.add(pyramid);
        }
        logger.log(Level.INFO, "Repository filled successfully");
    }
}
