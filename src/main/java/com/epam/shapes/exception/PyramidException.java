package com.epam.shapes.exception;

public class PyramidException extends Exception{

    public PyramidException(String message) {
        super(message);
    }

    public PyramidException(String message, Throwable cause) {
        super(message, cause);
    }

    public PyramidException(Throwable cause) {
        super(cause);
    }
}
