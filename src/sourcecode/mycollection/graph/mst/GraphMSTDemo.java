package sourcecode.mycollection.graph.mst;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphMSTDemo {
    public static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    private static class Pair implements Comparable<Pair> {
        int vertex;
        int cost;

        public Pair(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }

    ArrayList<Edge>[] vertexesArray;

    public GraphMSTDemo(int vertexCount) {
        this.vertexesArray = new ArrayList[vertexCount];
        //initialise each vertices Edge List
        for (int i = 0; i < vertexesArray.length; i++) {
            vertexesArray[i] = new ArrayList<>();
        }
    }

    private void initialiseGraph() {

        vertexesArray[0].add(new Edge(0, 1, 10));
        vertexesArray[0].add(new Edge(0, 2, 15));
        vertexesArray[0].add(new Edge(0, 3, 30));

        this.vertexesArray[1].add(new Edge(1, 0, 10));
        this.vertexesArray[1].add(new Edge(1, 3, 40));

        this.vertexesArray[2].add(new Edge(2, 0, 15));
        this.vertexesArray[2].add(new Edge(2, 3, 50));

        vertexesArray[3].add(new Edge(3, 0, 30));
        vertexesArray[3].add(new Edge(3, 1, 40));
        vertexesArray[3].add(new Edge(3, 2, 50));

    }

    //Uses BFS Algo---
    public void minimumSpanningTree_MST(int startVertex) {
        System.out.println("---------bfs ends------starting-------" + startVertex);
        Pair startingPair = new Pair(0, 0);
        boolean[] isVisited = new boolean[this.vertexesArray.length];

        Queue<Pair> q = new PriorityQueue<>();

        q.add(startingPair);

        Pair currentVertex;
        int finalCost = 0;
        while (!q.isEmpty()) {
            currentVertex = q.remove();
            if (!isVisited[currentVertex.vertex]) {
                visit(currentVertex.vertex);
                finalCost += currentVertex.cost;
                isVisited[currentVertex.vertex] = true;
                for (int i = 0; i < vertexesArray[currentVertex.vertex].size(); i++) {
                    Edge edge = vertexesArray[currentVertex.vertex].get(i);
                    if (!isVisited[edge.destination]) {
                        q.add(new Pair(edge.destination, edge.weight));
                    }
                }
            }
        }
        System.out.println();
        System.out.println("finalCost::" + finalCost);
        System.out.println("---------bfs ends-------------");
    }

    private void visit(int currentVertex) {
        System.out.print(" " + currentVertex);
    }

    public static void main(String[] args) {
        System.out.println("---main-------");

        GraphMSTDemo mstDemo = new GraphMSTDemo(4);
        mstDemo.initialiseGraph();

        mstDemo.minimumSpanningTree_MST(0);

    }

}
