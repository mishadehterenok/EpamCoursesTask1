package com.epam.shapes.parser;

import com.epam.shapes.exception.PyramidException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PyramidLineParserTest {
    private final PyramidLineParser pyramidLineParser = new PyramidLineParser();

    @Test
    public void testParseLine() throws PyramidException {
        String correctLine = "4.0 3.0 2.0 5.0 6.0";
        List<Double> expectedList = new ArrayList<>();
        expectedList.add(4.0);
        expectedList.add(3.0);
        expectedList.add(2.0);
        expectedList.add(5.0);
        expectedList.add(6.0);
        List<Double> doubleList = pyramidLineParser.parseLine(correctLine);
        assertEquals(doubleList, expectedList);
    }


}