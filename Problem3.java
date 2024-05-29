import java.util.*;

// Problem 3
// Write a java program that will determine if a graph has a cycle or not.
public class Problem3 {

    private int vertices;
    private List<List<Integer>> adjacencyList;

    public Problem3(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u); // Because the graph is undirected
    }

    private boolean hasCycleUtil(int v, boolean[] visited, int parent) {
        visited[v] = true;
        for (int neighbor : adjacencyList.get(v)) {
            if (!visited[neighbor]) {
                if (hasCycleUtil(neighbor, visited, v)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];
        for (int v = 0; v < vertices; v++) {
            if (!visited[v]) {
                if (hasCycleUtil(v, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();

        Problem3 graph = new Problem3(vertices);

        System.out.println("Enter the adjacency matrix:");
        int[][] adjacencyMatrix = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < vertices; i++) {
            for (int j = i; j < vertices; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    graph.addEdge(i, j);
                }
            }
        }

        if (graph.hasCycle()) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph does not have a cycle.");
        }

        scanner.close();
    }
}
