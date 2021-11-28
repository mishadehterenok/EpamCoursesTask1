package com.epam.shapes.util;

public class IdGenerator {
    private static int counter;

    private IdGenerator() {
    }
    public static int generateId() {
        return counter++;
    }
}
