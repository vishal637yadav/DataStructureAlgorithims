package sourcecode.mycollection.graph.representation;

import sourcecode.mycollection.queue.MyQueue;
import sourcecode.mycollection.queue.Queue;

import java.util.ArrayList;

public class ArrayOfArrayListOfEdgesDemo {

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
            return "Edge[" +
                    "source=" + source +
                    ", destination=" + destination +
                    ", weight=" + weight +
                    ']';
        }
    }

    ArrayList<Edge>[] graph;
    int vertexCount;

    public ArrayOfArrayListOfEdgesDemo(int vertexCount) {
        this.vertexCount = vertexCount;
        this.graph = new ArrayList[vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            this.graph[i] = new ArrayList<>();
        }
    }

    public void addVertex(int sourceVertexIndex, int destinationVertexIndex) {
        graph[sourceVertexIndex].add(new Edge(sourceVertexIndex, destinationVertexIndex));
    }

    public void addVertex(int sourceVertexIndex, int destinationVertexIndex, int weight) {
        graph[sourceVertexIndex].add(new Edge(sourceVertexIndex, destinationVertexIndex, weight));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vertexCount; i++) {
            sb.append("\n              [").append(i).append("]-->> ").append(graph[i]);
        }


        return "ArrayOfArrayListOfEdgesDemo" +
                "\n{" +
                "\n   graph=" +
                "\n        [" + sb +
                "\n        ]," +
                "\n      vertexCount=" + vertexCount +
                "\n}";
    }

    public void bfs_forSingleConnectedComponentGraph(int source) {
        System.out.println("-----------bfs started------------");
        System.out.println("starting source::" + source);

        boolean[] isVisited = new boolean[this.vertexCount];
        Queue<Integer> queue = new MyQueue<>();
        queue.enQueue(source);
        int currentVertex;
        while (!queue.isEmpty()) {
            //de-queue queue to get currentVertex
            currentVertex = queue.deQueue();

            if (!isVisited[currentVertex]) {
                //visit current Node
                visit(currentVertex);
                //marked as Visited
                isVisited[currentVertex] = true;
                //enqueue all child/neighbours
                for (int i = 0; i < graph[currentVertex].size(); i++) {
                    queue.enQueue(graph[currentVertex].get(i).destination);
                }
            }
        }
        System.out.println();
        System.out.println("-----------bfs ended--------------");
    }

    private void visit(int data) {
        System.out.print(" " + data);
    }

    public void bfs_forMultipleDisConnectedComponentGraph() {
        System.out.println("-----------bfs started------------");

        boolean[] isVisited = new boolean[this.vertexCount];
        Queue<Integer> queue = new MyQueue<>();
        int componentCount = 0;
        for (int vertex = 0; vertex < this.vertexCount; vertex++) {

            System.out.println("starting source::" + vertex);

            if (!isVisited[vertex]) {
                componentCount++;
                queue.enQueue(vertex);
                int currentVertex;
                while (!queue.isEmpty()) {
                    //de-queue queue to get currentVertex
                    currentVertex = queue.deQueue();

                    if (!isVisited[currentVertex]) {
                        //visit current Node
                        visit(currentVertex);
                        //marked as Visited
                        isVisited[currentVertex] = true;
                        //enqueue all child/neighbours
                        for (int i = 0; i < graph[currentVertex].size(); i++) {
                            queue.enQueue(graph[currentVertex].get(i).destination);
                        }
                    }
                }
            }
            System.out.println();
        }
        System.out.println("componentCount::" + componentCount);
        System.out.println("-----------bfs ended--------------");
    }

    public void dfs(int source) {
        System.out.println("dfs source =" + source);
        boolean[] isVisited = new boolean[this.vertexCount];
        dfs_recursion(source, isVisited);
        System.out.println();
        System.out.println("---dfs---ends---");
    }

    private void dfs_recursion(int currentVertex, boolean[] isVisited) {
        // visit current Node
        visit(currentVertex);
        // marked as Visited
        isVisited[currentVertex] = true;
        // enqueue all child/neighbours
        for (int i = 0; i < graph[currentVertex].size(); i++) {
            if (!isVisited[graph[currentVertex].get(i).destination]) {
                dfs_recursion(graph[currentVertex].get(i).destination, isVisited);
            }
        }
    }

    public void dfs_multiComponentGraph() {
        boolean[] isVisited = new boolean[this.vertexCount];
        int componentCount = 0;
        for (int i = 0; i < this.vertexCount; i++) {
            System.out.println();
            System.out.println("dfs-multi-component source =" + i);
            if (!isVisited[i]) {
                dfs_recursion(i, isVisited);
                componentCount++;
            }
        }
        System.out.println("Dfs-Multi-Component-Count :=>"+componentCount);
    }

    public static void main(String[] args) {
        System.out.println("-------------Main ArrayOfArrayListOfEdgesDemo--start-------------");
        initialiseUndirectedUnWeightedGraph();
        initialiseUndirectedWeightedGraph();
        System.out.println("-------------Main ArrayOfArrayListOfEdgesDemo--ends-_------------");
    }

    static void initialiseUndirectedUnWeightedGraph() {
        System.out.println("-------------initialiseUndirectedUnWeightedGraph--start----------------");
        ArrayOfArrayListOfEdgesDemo graphInstance = new ArrayOfArrayListOfEdgesDemo(4);
        graphInstance.addVertex(0, 2);
        graphInstance.addVertex(2, 0);
        graphInstance.addVertex(2, 1);
        graphInstance.addVertex(2, 3);
        graphInstance.addVertex(1, 2);
        graphInstance.addVertex(1, 3);
        graphInstance.addVertex(3, 1);
        graphInstance.addVertex(3, 2);
        System.out.println(graphInstance);
        System.out.println("-------------initialiseUndirectedUnWeightedGraph--ends-----------------");

    }

    static void initialiseUndirectedWeightedGraph() {
        System.out.println("-------------initialiseUndirectedUnWeightedGraph--start-------------");
        ArrayOfArrayListOfEdgesDemo graphInstance = new ArrayOfArrayListOfEdgesDemo(4);
        graphInstance.addVertex(0, 2, 2);
        graphInstance.addVertex(2, 0, 2);
        graphInstance.addVertex(2, 1, 10);
        graphInstance.addVertex(2, 3, -1);
        graphInstance.addVertex(1, 2, 10);
        graphInstance.addVertex(1, 3, 0);
        graphInstance.addVertex(3, 1, 0);
        graphInstance.addVertex(3, 2, -1);
        System.out.println(graphInstance);
        System.out.println("-------------initialiseUndirectedUnWeightedGraph--ends--------------");

    }

}
