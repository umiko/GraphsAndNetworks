package com.umiko.graphs.algorithms;

import com.umiko.graphs.models.IGraphRepresentation;
import com.umiko.graphs.models.Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import static com.umiko.graphs.models.Color.BLACK;
import static com.umiko.graphs.models.Color.WHITE;

public class BreadthFirstSearch extends GraphAlgorithm {

    private int rootNodeId, targetNodeId;

    private BreadthFirstSearch() {
    }

    public BreadthFirstSearch(IGraphRepresentation graphRepresentation, int rootNodeID, int targetNodeId) {
        this.graphRepresentation = graphRepresentation;
        this.rootNodeId = rootNodeID;
        this.targetNodeId = targetNodeId;
    }

    @Override
    public void run() {
        Node u, v;
        boolean isTargetFound = false;
        Queue<Node> q = new LinkedList<>();
        nodes.put(rootNodeId, new Node(rootNodeId, graphRepresentation));
        q.add(nodes.get(rootNodeId));
        q.peek().setDistanceToRoot(0);
        while (!q.isEmpty()) {
            u = q.remove();
            for (int vId : u.getNeighbourIds()) {
                if ((v = nodes.get(vId)) == null) {
                    nodes.put(vId, v = new Node(vId, u.getId(), graphRepresentation));
                    v = nodes.get(vId);
                }
                if (v.getColor() == WHITE) {
                    v.setColor(BLACK);
                    v.setParentId(u.getId());
                    v.setDistanceToRoot(u.getDistanceToRoot() + 1);
                    q.add(v);

                    if (v.getId() == targetNodeId) {
                        isTargetFound = true;
                    }
                }
            }
            u.setColor(BLACK);
        }
    }

    @Override
    public void displayResult() {
        System.out.println("BFS");
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
