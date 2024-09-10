package sourcecode.mycollection.graph.adjecentmatrix;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListOfEdges {

    private static class Node {
        String nodeName;
        List<Edges> edgesList;

        public Node(String nodeName) {
            this.nodeName = nodeName;
            this.edgesList = new ArrayList<>();
        }
    }

    private static class Edges {
        String sourceNode;
        String destinationNode;
        int edgeWeight;

        public Edges(String sourceNode, String destinationNode) {
            this.sourceNode = sourceNode;
            this.destinationNode = destinationNode;
        }

        public Edges(String sourceNode, String destinationNode, int edgeWeight) {
            this.sourceNode = sourceNode;
            this.destinationNode = destinationNode;
            this.edgeWeight = edgeWeight;
        }
    }


    Node[] graph;
    int numberOfNodes;

    public AdjacencyListOfEdges(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        graph = new Node[numberOfNodes];
    }

    public static AdjacencyListOfEdges initialiseGraph() {
        System.out.println("---------------Graph------------------");
        AdjacencyListOfEdges adjacencyListGraph = new AdjacencyListOfEdges(7);
        adjacencyListGraph.graph[0] = new Node("0");
        adjacencyListGraph.graph[0].edgesList.add(new Edges("0","1"));
        adjacencyListGraph.graph[0].edgesList.add(new Edges("0","3"));

        adjacencyListGraph.graph[1] = new Node("1");
        adjacencyListGraph.graph[1].edgesList.add(new Edges("1","0"));
        adjacencyListGraph.graph[1].edgesList.add(new Edges("1","2"));

        adjacencyListGraph.graph[2] = new Node("2");
        adjacencyListGraph.graph[2].edgesList.add(new Edges("2","1"));
        adjacencyListGraph.graph[2].edgesList.add(new Edges("2","3"));

        adjacencyListGraph.graph[3] = new Node("3");
        adjacencyListGraph.graph[3].edgesList.add(new Edges("3","0"));
        adjacencyListGraph.graph[3].edgesList.add(new Edges("3","2"));
        adjacencyListGraph.graph[3].edgesList.add(new Edges("3","4"));

        adjacencyListGraph.graph[4] = new Node("4");
        adjacencyListGraph.graph[4].edgesList.add(new Edges("4","5"));
        adjacencyListGraph.graph[4].edgesList.add(new Edges("4","6"));

        adjacencyListGraph.graph[5] = new Node("5");
        adjacencyListGraph.graph[5].edgesList.add(new Edges("5","4"));
        adjacencyListGraph.graph[5].edgesList.add(new Edges("5","6"));

        adjacencyListGraph.graph[6] = new Node("6");
        adjacencyListGraph.graph[6].edgesList.add(new Edges("6","4"));
        adjacencyListGraph.graph[6].edgesList.add(new Edges("6","5"));

        return adjacencyListGraph;

    }


    public static void main(String[] args) {
        AdjacencyListOfEdges adjGraph = initialiseGraph();


    }

}
