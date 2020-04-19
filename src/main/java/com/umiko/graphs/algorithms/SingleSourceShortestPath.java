package com.umiko.graphs.algorithms;

import com.umiko.graphs.models.Node;

public abstract class SingleSourceShortestPath extends GraphAlgorithm {
    int rootNodeId;

    public void initializeSingleSource() {
        buildNodeCollection();
        for (Node n : nodes.values()) {
            n.setDistanceToRoot(Integer.MAX_VALUE);
        }
        nodes.get(rootNodeId).setDistanceToRoot(0);
    }

    public void Relax(Node u, Node v, int weight) {

        if (v.getDistanceToRoot() > u.getDistanceToRoot() + weight) {
            v.setDistanceToRoot(u.getDistanceToRoot() + weight);
            v.setParentId(u.getId());
        }
    }

}
