package com.umiko.graphs.helpers;

import com.umiko.graphs.models.Node;

import java.util.Comparator;

public class SortByFinishTime implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return Integer.compare(o1.getTimeFinished(), o2.getTimeFinished());
    }
}
