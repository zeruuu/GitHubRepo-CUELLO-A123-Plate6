import java.util.Scanner;

// Problem 4
// Write a java program, given the pair of vertex associated
// to the edges of an undirected graph, it will output the
// degree of vertex
public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        // Array to store the degree of each vertex
        int[] degree = new int[vertices];

        System.out.println("Enter the edges (pair of vertices):");
        for (int i = 0; i < edges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();

            // Increment the degree for both vertices involved in the edge
            degree[vertex1]++;
            degree[vertex2]++;
        }
        System.out.println("Degree of each vertex:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": " + degree[i]);
        }
        scanner.close();
    }
}
