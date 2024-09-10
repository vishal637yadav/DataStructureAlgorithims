package sourcecode.mycollection.graph.bfs;

import sourcecode.mycollection.graph.representation.ArrayOfArrayListOfEdgesDemo;

public class BreadthFirstSearchDemo2 {

        /*
        Sample Graph
        1--- 3
      /     | \
     0     |   5--6
      \    | /
       2---4
        */

    static ArrayOfArrayListOfEdgesDemo createSingleConnectedComponentGraph() {
        ArrayOfArrayListOfEdgesDemo graphInstance = new ArrayOfArrayListOfEdgesDemo(7);
        graphInstance.addVertex(0, 1);
        graphInstance.addVertex(0, 2);
        graphInstance.addVertex(1, 0);
        graphInstance.addVertex(1, 3);
        graphInstance.addVertex(2, 0);
        graphInstance.addVertex(2, 4);
        graphInstance.addVertex(3, 1);
        graphInstance.addVertex(3, 4);
        graphInstance.addVertex(3, 5);
        graphInstance.addVertex(4, 2);
        graphInstance.addVertex(4, 3);
        graphInstance.addVertex(4, 5);
        graphInstance.addVertex(5, 3);
        graphInstance.addVertex(5, 4);
        graphInstance.addVertex(5, 6);
        graphInstance.addVertex(6, 5);
        System.out.println(graphInstance);

        return graphInstance;
    }

    /*
    0---1---2
    3---4---5
    6---7---8
     */

    static ArrayOfArrayListOfEdgesDemo createMultipleDisConnectedComponentGraph() {
        ArrayOfArrayListOfEdgesDemo graphInstance = new ArrayOfArrayListOfEdgesDemo(9);
        graphInstance.addVertex(0, 1);
        graphInstance.addVertex(1, 0);

        graphInstance.addVertex(1, 2);
        graphInstance.addVertex(2, 1);

        graphInstance.addVertex(3, 4);
        graphInstance.addVertex(4, 3);

        graphInstance.addVertex(4, 5);
        graphInstance.addVertex(5, 4);

        graphInstance.addVertex(6, 7);
        graphInstance.addVertex(7, 6);

        graphInstance.addVertex(7, 8);
        graphInstance.addVertex(8, 7);

        System.out.println(graphInstance);
        return graphInstance;
    }

    public static void main(String[] args) {

        ArrayOfArrayListOfEdgesDemo graphSingleComponentInstance = createSingleConnectedComponentGraph();
        graphSingleComponentInstance.bfs_forSingleConnectedComponentGraph(0);
        graphSingleComponentInstance.bfs_forSingleConnectedComponentGraph(1);
        graphSingleComponentInstance.bfs_forSingleConnectedComponentGraph(2);
        graphSingleComponentInstance.bfs_forSingleConnectedComponentGraph(3);
        graphSingleComponentInstance.bfs_forSingleConnectedComponentGraph(4);
        graphSingleComponentInstance.bfs_forSingleConnectedComponentGraph(5);
        graphSingleComponentInstance.bfs_forSingleConnectedComponentGraph(6);

        ArrayOfArrayListOfEdgesDemo graphDisConnectedComponent = createMultipleDisConnectedComponentGraph();
        graphDisConnectedComponent.bfs_forSingleConnectedComponentGraph(0);
        graphDisConnectedComponent.bfs_forMultipleDisConnectedComponentGraph();

        graphSingleComponentInstance.dfs(0);
        graphSingleComponentInstance.dfs(1);
        graphSingleComponentInstance.dfs(2);
        graphSingleComponentInstance.dfs(3);

        graphDisConnectedComponent.dfs_multiComponentGraph();

    }
}
