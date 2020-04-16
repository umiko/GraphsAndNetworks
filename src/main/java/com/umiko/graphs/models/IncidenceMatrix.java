package com.umiko.graphs.models;

import java.io.File;

public class IncidenceMatrix extends AdvancedGraphRepresentation {

    private IncidenceMatrix() {
    }

    public IncidenceMatrix(EdgeList el) {
        this.edgeList = el;
    }

    public IncidenceMatrix(File f) {
        this.edgeList = new EdgeList(f);
    }

    public IncidenceMatrix(String filepath) {
        this.edgeList = new EdgeList(filepath);
    }

    public int lookup(int vertex, int edgeId) {
        Edge e = edgeList.getEdge(edgeId);
        if (e.contains(vertex)) {
            return e.getFrom() == vertex && isDirected() ? -1 : 1;
        }
        return 0;
    }

    public int[][] getRawMatrix() {
        int nodeCount = edgeList.getNodeCount();
        int edgeCount = edgeList.size();
        int[][] incidenceMatrix = new int[nodeCount][edgeCount];
        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0; j < edgeCount; j++) {
                incidenceMatrix[i][j] = lookup(i + 1, j);
            }
        }
        return incidenceMatrix;
    }
}
