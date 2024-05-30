import java.util.Scanner;

// Problem 7
// Write a java program that accepts vertex pairs associated
// to the edges of an undirected graph and the number of times each edge appears.
// The program should construct an incidence matrix for the graph.
public class Problem7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        // Create incidence matrix
        int[][] incidenceMatrix = new int[vertices][edges];

        System.out.println("Enter the vertex pairs associated with the edges:");
        for (int i = 0; i < edges; i++) {
            System.out.print("Enter the vertex pair for edge " + (i + 1) + ": ");
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();

            // Update incidence matrix
            incidenceMatrix[vertex1][i] = 1;
            incidenceMatrix[vertex2][i] = 1;
        }

        System.out.println("Incidence Matrix:");
        printMatrix(incidenceMatrix);

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
