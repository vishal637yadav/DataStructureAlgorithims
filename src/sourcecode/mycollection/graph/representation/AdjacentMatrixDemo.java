package sourcecode.mycollection.graph.representation;

import java.util.LinkedList;
import java.util.Queue;

public class AdjacentMatrixDemo {

    int[][] graph;
    int vertexCount;

    public AdjacentMatrixDemo(int vertexCount) {
        this.vertexCount = vertexCount;
        this.graph = new int[vertexCount][vertexCount];
    }

    public void addVertex(int sourceVertexIndex, int destinationVertexIndex) {
        graph[sourceVertexIndex][destinationVertexIndex] = 1;
        graph[destinationVertexIndex][sourceVertexIndex] = 1;
    }

    public void addVertex(int sourceVertexIndex, int destinationVertexIndex, int weight) {
        graph[sourceVertexIndex][destinationVertexIndex] = weight;
        graph[destinationVertexIndex][sourceVertexIndex] = weight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                if (j == 0) {
                    sb.append("\t\t").append(graph[i][j]);
                } else {
                    sb.append(", ").append(graph[i][j]);
                }
            }
            sb.append("\n");
        }

        return "AdjacentMatrixDemo\n{\n" +
                "\tgraph=" + sb +
                "\t,\n\tvertexCount=" + vertexCount +
                "\n}";
    }

    public void bfs(int source){
        /* Implement soon
        boolean [][] isVisited = new boolean[this.vertexCount][this.vertexCount];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        int currentVertex;

        while(!queue.isEmpty()){
            currentVertex = queue.remove();

            if(!isVisited[currentVertex]){
                System.out.print(currentVertex);
                isVisited[][currentVertex]=true;

            }

        }
        */

    }

    public static void main(String[] args) {
        System.out.println("-------------main-:--AdjacentMatrixDemo--:----------------------");
        initialiseUndirectedUnWeightedGraph();
        initialiseUndirectedWeightedGraph();
        System.out.println("-------------main-:--AdjacentMatrixDemo--:----------------------");
    }

    static void initialiseUndirectedUnWeightedGraph() {
        System.out.println("\t---initialiseUndirectedUnWeightedGraph--starts-\t");
        AdjacentMatrixDemo graphInstance = new AdjacentMatrixDemo(4);
        graphInstance.addVertex(0, 2);
        graphInstance.addVertex(2, 3);
        graphInstance.addVertex(2, 1);
        graphInstance.addVertex(3, 1);
        System.out.println(graphInstance);
        System.out.println("\t---initialiseUndirectedUnWeightedGraph--ends---\t");
    }

    static void initialiseUndirectedWeightedGraph() {
        System.out.println("\t---initialiseUndirectedWeightedGraph--starts-\t");
        AdjacentMatrixDemo graphInstance = new AdjacentMatrixDemo(4);
        graphInstance.addVertex(0, 2, 2);
        graphInstance.addVertex(2, 3, -1);
        graphInstance.addVertex(2, 1, 10);
        graphInstance.addVertex(3, 1, 0);
        System.out.println(graphInstance);
        System.out.println("\t---initialiseUndirectedWeightedGraph--ends---\t");
    }

}
