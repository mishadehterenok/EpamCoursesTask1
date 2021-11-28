package com.epam.shapes.reader;

import com.epam.shapes.exception.PyramidException;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PyramidFileReaderTest {
    @Test
    public void testGetValidLines() throws PyramidException {
        PyramidFileReader pyramidFileReader = new PyramidFileReader();
        URL fileUrl = PyramidFileReaderTest.class.getClassLoader()
                .getResource("files/params.txt");
        File file = new File(fileUrl.getFile());
        String filePath = file.getAbsolutePath();
        List<String> fileLines = pyramidFileReader.getValidLines(filePath);
        List<String> expectedFileLines = new ArrayList<>();
        expectedFileLines.add("2.0 3.0 4.0 5.0 6.0");
        expectedFileLines.add("7.0 7.0 8.0 9.0 10.0");
        assertEquals(fileLines, expectedFileLines);
    }

}