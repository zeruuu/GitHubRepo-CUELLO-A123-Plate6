import java.util.Scanner;


// Problem 6
// Write a java program that receives the vertex pairs associated
// to the edges of a graph, the program should construct an
// adjacency matrix for the graph.
// (Produce a version that works when loops, multiple edges, or directed edges are present.)
public class Problem6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        // Create adjacency matrix
        int[][] adjacencyMatrix = new int[vertices][vertices];

        System.out.println("Enter the vertex pairs associated with the edges:");
        for (int i = 0; i < edges; i++) {
            System.out.print("Enter the vertex pair for edge " + (i + 1) + ": ");
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();

            // Update adjacency matrix
            adjacencyMatrix[vertex1][vertex2] = 1; // For undirected graph
            adjacencyMatrix[vertex2][vertex1] = 1; // For undirected graph
            // For directed graph:
            // adjacencyMatrix[vertex1][vertex2] = 1;
        }

        System.out.println("Adjacency Matrix:");
        printMatrix(adjacencyMatrix);

        scanner.close();
    }

    // Method to print a matrix
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
