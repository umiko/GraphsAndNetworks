package com.umiko.graphs.models;

import java.io.File;
import java.util.ArrayList;

public class AdjacencyList extends AdvancedGraphRepresentation {

    private AdjacencyList() {
    }

    public AdjacencyList(EdgeList el) {
        this.edgeList = el;
    }

    public AdjacencyList(File f) {
        this.edgeList = new EdgeList(f);
    }

    public int[] getAdjacencyListByVertex(int v) {
        ArrayList<Edge> edges = new ArrayList<>(edgeList.getIncidentEdges(v));
        int[] adjacentVertices = new int[edges.size()];
        for (int i = 0; i < adjacentVertices.length; i++) {

            adjacentVertices[i] = edges.get(i).getOther(v);
        }
        return adjacentVertices;
    }

    public int[][] getRawAdjacencyList() {
        int[][] adjacencyList = new int[edgeList.getNodeCount()][];
        for (int vertIndex = 1; vertIndex <= edgeList.getNodeCount(); vertIndex++) {
            adjacencyList[vertIndex - 1] = getAdjacencyListByVertex(vertIndex);
        }
        return adjacencyList;
    }
}
