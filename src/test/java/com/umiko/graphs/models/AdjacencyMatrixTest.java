package com.umiko.graphs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdjacencyMatrixTest {
    private AdjacencyMatrix am;

    @BeforeEach
    @Test
    @DisplayName("Test Constructor")
    void AdjacencyMatrixConstructor() {
        am = new AdjacencyMatrix(new File("src/test/resources/k3_3.txt"));
        am = new AdjacencyMatrix(new EdgeList(new File("src/test/resources/k3_3.txt")));
    }

    @Test
    @DisplayName("Test lookup")
    void lookup() {
        assertEquals(1, am.lookup(1, 5));
        assertEquals(0, am.lookup(3, 2));
        am.addEdge(new Edge(1, 1));
        assertEquals(2, am.lookup(1, 1));
    }

    @Test
    @DisplayName("Test Raw Matrix")
    void getRawMatrix() {
        assertEquals(1, am.getRawMatrix()[1][3]);
        assertEquals(0, am.getRawMatrix()[0][0]);
        assertEquals(0, am.getRawMatrix()[1][2]);
    }
}
