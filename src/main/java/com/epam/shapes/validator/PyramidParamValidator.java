package com.epam.shapes.validator;

import com.epam.shapes.entity.Point;

public interface PyramidParamValidator {
    boolean isValid(Point baseCenter, double baseSide, double height);
}
