package com.umiko.graphs.algorithms;

import com.umiko.graphs.models.DFSTree;
import com.umiko.graphs.models.IGraphRepresentation;
import com.umiko.graphs.models.Node;

import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

import static com.umiko.graphs.models.Color.BLACK;
import static com.umiko.graphs.models.Color.WHITE;

public class DepthFirstSearch extends GraphAlgorithm {

    private int rootNodeId;
    protected int targetNodeId;
    protected int time;
    protected boolean isTargetFound;
    protected Collection<DFSTree> forest = new HashSet<>();

    public DepthFirstSearch(IGraphRepresentation graphRepresentation, int rootNodeId, int targetNodeId) {
        this.rootNodeId = rootNodeId;
        this.targetNodeId = targetNodeId;
        this.time = 0;
        this.graphRepresentation = graphRepresentation;
    }

    public Collection<DFSTree> generateForest() {
        for (int vertexId = 1; vertexId <= graphRepresentation.getNodeCount(); vertexId++) {
            if (nodes.get(vertexId) == null) {
                nodes.put(vertexId, new Node(vertexId, graphRepresentation));
            }
            if (nodes.get(vertexId).getColor() == WHITE) {
                forest.add(visit(nodes.get(vertexId)));
            }
        }
        return forest;
    }

    public DFSTree visit(Node u) {
        time++;
        u.setTimeDiscovered(time);
        u.setColor(BLACK);
        Node v;
        for (int possibleChildId : u.getNeighbourIds()) {
            if ((v = nodes.get(possibleChildId)) == null) {
                nodes.put(possibleChildId, new Node(possibleChildId, u.getId(), graphRepresentation));
                v = nodes.get(possibleChildId);
            }
            if (v.getColor() == WHITE) {
                if (v.getId() == targetNodeId) {
                    isTargetFound = true;
                }
                v.setParentId(u.getId());
                visit(v);
            }
        }
        time++;
        u.setTimeFinished(time);
        return new DFSTree(nodes, u.getId());
    }

    @Override
    public void run() {
        generateForest();
    }

    @Override
    public void displayResult() {
        System.out.println("DFS");
        for (DFSTree t : forest) {
            if (t.containsNode(rootNodeId) && t.containsNode(targetNodeId)) {
                this.nodes = t.getTree();
            }
        }
        System.out.println(buildResultString());
    }

    public String buildResultString() {
        if (nodes.get(targetNodeId).getParentId() == 0 && targetNodeId == rootNodeId)
            return ("Target node was not found");
        StringBuilder sb = new StringBuilder();
        Deque<Node> route = new LinkedList<>();
        Node currentNode = nodes.get(targetNodeId);
        //build path from target to root
        while (currentNode.getParentId() != 0) {
            route.add(currentNode);
            currentNode = nodes.get(currentNode.getParentId());
        }
        //add path node by node in reverse to the string
        while (route.size() != 0) {
            sb.append(route.removeLast());
        }
        return sb.toString();
    }
}
