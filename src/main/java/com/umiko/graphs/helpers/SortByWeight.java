package com.umiko.graphs.helpers;

import com.umiko.graphs.models.Edge;

import java.util.Comparator;

public class SortByWeight implements Comparator<Edge> {

    @Override
    public int compare(Edge o1, Edge o2) {
        return Integer.compare(o1.getWeight(), o2.getWeight());
    }
}
