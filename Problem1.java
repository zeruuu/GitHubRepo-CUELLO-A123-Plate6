import java.util.*;

// Problem 1
// Write a java program that receives a list of edges of a simple graph,
// the program should determine whether it is connected
// and find the number of connected components if it is not connected.
public class Problem1 {

    private int vertices; // Number of vertices
    private List<List<Integer>> adjacencyList; // Adjacency list representation of the graph

    public Problem1(int vertices) {
        this.vertices = vertices; // Stores the number of vertices
        adjacencyList = new ArrayList<>(); // Initializes the adjacency list as an array of list
        for (int i = 0; i < vertices; i++) { // Adds an empty list for each vertex to the adjacency list
            adjacencyList.add(new ArrayList<>());
        }
    }
    // Add an edge to the undirected graph
    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    // Function to perform Depth-First Search (DFS) and mark visited nodes
    private void DFS(int v, boolean[] visited) {
        visited[v] = true; // Marks the current vertex as visited
        for (int neighbor : adjacencyList.get(v)) {
            if (!visited[neighbor]) {
                DFS(neighbor, visited);
            }
        }
    }

    // Function to check if the graph is connected
    public boolean isConnected() {
        boolean[] visited = new boolean[vertices];
        DFS(0, visited); // Start DFS from the first vertex
        for (boolean vertexVisited : visited) { // Check if all vertices are visited
            if (!vertexVisited) {
                return false;
            }
        }
        return true;
    }

    // Function to find the number of connected components
    public int numberOfConnectedComponents() {
        boolean[] visited = new boolean[vertices];
        int count = 0;

        for (int v = 0; v < vertices; v++) {
            if (!visited[v]) {
                DFS(v, visited);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices:");
        int vertices = scanner.nextInt();

        Problem1 graph = new Problem1(vertices);

        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        if (graph.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            int components = graph.numberOfConnectedComponents();
            System.out.println("The graph is not connected. It has " + components + " connected components.");
        }

        scanner.close();
    }
}
