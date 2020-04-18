package com.umiko.graphs.algorithms;

import com.umiko.graphs.helpers.SortByFinishTime;
import com.umiko.graphs.models.IGraphRepresentation;
import com.umiko.graphs.models.Node;

import java.util.ArrayList;

public class TopologicalSort extends DepthFirstSearch {

    protected ArrayList<Node> resultList = new ArrayList<>();

    public ArrayList<Node> getResultList() {
        return resultList;
    }

    public TopologicalSort(IGraphRepresentation graphRepresentation, int rootNodeId) {
        super(graphRepresentation, rootNodeId, 0);
    }

    @Override
    public void run() {
        super.run();
        resultList = new ArrayList<Node>(this.nodes.values());
        resultList.sort(new SortByFinishTime());
    }

    @Override
    public void displayResult() {
        StringBuilder sb = new StringBuilder();
        for (Node n : resultList) {
            sb.append(n.toString());
        }
        System.out.println(sb.toString());
    }
}
