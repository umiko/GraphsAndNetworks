package com.umiko.graphs.models;

import java.io.File;

public class AdjacencyMatrix extends AdvancedGraphRepresentation {
    private AdjacencyMatrix() {
    }

    public AdjacencyMatrix(EdgeList el) {
        this.edgeList = el;
    }

    public AdjacencyMatrix(File f) {
        this.edgeList = new EdgeList(f);
    }

    public int lookup(int v1, int v2) {
        for (Edge e : edgeList.getIncidentEdges(v1)) {
            if (v1 == v2) {
                //self edges
                if (e.getFrom() == e.getTo()) {
                    return 2;
                }
            } else if (e.contains(v2))
                return !isDirected() || e.getTo() == v2 ? 1 : 0;
        }
        return 0;
    }

    public int[][] getRawMatrix() {
        int vertMax = edgeList.getNodeCount();
        int[][] mat = new int[vertMax][vertMax];
        for (int vertIdA = 1; vertIdA <= vertMax; vertIdA++) {
            for (int vertIdB = 1; vertIdB <= vertMax; vertIdB++) {
                mat[vertIdA - 1][vertIdB - 1] = lookup(vertIdA, vertIdB);
            }
        }
        return mat;
    }


}
