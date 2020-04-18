package com.umiko.graphs.algorithms;

import com.umiko.graphs.models.Color;
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
}
