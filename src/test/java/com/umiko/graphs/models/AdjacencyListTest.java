package com.umiko.graphs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AdjacencyListTest {
    private AdjacencyList al;

    @BeforeEach
    @Test
    @DisplayName("Test Constructors")
    void AdjacencyListConstructor() {
        al = new AdjacencyList(new File("src/test/resources/k3_3.txt"));
        al = new AdjacencyList(new EdgeList(new File("src/test/resources/k3_3.txt")));
    }

    @Test
    @DisplayName("Test getting single vertex adjacency list")
    void getAdjacencyList() {
        assertArrayEquals(new int[]{4, 5, 6}, al.getAdjacencyListByVertex(1));
    }

    @Test
    @DisplayName("Test getting the raw AdjacencyList")
    void getRawAdjacencyList() {
        for (int i = 0; i < al.getRawAdjacencyList().length; i++)
            assertArrayEquals(al.getRawAdjacencyList()[i], al.getAdjacencyListByVertex(i + 1));
    }
}
