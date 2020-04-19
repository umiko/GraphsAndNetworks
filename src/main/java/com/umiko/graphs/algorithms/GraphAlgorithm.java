package com.umiko.graphs.algorithms;

import com.umiko.graphs.models.Color;
import com.umiko.graphs.models.Edge;
import com.umiko.graphs.models.IGraphRepresentation;
import com.umiko.graphs.models.Node;

import java.util.HashMap;

public abstract class GraphAlgorithm {
    protected IGraphRepresentation graphRepresentation;

    protected HashMap<Integer, Node> nodes = new HashMap<>();

    public abstract void run();

    public abstract void displayResult();

    public void setColorForAllNodes(Color c) {
        for (Node n :
                nodes.values()) {
            n.setColor(c);
        }
    }

    public Edge getEdge(int uId, int vId) {
        Edge e;
        if (graphRepresentation.getNodeCount() >= uId && graphRepresentation.getNodeCount() >= vId) {
            if (nodes.get(uId).getNeighbourIds().contains(vId)) {
                for (Edge incidentEdge : graphRepresentation.toEdgeList().getIncidentEdges(uId)) {
                    if (incidentEdge.contains(vId)) {
                        return incidentEdge;
                    }
                }
            }
        }
        return null;
    }

    public void buildNodeCollection() {
        graphRepresentation.toEdgeList().forEach(edge -> {
            nodes.put(edge.getFrom(), new Node(edge.getFrom(), graphRepresentation));
            nodes.put(edge.getTo(), new Node(edge.getTo(), graphRepresentation));
        });
    }
}
