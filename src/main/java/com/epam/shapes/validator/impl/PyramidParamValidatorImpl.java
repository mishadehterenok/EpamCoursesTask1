package com.epam.shapes.validator.impl;

import com.epam.shapes.entity.Point;
import com.epam.shapes.validator.PyramidParamValidator;

public class PyramidParamValidatorImpl implements PyramidParamValidator {

    @Override
    public boolean isValid(Point baseCenter, double baseSide, double height) {
        return baseCenter != null && baseSide > 0 && height != 0;
    }
}
