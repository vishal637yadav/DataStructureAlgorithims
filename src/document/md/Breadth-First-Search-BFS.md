# Breadth First Search or BFS for a Graph
* Breadth First Search (BFS) is a fundamental **graph or tree(type of graph) traversal algorithm**.
* The algorithm starts at a designated root node (or start node) and explores all of its neighbors at the present depth level 
before moving on to the nodes at the next depth level.
* It begins with a node, then first traverses all its adjacent. Once all adjacent are visited, then their adjacent are traversed.
* BFS guarantees (**traverse vertices level by level**) that it visits all nodes at a given depth level before moving to the nodes at the next depth level.

## BFS Pseudocode
         1. Start with a **queue** data structure and **enqueue** the **starting/source** node.
         2. Mark the **starting/source** node as **visited**.
         3. **While** the **queue is not empty**:
             a. **Dequeue** a node from the **queue**.
             b. **Visit** the **dequeued node**.
             c. **Enqueue all adjacent nodes** of the dequeued node **that have not been visited yet**.
             d. **Mark the visited nodes**.
         4. Repeat 3.  until the **queue is empty**.

## **Time Complexity:** O(V+E), where V is the number of nodes and E is the number of edges.
## **Auxiliary Space:** O(V)

> [!TIP]
> Tree is also a type of Graph.
> Tree have no cycle (acyclic) and have one root node.

> [!IMPORTANT]
> Unlike trees, graphs may contain cycles, so we may come to the same node again.
> To avoid processing a node more than once, we use a boolean visited array.

## Advantages of BFS
1. It's simplicity. 
2. It ensures the shortest path to any reachable node from the starting point in an **unweighted graph**. 

## DisAdvantages of BFS
1. It requires more memory compared to Depth-First Search (DFS) because it has to store all the nodes at each level.
2. It differs than DFS in a way that **closest vertices are visited before others**.

## Problem-Solving Applications of BFS:
A lot of popular graph algorithms like 
1. Dijkstra’s shortest path 
2. Kahn’s Algorithm 
3. Prim’s algorithm are based on BFS. 
4. Cycle Detection in Directed and UnDirected Graph. 
5. Find Shortest path in an unweighted graph.
6. **Shortest Path Finding:** BFS can be used to find the shortest path between two nodes in an unweighted graph. 
By keeping track of the parent of each node during the traversal, the shortest path can be reconstructed.
7. **Cycle Detection:** BFS can be used to detect cycles in a graph. If a node is visited twice during the traversal, it indicates the presence of a cycle.
8. **Connected Components:** BFS can be used to identify connected components in a graph. Each connected component is a set of nodes that can be reached from each other.
9. **Topological Sorting:** BFS can be used to perform topological sorting on a directed acyclic graph (DAG). Topological sorting arranges the nodes in a linear order such that for any edge (u, v), u appears before v in the order.
10. **Level Order Traversal of Binary Trees:** BFS can be used to perform a level order traversal of a binary tree. This traversal visits all nodes at the same level before moving to the next level.
11. **Network Routing:** BFS can be used to find the shortest path between two nodes in a network, making it useful for routing data packets in network protocols.

### Code:
    import java.util.*;
    
    class GfG {
    
        // BFS from given source s
        static void bfs(List<List<Integer>> adj, int s) {
          
            // Create a queue for BFS
            Queue<Integer> q = new LinkedList<>();
            
            // Initially mark all the vertices as not visited
            // When we push a vertex into the q, we mark it as 
            // visited
            boolean[] visited = new boolean[adj.size()];
            
            // Mark the source node as visited and enqueue it
            visited[s] = true;
            q.add(s);
            
            // Iterate over the queue
            while (!q.isEmpty()) {
              
                // Dequeue a vertex and print it
                int curr = q.poll();
                System.out.print(curr + " ");
                
                // Get all adjacent vertices of the dequeued vertex
                // If an adjacent has not been visited, mark it 
                // visited and enqueue it
                for (int x : adj.get(curr)) {
                    if (!visited[x]) {
                        visited[x] = true;
                        q.add(x);
                    }
                }
            }
        }
    
        // Function to add an edge to the graph
        static void addEdge(List<List<Integer>> adj, int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u); // Undirected graph
        }
    
        public static void main(String[] args) {
          
            // Number of vertices in the graph
            int V = 5;
            
            // Adjacency list representation of the graph
            List<List<Integer>> adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            
            // Add edges to the graph
            addEdge(adj, 0, 1);
            addEdge(adj, 0, 2);
            addEdge(adj, 1, 3);
            addEdge(adj, 1, 4);
            addEdge(adj, 2, 4);
            
            // Perform BFS traversal starting from vertex 0
            System.out.println("BFS starting from 0:");
            bfs(adj, 0);
        }
    }

