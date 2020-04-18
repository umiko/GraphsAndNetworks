package com.umiko.graphs.models;

public class Edge {
    private int from, to, weight;
    private boolean directed;
    private boolean weighted;

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isDirected() {
        return directed;
    }

    public boolean isWeighted() {
        return weighted;
    }

    private Edge(int from, int to, int weight, boolean directed, boolean weighted) {
        this.from = from;
        this.to = to;
        this.weight = weight;
        this.directed = directed;
        this.weighted = weighted;
    }

    public Edge(int from, int to, int weight, boolean directed) {
        this(from, to, weight, directed, true);
    }

    public Edge(int from, int to, boolean directed) {
        this(from, to, 1, directed, false);
    }

    public Edge(int from, int to, int weight) {
        this(from, to, weight, false, true);
    }

    public Edge(int from, int to) {
        this(from, to, 1, false, false);
    }

    public boolean contains(int v) {
        return v == from || v == to;
    }

    public int getOther(int v) {
        if (contains(v)) {
            return from == v ? to : from;
        }
        throw new IllegalArgumentException(String.format("This edge (%s) does not contain %d.", toString(), v));
    }

    public void reverse() {
        int temp = getFrom();
        from = getTo();
        to = temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (from != edge.from) return false;
        if (to != edge.to) return false;
        if (weight != edge.weight) return false;
        if (directed != edge.directed) return false;
        return weighted == edge.weighted;
    }

    @Override
    public String toString() {
        return from +
                (directed ? " -> " : " -- ") +
                to;
    }
}
