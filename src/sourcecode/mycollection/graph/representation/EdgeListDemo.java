package sourcecode.mycollection.graph.representation;

import java.util.ArrayList;

public class EdgeListDemo {

    private static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                     source +
                    ", " + destination +
                    ", " + weight +
                    '}';
        }
    }

    ArrayList<Edge> graph;

    public EdgeListDemo() {
        this.graph = new ArrayList<>();
    }

    public void addEdges(int source, int destination) {
        graph.add(new Edge(source, destination));
    }

    @Override
    public String toString() {
        return "EdgeListDemo{\n" +
                "\tgraph=" + graph +
                "\n}";
    }

    public static void main(String[] args) {
        System.out.println("--------------EdgeListDemo--start----------------");

        EdgeListDemo graphInstance = new EdgeListDemo();
        graphInstance.addEdges(0,2);
        graphInstance.addEdges(2,3);
        graphInstance.addEdges(2,1);
        graphInstance.addEdges(3,1);
        System.out.println(graphInstance);
        System.out.println("--------------EdgeListDemo--ends-----------------");
    }

}
