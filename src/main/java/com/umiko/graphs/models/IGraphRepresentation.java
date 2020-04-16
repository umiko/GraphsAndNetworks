package com.umiko.graphs.models;

public interface IGraphRepresentation {
    public EdgeList toEdgeList();

    public IncidenceMatrix toIncidenceMatrix();

    public AdjacencyMatrix toAdjacencyMatrix();

    public AdjacencyList toAdjacencyList();

    public boolean isStrict();

    public void setStrict(boolean strict);

    public boolean isDirected();

    public void setDirected(boolean directed);

    public boolean isWeighted();

    public void setWeighted(boolean weighted);
}
