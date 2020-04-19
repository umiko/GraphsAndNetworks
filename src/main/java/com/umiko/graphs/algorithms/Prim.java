package com.umiko.graphs.algorithms;

import com.umiko.graphs.helpers.SortByDistanceToRoot;
import com.umiko.graphs.models.GraphRepresentation;
import com.umiko.graphs.models.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Prim extends SingleSourceShortestPath {

    private PriorityQueue<Node> Q = new PriorityQueue<>(new SortByDistanceToRoot());


    public Prim(GraphRepresentation graphRepresentation, int rootNodeId) {
        this.graphRepresentation = graphRepresentation;
        this.rootNodeId = rootNodeId;
    }

    @Override
    public void run() {
        initializeSingleSource();

        Q.add(nodes.get(rootNodeId));

        Node currentNode;
        Node childNode;

        while (!Q.isEmpty()) {
            currentNode = Q.remove();
            Collection<Integer> neighbourIds = currentNode.getNeighbourIds();
            for (Integer neighbourId : neighbourIds) {
                //get distance to root
                int distanceToChildFromRoot = currentNode.getDistanceToRoot() + graphRepresentation.toEdgeList().getWeight(currentNode.getId(), neighbourId);
                //if the distance to the next child is closer than the currently found, update the distance, set it to current as parent and back in the Q
                if ((childNode = nodes.get(neighbourId)).getDistanceToRoot() > distanceToChildFromRoot) {
                    childNode.setDistanceToRoot(distanceToChildFromRoot);
                    childNode.setParentId(currentNode.getId());
                    Q.add(childNode);
                }
            }
        }
        //clean up nodes
        Collection<Node> toRemove = new HashSet<Node>();
        nodes.values().forEach(node -> {
            if (node.getDistanceToRoot() == Integer.MAX_VALUE) toRemove.add(node);
        });
        toRemove.forEach(node -> {
            nodes.remove(node.getId());
        });


    }

    @Override
    public void displayResult() {
        System.out.println("Prim");
        ArrayList<Node> resultNodes = new ArrayList<>(nodes.values());
        resultNodes.sort(new SortByDistanceToRoot());
        resultNodes.forEach(node -> {
            System.out.print(" with a total distance from root of " + node.getDistanceToRoot() + ": ");
            System.out.print(node.toString());


        });
    }
}
