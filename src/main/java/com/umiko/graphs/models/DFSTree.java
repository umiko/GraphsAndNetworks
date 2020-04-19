package com.umiko.graphs.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import static com.umiko.graphs.models.Color.BLACK;
import static com.umiko.graphs.models.Color.WHITE;

public class DFSTree extends GraphRepresentation {

    private HashMap<Integer, Node> tree;
    private int rootId;

    //region accessors

    public HashMap<Integer, Node> getTree() {
        return tree;
    }

    public void setTree(HashMap<Integer, Node> tree) {
        this.tree = tree;
    }

    public int getRootId() {
        return rootId;
    }

    public void setRootId(int rootId) {
        this.rootId = rootId;
    }

    //endregion

    public DFSTree(HashMap<Integer, Node> tree, int rootId) {
        this.tree = tree;
        this.rootId = rootId;
    }

    public boolean containsNode(int nodeId) {
        return this.tree.get(nodeId) != null;
    }

    @Override
    public Edge getEdge(int u, int v) {
        return toEdgeList().getEdge(u, v);
    }

    @Override
    public EdgeList toEdgeList() {
        Node currentNode;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Edge> resultTreeEdges = new ArrayList<>();

        q.add(rootId);

        while (!q.isEmpty()) {
            if ((currentNode = tree.get(q.remove())) == null)
                return null;
            //add edge to nodes parent
            if (currentNode.getParentId() != -1)
                resultTreeEdges.add(new Edge(currentNode.getParentId(), currentNode.getId()));
            //add neighbours that have not been worked on yet to the queue
            for (int i : currentNode.getNeighbourIds()) {
                //we are getting an already worked on node, so the role of the colours is reversed
                if (tree.get(i).getColor() == BLACK) {
                    q.add(i);
                }
            }
            currentNode.setColor(WHITE);
        }
        return new EdgeList(resultTreeEdges);
    }

    @Override
    public IncidenceMatrix toIncidenceMatrix() {
        return new IncidenceMatrix(this.toEdgeList());
    }

    @Override
    public AdjacencyMatrix toAdjacencyMatrix() {
        return new AdjacencyMatrix(this.toEdgeList());

    }

    @Override
    public AdjacencyList toAdjacencyList() {
        return new AdjacencyList(this.toEdgeList());

    }

    @Override
    public void reverse() {

    }

    @Override
    public int getNodeCount() {
        return toEdgeList().getNodeCount();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Tree{\n");
        for (Node n :
                tree.values()) {
            sb.append("\t" + n.toString());
        }
        sb.append("}\n\n");
        return sb.toString();
    }
}
