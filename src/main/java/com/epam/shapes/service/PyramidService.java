package com.epam.shapes.service;

import com.epam.shapes.entity.Pyramid;
import com.epam.shapes.exception.PyramidException;

public interface PyramidService {

    boolean isPyramidValid(Pyramid pyramid) throws PyramidException;

    double calculateArea(Pyramid pyramid) throws PyramidException;

    double calculateVolume(Pyramid pyramid) throws PyramidException;
}
