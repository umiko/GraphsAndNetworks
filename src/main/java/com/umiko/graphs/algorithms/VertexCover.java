package com.umiko.graphs.algorithms;

import com.umiko.graphs.models.Edge;
import com.umiko.graphs.models.EdgeList;

public class VertexCover extends GraphAlgorithm {
    EdgeList removedEdges;

    @Override
    public void run() {
        EdgeList localEdgeList = graphRepresentation.toEdgeList();


        while (localEdgeList.getEdgeCount() > 0) {
            Edge e = localEdgeList.getEdge(0);
            localEdgeList.removeAll(localEdgeList.getIncidentEdges(e.getFrom()));
            localEdgeList.removeAll(localEdgeList.getIncidentEdges(e.getTo()));
            removedEdges.add(e);
        }
    }

    @Override
    public void displayResult() {

    }
}
