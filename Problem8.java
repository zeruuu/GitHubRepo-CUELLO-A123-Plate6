import java.util.Scanner;

// Problem 8
// Write a Java program that checks whether two graphs are isomorphic or not, given a set of vertices.

public class Problem8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graphs: ");
        int n = scanner.nextInt();

        int[][] graph1 = new int[n][n];
        int[][] graph2 = new int[n][n];

        System.out.println("Enter the adjacency matrix for the first graph:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the adjacency matrix for the second graph:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph2[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        if (areIsomorphic(graph1, graph2)) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }
    }

    public static boolean areIsomorphic(int[][] graph1, int[][] graph2) {
        int n = graph1.length;
        if (n != graph2.length) return false;

        int[] perm = new int[n];
        for (int i = 0; i < n; i++) perm[i] = i;

        return checkIsomorphism(graph1, graph2, perm, 0);
    }

    private static boolean checkIsomorphism(int[][] graph1, int[][] graph2, int[] perm, int index) {
        if (index == perm.length) {
            return isIsomorphicUnderPermutation(graph1, graph2, perm);
        }

        for (int i = index; i < perm.length; i++) {
            swap(perm, i, index);
            if (checkIsomorphism(graph1, graph2, perm, index + 1)) {
                return true;
            }
            swap(perm, i, index);
        }

        return false;
    }

    private static boolean isIsomorphicUnderPermutation(int[][] graph1, int[][] graph2, int[] perm) {
        int n = graph1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph1[i][j] != graph2[perm[i]][perm[j]]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
