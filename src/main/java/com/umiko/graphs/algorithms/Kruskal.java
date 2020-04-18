package com.umiko.graphs.algorithms;

import com.umiko.graphs.helpers.SortByWeight;
import com.umiko.graphs.models.Edge;
import com.umiko.graphs.models.EdgeList;
import com.umiko.graphs.models.GraphRepresentation;
import org.jgrapht.alg.util.UnionFind;

import java.security.InvalidParameterException;
import java.util.HashSet;

public class Kruskal extends GraphAlgorithm {

    private UnionFind<Integer> uf = new UnionFind<Integer>(new HashSet<Integer>());
    protected EdgeList spanningTree = new EdgeList();

    public Kruskal(GraphRepresentation graphRepresentation) {
        if (graphRepresentation.isWeighted())
            this.graphRepresentation = graphRepresentation;
        else
            throw new InvalidParameterException("Weighted edges required");
    }


    @Override
    public void run() {
        for (int vertId = 1; vertId <= graphRepresentation.getNodeCount(); vertId++) {
            uf.addElement(vertId);
        }
        EdgeList el = graphRepresentation.toEdgeList();
        el.sort(new SortByWeight());
        for (Edge edge : el) {
            if (!uf.inSameSet(edge.getFrom(), edge.getTo())) {
                spanningTree.add(edge);
                uf.union(edge.getFrom(), edge.getTo());
            }
        }

    }

    @Override
    public void displayResult() {
        System.out.println(spanningTree.toString());
    }
}
