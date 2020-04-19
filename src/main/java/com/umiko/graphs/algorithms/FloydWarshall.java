package com.umiko.graphs.algorithms;

import com.umiko.graphs.models.GraphRepresentation;

public class FloydWarshall extends GraphAlgorithm {

    int[][] weights;

    public FloydWarshall(GraphRepresentation graphRepresentation) {
        this.graphRepresentation = graphRepresentation;
        this.graphRepresentation.setDirected(true);
    }

    @Override
    public void run() {
        int n = graphRepresentation.getNodeCount();
        weights = getWeightMatrix();
        int[][] D = getWeightMatrix();
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    D[i - 1][j - 1] = d(k, i, j);
                }
            }
        }
        weights = D;
    }

    public int d(int k, int i, int j) {
        if (k == 0) {
            return weights[i - 1][j - 1];
        } else {
            int a, b;
            if (d(k - 1, i, k) == Integer.MAX_VALUE || d(k - 1, k, j) == Integer.MAX_VALUE)
                return Math.min(d(k - 1, i, j), Integer.MAX_VALUE);
            return Math.min(d(k - 1, i, j), d(k - 1, i, k) + d(k - 1, k, j));
        }
    }

    @Override
    public void displayResult() {
        System.out.println("Floyd-Warshall\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights.length; j++) {
                sb.append(weights[i][j] == Integer.MAX_VALUE ? "INF" : weights[i][j]);
                sb.append("\t\t");
            }
            sb.append("\n\n");
        }
        System.out.println(sb);
    }

    public int[][] getWeightMatrix() {
        int[][] weightMatrix = graphRepresentation.toAdjacencyMatrix().getRawMatrix();
        for (int i = 0; i < graphRepresentation.getNodeCount(); i++) {
            for (int j = 0; j < graphRepresentation.getNodeCount(); j++) {
                switch (weightMatrix[i][j]) {
                    case 1:
                        weightMatrix[i][j] = graphRepresentation.getEdge(i + 1, j + 1).getWeight();
                        break;
                    case 2:
                        weightMatrix[i][j] = 0;
                        break;
                    default:

                        weightMatrix[i][j] = i == j ? 0 : Integer.MAX_VALUE;
                        break;
                }


            }
        }
        return weightMatrix;
    }
}
