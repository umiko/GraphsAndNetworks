package com.umiko.graphs.models;

public abstract class AdvancedGraphRepresentation implements IGraphRepresentation {
    EdgeList edgeList;


    @Override
    public EdgeList toEdgeList() {
        return edgeList;
    }

    @Override
    public IncidenceMatrix toIncidenceMatrix() {
        return null;
    }

    @Override
    public AdjacencyMatrix toAdjacencyMatrix() {
        return null;
    }

    @Override
    public AdjacencyList toAdjacencyList() {
        return null;
    }

    @Override
    public boolean isStrict() {
        return edgeList.isStrict();
    }

    @Override
    public void setStrict(boolean strict) {
        edgeList.setStrict(strict);
    }

    @Override
    public boolean isDirected() {
        return edgeList.isDirected();
    }

    @Override
    public void setDirected(boolean directed) {
        edgeList.setDirected(directed);
    }

    @Override
    public boolean isWeighted() {
        return edgeList.isWeighted();
    }

    @Override
    public void setWeighted(boolean weighted) {
        edgeList.setWeighted(weighted);
    }

    public void addEdge(Edge edge) {
        edgeList.add(edge);
    }
}