package com.umiko.graphs.algorithms;

import com.umiko.graphs.helpers.SortByDistanceToRoot;
import com.umiko.graphs.models.GraphRepresentation;
import com.umiko.graphs.models.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Dijkstra extends SingleSourceShortestPath {

    PriorityQueue<Node> Q = new PriorityQueue<>(new SortByDistanceToRoot());


    public Dijkstra(GraphRepresentation graphRepresentation, int rootNodeId) {
        this.graphRepresentation = graphRepresentation;
        this.rootNodeId = rootNodeId;
    }

    @Override
    public void run() {
        initializeSingleSource();
        Q.addAll(nodes.values());
        HashSet<Node> S = new HashSet<>();
        Node u, v;


        while (!Q.isEmpty()) {
            u = Q.remove();
            S.add(u);
            for (Integer neighbourId : u.getNeighbourIds()) {
                v = nodes.get(neighbourId);
                Relax(u, v, getEdge(u.getId(), v.getId()).getWeight());
            }
        }

    }

    @Override
    public void displayResult() {
        System.out.println("Dijkstra");
        ArrayList<Node> resultNodes = new ArrayList<>(nodes.values());
        resultNodes.sort(new SortByDistanceToRoot());
        resultNodes.forEach(node -> {
            System.out.print(" with a total distance from root of " + node.getDistanceToRoot() + ": ");
            System.out.print(node.toString());
        });
    }
}
