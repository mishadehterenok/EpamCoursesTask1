package com.epam.shapes.validator;

public interface PyramidFileValidator {

    boolean isFileValid(String filepath);

    boolean isLineValid(String fileLine);
}
