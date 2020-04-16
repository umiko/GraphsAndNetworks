package com.umiko.graphs.models;

import java.util.Collection;

public class Node extends Vertex{
    private int parentId, distanceToRoot, timeDiscovered, timeFinished;
    private Color color;
    private Collection<Integer> childIds;
}