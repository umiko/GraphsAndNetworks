package com.umiko.graphs;

import com.umiko.graphs.algorithms.*;
import com.umiko.graphs.models.EdgeList;

public class Main {
    public static void main(String[] args) {

//        BreadthFirstSearch bfs = new BreadthFirstSearch(new EdgeList(new File("src/main/resources/k3_3.txt")), 1, 3);
//        bfs.run();
//        bfs.displayResult();
//


        BreadthFirstSearch bfs = new BreadthFirstSearch(new EdgeList("k3_3.txt"), 1, 3);
        bfs.run();
        bfs.displayResult();

        DepthFirstSearch dfs = new DepthFirstSearch(new EdgeList("k3_3.txt"), 1, 3);
        dfs.run();
        dfs.displayResult();

        TopologicalSort ts = new TopologicalSort(new EdgeList("k3_3.txt"), 1);
        ts.run();
        ts.displayResult();

        StronglyConnectedComponents scc = new StronglyConnectedComponents(new EdgeList("k3_3.txt"), 1);
        scc.run();
        scc.displayResult();

        Kruskal kruskal = new Kruskal(new EdgeList("primkruskal.txt"));
        kruskal.run();
        kruskal.displayResult();

        Prim prim = new Prim(new EdgeList("primkruskal.txt"), 1);

        prim.run();
        prim.displayResult();

        BellmannFord bf = new BellmannFord(new EdgeList("bellmannford.txt"), 1);
        bf.run();
        bf.displayResult();

        Dijkstra d = new Dijkstra(new EdgeList("dijkstra.txt"), 1);
        d.run();
        d.displayResult();

        FloydWarshall fw = new FloydWarshall(new EdgeList("FloydWarshall.txt"));
        fw.run();
        fw.displayResult();
    }
}
