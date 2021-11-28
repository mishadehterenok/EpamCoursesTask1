package com.epam.shapes.reader;

import com.epam.shapes.exception.PyramidException;
import com.epam.shapes.validator.impl.PyramidFileValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class PyramidFileReader {
    private static final Logger logger = LogManager.getLogger();

    public List<String> getValidLines(String filepath) throws PyramidException {
        PyramidFileValidatorImpl fileValidator = new PyramidFileValidatorImpl();
        if (!fileValidator.isFileValid(filepath)) {
            throw new PyramidException("Invalid file path");
        }
        Path path = Paths.get(filepath);
        List<String> fileLines;
        try (Stream<String> fileLinesStream = Files.lines(path)) {
            fileLines = fileLinesStream
                    .filter(fileValidator::isLineValid)
                    .toList();
        } catch (IOException e) {
            throw new PyramidException("Error while reading file: " + filepath, e);
        }
        if (fileLines.size() == 0) {
            throw new PyramidException("File doesn't contain valid lines");
        }
        logger.log(Level.INFO, "Lines received successfully");
        return fileLines;
    }
}
