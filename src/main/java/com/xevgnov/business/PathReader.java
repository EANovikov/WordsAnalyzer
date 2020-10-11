package com.xevgnov.business;

import com.xevgnov.exception.EmptyPathException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class PathReader {

    private final static Logger LOGGER = Logger.getLogger(PathReader.class.getName());

    public Path readPath(String[] args) throws IOException {
        LOGGER.info("Trying to read path from program arguments...");
        if (ArrayUtils.isNotEmpty(args) && StringUtils.isNoneEmpty(args[0])) {
            return readPathFromArguments(args);
        } else {
            return readPathFromKeyboard();
        }
    }

    private Path readPathFromArguments(String[] args) {
        Path argumentPath = Paths.get(args[0].trim()).normalize();
        LOGGER.info("Got path from arguments, it is: " + argumentPath.toAbsolutePath().toString());
        return argumentPath;
    }

    private Path readPathFromKeyboard() throws IOException {
        Path keyboardInputPath = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please enter the target path:");
            String input = reader.readLine();

            if (StringUtils.isEmpty(input)) {
                LOGGER.severe("No path provided - finishing current run");
                throw new EmptyPathException("Empty path has been provided! Please try again with non-empty path");
            }

            keyboardInputPath = Paths.get(input.trim()).normalize();
            LOGGER.info("Got path from keyboard, it is: " + keyboardInputPath.toAbsolutePath().toString());
        }
        return keyboardInputPath;
    }

}