### Output
    BFS starting from 0 :
    0 1 2 3 4



> [!NOTE]
> BFS of the whole Graph which Maybe Disconnected
> The above implementation takes a source as an input and prints only those vertices that are reachable from the source and 
> would not print all vertices in case of disconnected graph. Let us now talk about the algorithm that prints all vertices without any source and the graph maybe disconnected.

> [!IMPORTANT]
> The idea is simple, instead of calling BFS for a single vertex, we call the above implemented BFS for all all non-visited vertices one by one.

### CODE :

    import java.util.*;
    
    public class GfG {
    
        // Perform BFS for the entire graph which maybe
        // disconnected
        public static void bfsDisconnected(List<List<Integer>> adj) {
            boolean[] visited = new boolean[adj.size()]; // Not visited
    
            for (int i = 0; i < adj.size(); i++) {
                if (!visited[i]) {
                    bfs(adj, i, visited);
                }
            }
        }
      
        // BFS from given source s
        public static void bfs(List<List<Integer>> adj,
                               int s, boolean[] visited) {
            Queue<Integer> q = new LinkedList<>(); 
    
            // Mark the source node as visited and enqueue it
            visited[s] = true;
            q.add(s);
    
            // Iterate over the queue
            while (!q.isEmpty()) {
                int curr = q.poll(); // Dequeue a vertex
                System.out.print(curr + " ");
    
                // Get all adjacent vertices of curr
                for (int x : adj.get(curr)) {
                    if (!visited[x]) {
                        visited[x] = true; // Mark as visited
                        q.add(x); // Enqueue it
                    }
                }
            }
        }
      
        // Function to add an edge to the graph
        public static void addEdge(List<List<Integer>> adj, 
                                        int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u); // Undirected graph
        }
    
        public static void main(String[] args) {
            int V = 6; // Number of vertices
            List<List<Integer>> adj = new ArrayList<>(V); 
    
            // Initialize adjacency lists
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
    
            // Add edges to the graph
            addEdge(adj, 0, 1);
            addEdge(adj, 0, 2);
            addEdge(adj, 3, 4);
            addEdge(adj, 4, 5);  
    
            // Perform BFS traversal for the entire graph
            bfsDisconnected(adj);
        }
    }

### Output
    0 1 2 3 4 5

## Complexity Analysis of Breadth-First Search (BFS) Algorithm:
* Time Complexity of BFS Algorithm: **O(V + E)**
BFS explores all the vertices and edges in the graph. In the worst case, it visits every vertex and edge once. Therefore, the time complexity of BFS is O(V + E), where V and E are the number of vertices and edges in the given graph.
    * Auxiliary Space of BFS Algorithm: **O(V)**
BFS uses a queue to keep track of the vertices that need to be visited. In the worst case, the queue can contain all the vertices in the graph. Therefore, the space complexity of BFS is O(V).

## Applications of BFS in Graphs:
BFS has various applications in graph theory and computer science, including:

## Problems on Breadth First Search or BFS for a Graph:
| S.no | Problems  | Practice  |
|------|----------- |-----------|
| 1.   |	Find the level of a given node in an Undirected Graph|	Link|
| 2.   |	Minimize maximum adjacent difference in a path from top-left to bottom-right|	Link|
| 3.   |	Minimum jump to the same value or adjacent to reach the end of an Array	|Link|
| 4.   |	Maximum coin in minimum time by skipping K obstacles along the path in Matrix|	Link|
| 5.   |	Check if all nodes of the Undirected Graph can be visited from the given Node|	Link|
| 6.   |	Minimum time to visit all nodes of a given Graph at least once	Link|
| 7.   |	Minimize moves to the next greater element to reach the end of the Array|	Link|
| 8.   |	Shortest path by removing K walls|	Link|
| 9.   |	Minimum time required to infect all the nodes of the Binary tree|	Link|
| 10.  |	Check if destination of given Matrix is reachable with required values of cells|	Link|

