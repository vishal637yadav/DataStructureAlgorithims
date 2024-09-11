package sourcecode.mycollection.graph.representation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjacentMatrixDemo2 {

    int[][] graph;
    static int maxRow = 4;
    static int maxCol = 4;

    public AdjacentMatrixDemo2() {
        this.graph = new int[maxRow][maxCol];
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
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
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
                "\t,\n\tmaxRow=" + maxRow +
                "\t,\n\tmaxCol=" + maxCol +
                "\n}";
    }

    public static List<String> getNeighbourList(int r, int c) {
        String currIndex = r + "," + c;
        /*
        System.out.println("currIndex::" + currIndex);
        System.out.println("r: " + currIndex.split(",")[0]);
        System.out.println("c: " + currIndex.split(",")[1]);
        */
        System.out.println("-----------getNeighbourList---start-------------------");
        System.out.print("Neighbour of (" + r + "," + c + ") positions are :");
        List<String> nlist = new ArrayList<>();

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        int rr, cc;
        for (int i = 0; i < 4; i++) {
            rr = r + dr[i];
            cc = c + dc[i];
            if (rr >= 0 && cc >= 0 && rr < maxRow && cc < maxCol) {
                nlist.add(rr + "," + cc);
            }
        }
        System.out.println(nlist);
        System.out.println("-----------getNeighbourList---ends-------------------");
        return nlist;
    }


    public void breadthFirstSearch_AdjacencyMatrix(String currentIndex) {

        boolean[][] isVisited = new boolean[maxRow][maxCol];

        Queue<String> queue = new LinkedList<>();

        queue.add(currentIndex);

        while (!queue.isEmpty()) {
            currentIndex = queue.remove();
            int currentRowIndex = Integer.parseInt(currentIndex.split(",")[0]);
            int currentColIndex = Integer.parseInt(currentIndex.split(",")[1]);

            if (!isVisited[currentRowIndex][currentColIndex]) {
                int currentValue = graph[currentRowIndex][currentColIndex];
                System.out.println("-------------Visiting :::[" + currentRowIndex + "," + currentColIndex + "]:==:" + currentValue);
                isVisited[currentRowIndex][currentColIndex] = true;

                List<String> neighbourList = getNeighbourList(currentRowIndex, currentColIndex);

                for (int i = 0; i < neighbourList.size(); i++) {
                    System.out.println(neighbourList.get(i));
                    int neighbourRowIndex = Integer.parseInt(neighbourList.get(i).split(",")[0]);
                    int neighbourColIndex = Integer.parseInt(neighbourList.get(i).split(",")[1]);

                    if (graph[neighbourRowIndex][neighbourColIndex] == 1) {
                        System.out.println("Added in Queue for Traversal :" + neighbourList.get(i));
                        queue.add(neighbourList.get(i));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("-------------main-:--AdjacentMatrixDemo--:----------------------");
        initialiseUndirectedUnWeightedGraph();
        //initialiseUndirectedWeightedGraph();
        getNeighbourList(0, 2);
        System.out.println("-------------main-:--AdjacentMatrixDemo--:----------------------");
    }

    static void initialiseUndirectedUnWeightedGraph() {
        System.out.println("\t---initialiseUndirectedUnWeightedGraph--starts-\t");
        AdjacentMatrixDemo2 graphInstance = new AdjacentMatrixDemo2();
        graphInstance.addVertex(0, 2);
        graphInstance.addVertex(2, 3);
        graphInstance.addVertex(2, 1);
        graphInstance.addVertex(3, 1);
        System.out.println(graphInstance);
        graphInstance.breadthFirstSearch_AdjacencyMatrix("0,2");
        System.out.println("\t---initialiseUndirectedUnWeightedGraph--ends---\t");
    }

}