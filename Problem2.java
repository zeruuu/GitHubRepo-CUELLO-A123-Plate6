import java.util.Scanner;

// Problem 2
// Write a java program that accepts an adjacency matrix of a graph.
// The program should list the edges of this graph and give
// the number of times each edge appears.
public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        int[][] adjacencyMatrix = new int[vertices][vertices];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Edges of the graph and their occurrences:");
        for (int i = 0; i < vertices; i++) {
            for (int j = i; j < vertices; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    System.out.println(i + "-" + j + ": " + adjacencyMatrix[i][j]);
                }
            }
        }
        scanner.close();
    }
}
