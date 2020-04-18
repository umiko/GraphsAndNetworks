package com.umiko.graphs.models;

import com.umiko.graphs.helpers.EdgeListParser;

import java.io.File;
import java.util.*;
import java.util.function.Consumer;

public class EdgeList extends GraphRepresentation implements Iterable<Edge>, Collection<Edge>, List<Edge> {
    private ArrayList<Edge> edges = new ArrayList<>();

    public EdgeList() {

    }

    public EdgeList(Collection<Edge> edges) {
        this.edges.addAll(edges);
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

    @Override
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

    public HashSet<Integer> getAdjacentNodeIds(int id) {
        Collection<Edge> incidentEdges = getIncidentEdges(id);
        HashSet<Integer> adjacentNodeIds = new HashSet<>();
        int other;
        for (Edge e : incidentEdges) {
            if ((other = e.getOther(id)) != id)
                adjacentNodeIds.add(other);
        }
        return adjacentNodeIds;
    }

    public void reverse() {
        forEach(Edge::reverse);
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
        return new IncidenceMatrix(this);
    }

    @Override
    public AdjacencyMatrix toAdjacencyMatrix() {
        return new AdjacencyMatrix(this);
    }

    @Override
    public AdjacencyList toAdjacencyList() {
        return new AdjacencyList(this);
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
    public boolean addAll(int index, Collection<? extends Edge> c) {
        return edges.addAll(index, c);
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
    public Edge get(int index) {
        return edges.get(index);
    }

    @Override
    public Edge set(int index, Edge element) {
        return edges.set(index, element);
    }

    @Override
    public void add(int index, Edge element) {
        edges.add(index, element);
    }

    @Override
    public Edge remove(int index) {
        return edges.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return edges.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return edges.lastIndexOf(o);
    }

    @Override
    public ListIterator<Edge> listIterator() {
        return edges.listIterator();
    }

    @Override
    public ListIterator<Edge> listIterator(int index) {
        return edges.listIterator(index);
    }

    @Override
    public List<Edge> subList(int fromIndex, int toIndex) {
        return edges.subList(fromIndex, toIndex);
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
