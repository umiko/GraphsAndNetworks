package com.umiko.graphs;

import com.umiko.graphs.algorithms.Kruskal;
import com.umiko.graphs.algorithms.StronglyConnectedComponents;
import com.umiko.graphs.algorithms.TopologicalSort;
import com.umiko.graphs.models.EdgeList;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        TopologicalSort ts = new TopologicalSort(new EdgeList(new File("src/test/resources/k3_3.txt")), 1);
        ts.run();
        ts.displayResult();

        StronglyConnectedComponents scc = new StronglyConnectedComponents(new EdgeList(new File("src/test/resources/k3_3.txt")), 1);
        scc.run();
        scc.displayResult();

        Kruskal kruskal = new Kruskal(new EdgeList(new File("src/test/resources/primkruskal.txt")));
        kruskal.run();
        kruskal.displayResult();
    }
}
