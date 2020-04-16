package com.umiko.graphs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncidenceMatrixTest {
    IncidenceMatrix im;

    @BeforeEach
    void IncidenceMatrixConstructor() {
        im = new IncidenceMatrix(new EdgeList(new File("src/test/resources/k3_3.txt")));
        im = new IncidenceMatrix(new File("src/test/resources/k3_3.txt"));
    }

    @Test
    @DisplayName("Test Lookup function")
    void lookup() {
        assertEquals(1, im.lookup(1, 1));
        assertEquals(0, im.lookup(1, 6));
    }

    @Test
    @DisplayName("Test returned Matrix")
    void getRawMatrix() {
        int[][] m = im.getRawMatrix();
        for (int vertMatrixIndex = 0; vertMatrixIndex < m.length; vertMatrixIndex++) {
            for (int edgeIndex = 0; edgeIndex < m[vertMatrixIndex].length; edgeIndex++) {
                assertEquals(m[vertMatrixIndex][edgeIndex], im.lookup(vertMatrixIndex + 1, edgeIndex));
            }
        }
    }
}
