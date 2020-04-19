package com.umiko.graphs.algorithms;

import com.umiko.graphs.helpers.SortByDistanceToRoot;
import com.umiko.graphs.models.Edge;
import com.umiko.graphs.models.GraphRepresentation;
import com.umiko.graphs.models.Node;

import java.util.ArrayList;

public class BellmannFord extends SingleSourceShortestPath {

    private boolean hasNegativeCycle = false;

    public BellmannFord(GraphRepresentation graphRepresentation, int rootNodeId) {
        this.graphRepresentation = graphRepresentation;
        this.graphRepresentation.setDirected(true);
        this.rootNodeId = rootNodeId;
    }

    @Override
    public void run() {
        initializeSingleSource();

        Node u, v;

        for (int vertIndex = 1; vertIndex <= graphRepresentation.getNodeCount(); vertIndex++) {
            for (Edge edge : graphRepresentation.toEdgeList()) {
                Relax(nodes.get(edge.getFrom()), nodes.get(edge.getTo()), edge.getWeight());
            }
        }

        for (Edge edge : graphRepresentation.toEdgeList()) {
            if (nodes.get(edge.getTo()).getDistanceToRoot() > nodes.get(edge.getFrom()).getDistanceToRoot() + edge.getWeight()) {
                hasNegativeCycle = true;
                break;
            }
        }
    }

    @Override
    public void displayResult() {
        System.out.println("Bellmann-Ford");
        System.out.println("There were " + (hasNegativeCycle ? "no " : "") + "negative cycles detected.");

        ArrayList<Node> resultNodes = new ArrayList<>(nodes.values());
        resultNodes.sort(new SortByDistanceToRoot());
        resultNodes.forEach(node -> {
            System.out.print(" with a total distance from root of " + node.getDistanceToRoot() + ": ");
            System.out.print(node.toString());
        });
    }
}
