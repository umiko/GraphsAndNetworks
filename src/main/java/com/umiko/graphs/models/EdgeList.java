package com.umiko.graphs.models;

import com.umiko.graphs.helpers.EdgeListParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class EdgeList extends GraphRepresentation implements Iterable<Edge>, Collection<Edge> {
    private Collection<Edge> edges = new ArrayList<>();

    public EdgeList(Collection<Edge> edges) {
        this.edges = edges;
        for (Edge e : edges) {
            if (e.isDirected())
                this.setDirected(true);
            if (e.isWeighted())
                this.setWeighted(true);
        }
    }

    public EdgeList(File f) {
        this(EdgeListParser.parse(f));
    }

    public EdgeList(String filepath) {
        this(EdgeListParser.parse(filepath));
    }

    public int getNodeCount() {
        Collection<Integer> nodeIds = new ArrayList<>();
        for (Edge e : edges) {
            if (!nodeIds.contains(e.getFrom())) {
                nodeIds.add(e.getFrom());
            }
            if (!nodeIds.contains(e.getTo())) {
                nodeIds.add(e.getTo());
            }
        }
        return nodeIds.size();
    }

    public Collection<Edge> getIncidentEdges(int vertId) {
        Collection<Edge> incidentEdges = new ArrayList<>();
        for (Edge e : edges) {
            if (e.contains(vertId)) {
                if (!isDirected() || e.getFrom() == vertId)
                    incidentEdges.add(e);
            }
        }
        return incidentEdges;
    }

    public Edge getEdge(int edgeIndex) {
        return (Edge) edges.toArray()[edgeIndex];
    }

    @Override
    public EdgeList toEdgeList() {
        return this;
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


    //region overrides

    @Override
    public int size() {
        return edges.size();
    }

    @Override
    public boolean isEmpty() {
        return edges.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return edges.contains(o);
    }

    @Override
    public Iterator<Edge> iterator() {
        return edges.iterator();
    }

    @Override
    public Object[] toArray() {
        return edges.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return edges.toArray(a);
    }

    @Override
    public boolean add(Edge edge) {
        return edges.add(edge);
    }

    @Override
    public boolean remove(Object o) {
        return edges.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return edges.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Edge> c) {
        return edges.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return edges.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return edges.retainAll(c);
    }

    @Override
    public void clear() {
        edges.clear();
    }

    @Override
    public void forEach(Consumer<? super Edge> action) {
        edges.forEach(action);
    }

    @Override
    public Spliterator<Edge> spliterator() {
        return edges.spliterator();
    }

    @Override
    public String toString() {
        return "EdgeList{" +
                "edges=" + edges.toString() +
                ", isStrict=" + isStrict +
                ", isDirected=" + isDirected +
                ", isWeighted=" + isWeighted +
                '}';
    }

    //endregion
}
