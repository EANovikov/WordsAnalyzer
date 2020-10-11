package com.xevgnov.business;

import com.xevgnov.exception.EmptyPathException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PathReaderTest {

    private PathReader pathReader;
    private ByteArrayInputStream inContent;
    private final InputStream originalIn = System.in;

    @Before
    public void init() {
        pathReader = new PathReader();
    }

    @After
    public void restoreStreams() {
        System.setIn(originalIn);
    }

    @Test
    public void readPathFromArgumentsValidPathTest() throws IOException {
        String[] args = {" C:/ "};
        Path path = pathReader.readPath(args);
        assertThat(path.toString()).isEqualTo("C:\\");
    }

    @Test
    public void readPathFromArgumentsInvalidPathTest() throws IOException {
        String[] args = {"!@#$%"};
        Path path = pathReader.readPath(args);
        assertThat(path.toString()).isEqualTo("!@#$%");
    }

    @Test
    public void readPathFromArgumentsKeyboardTest() throws IOException {
        inContent = new ByteArrayInputStream("C:/Users/".getBytes());
        System.setIn(inContent);
        Path path = pathReader.readPath(null);
        assertThat(path.toString()).isEqualTo("C:\\Users");
    }

    @Test
    public void readPathFromArgumentsEmptyPathTest() {
        inContent = new ByteArrayInputStream("".getBytes());
        System.setIn(inContent);
        assertThatThrownBy(() -> {
            pathReader.readPath(null);
        }).isInstanceOf(EmptyPathException.class)
                .hasMessage("Empty path has been provided! Please try again with non-empty path");
    }

}