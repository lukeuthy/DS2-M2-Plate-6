import java.util.*;

public class PlateSixProblemSix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("____________________________________________________");
        System.out.println("Adjacency Matrix Maker\nby Jasper Nikko M. NAVAREZ");
        System.out.println("____________________________________________________");

        System.out.print("Enter the number of vertices in the graph: ");
        int numVertices = scanner.nextInt();

        int[][] adjMatrix = new int[numVertices][numVertices];

        System.out.print("Is the graph directed? (y/n): ");
        boolean isDirected = scanner.next().equalsIgnoreCase("y");

        System.out.println("Enter the edges of the graph as pairs of vertices (e.g., '0 1'). Enter '-1 -1' to stop:");
        while (true) {
            int u = scanner.nextInt(), v = scanner.nextInt();
            if (u == -1 && v == -1) break;
            if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
                adjMatrix[u][v]++;
                if (!isDirected && u != v) adjMatrix[v][u]++;
            } else {
                System.out.println("Invalid vertex number. Please enter vertices between 0 and " + (numVertices - 1));
            }
        }

        scanner.close();

        System.out.println("\nAdjacency Matrix:");
        for (int[] row : adjMatrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
