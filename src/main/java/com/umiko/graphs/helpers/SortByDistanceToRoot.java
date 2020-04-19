package com.umiko.graphs.helpers;

import com.umiko.graphs.models.Node;

import java.util.Comparator;

public class SortByDistanceToRoot implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return Integer.compare(o1.getDistanceToRoot(), o2.getDistanceToRoot());
    }
}
