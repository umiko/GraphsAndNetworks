package com.umiko.graphs.models;

import java.util.Collection;
import java.util.HashSet;

public class Vertex {
    protected int id;
    protected Collection<Integer> neighbourIds;

    private Vertex() {

    }

    public Vertex(int id) {
        this(id, new HashSet<Integer>());
    }

    public Vertex(int id, Collection<Integer> neighbourIds) {
        this.id = id;
        this.neighbourIds = neighbourIds;
    }

    //region accessors

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Integer> getNeighbourIds() {
        return neighbourIds;
    }

    public void setNeighbourIds(Collection<Integer> neighbourIds) {
        this.neighbourIds = neighbourIds;
    }

    //endregion
}
