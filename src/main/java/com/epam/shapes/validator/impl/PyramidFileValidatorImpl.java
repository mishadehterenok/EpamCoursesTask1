package com.epam.shapes.validator.impl;

import com.epam.shapes.validator.PyramidFileValidator;

import java.io.File;

public class PyramidFileValidatorImpl implements PyramidFileValidator {

    private static final String REGEXP_FOR_LINE_VALIDATION = "([-]?\\d+\\.\\d+\\s+){4}([-]?\\d+\\.\\d+)";

    @Override
    public boolean isFileValid(String filepath) {
        if (filepath == null || filepath.isEmpty()) {
            return false;
        }
        File file = new File(filepath);
        return file.exists() && (file.length() != 0);
    }
    @Override
    public boolean isLineValid(String fileLine) {
        return fileLine.matches(REGEXP_FOR_LINE_VALIDATION);
    }
}
