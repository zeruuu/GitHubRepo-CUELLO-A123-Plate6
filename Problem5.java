import java.util.*;

// Problem 5
// Write a java program that receives a list of edges of a
// simple graph and determine whether the graph is bipartite.
public class Problem5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        List<List<Integer>> adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (pair of vertices):");
        for (int i = 0; i < edges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            adjacencyList.get(vertex1).add(vertex2);
            adjacencyList.get(vertex2).add(vertex1);
        }

        System.out.println("Adjacency List:");
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.println(i + ": " + adjacencyList.get(i));
        }

        if (isBipartite(adjacencyList, vertices)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }

        scanner.close();
    }
    private static boolean isBipartite(List<List<Integer>> adjacencyList, int vertices) {
        int[] colors = new int[vertices];
        Arrays.fill(colors, -1); // -1 means no color

        for (int i = 0; i < vertices; i++) {
            if (colors[i] == -1) {
                if (!bfsCheck(adjacencyList, i, colors)) {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean bfsCheck(List<List<Integer>> adjacencyList, int start, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 0; // Start coloring with 0

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adjacencyList.get(node)) {
                if (colors[neighbor] == -1) {
                    colors[neighbor] = 1 - colors[node]; // Alternate color
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[node]) {
                    return false; // If the neighbor has the same color, it's not bipartite
                }
            }
        }

        return true;
    }
}
