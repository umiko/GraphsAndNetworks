package com.umiko.graphs.algorithms;

import com.umiko.graphs.helpers.SortByFinishTime;
import com.umiko.graphs.models.DFSTree;
import com.umiko.graphs.models.IGraphRepresentation;
import com.umiko.graphs.models.Node;

import java.util.ArrayList;
import java.util.Collection;

import static com.umiko.graphs.models.Color.BLACK;
import static com.umiko.graphs.models.Color.WHITE;

public class StronglyConnectedComponents extends TopologicalSort {
    public StronglyConnectedComponents(IGraphRepresentation graphRepresentation, int rootNodeId) {
        super(graphRepresentation, rootNodeId);
    }

    @Override
    public void run() {
        super.run();
        graphRepresentation.reverse();
        graphRepresentation.setDirected(true);
        setColorForAllNodes(WHITE);
        forest.clear();
        generateSCCForest();
    }

    @Override
    public void displayResult() {
        System.out.println("SCC");
        System.out.println(buildResultString());
    }

    public Collection<DFSTree> generateSCCForest() {
        for (int vertexId = 1; vertexId <= graphRepresentation.getNodeCount(); vertexId++) {
            if (nodes.get(vertexId).getColor() == WHITE) {
                forest.add(visitSCC(nodes.get(vertexId)));
            }
        }
        return forest;
    }

    public DFSTree visitSCC(Node u) {
        time++;
        u.setTimeDiscovered(time);
        u.setColor(BLACK);
        ArrayList<Node> possibleChildNodes = new ArrayList<>();
        for (int possibleChildNodeId : u.getNeighbourIds()) {
            possibleChildNodes.add(nodes.get(possibleChildNodeId));
        }
        possibleChildNodes.sort(new SortByFinishTime().reversed());
        for (Node possibleChild : possibleChildNodes) {
            if (possibleChild.getColor() == WHITE) {
                if (possibleChild.getId() == targetNodeId) {
                    isTargetFound = true;
                }
                possibleChild.setParentId(u.getId());
                visit(possibleChild);
            }
        }
        time++;
        u.setTimeFinished(time);
        return new DFSTree(nodes, u.getId());
    }

    public String buildResultString() {
        StringBuilder sb = new StringBuilder();

        for (DFSTree tree : forest) {
            sb.append(tree.toString());
        }

        return sb.toString();
    }
}
