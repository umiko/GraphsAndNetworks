package com.umiko.graphs.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    String[] paths = {"src/test/resources/simple.txt", "broken/path"};

    @Test
    void readFile() {
        assertTrue(FileReader.readFile(paths[0]).contains("A simple file"));
        assertThrows(IllegalArgumentException.class, ()->{FileReader.readFile(paths[1]);});
    }
}