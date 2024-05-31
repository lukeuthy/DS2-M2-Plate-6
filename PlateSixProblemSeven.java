import java.util.*;

public class PlateSixProblemSeven {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("____________________________________________________");
        System.out.println("Incidence Matrix Maker\nby Jasper Nikko M. NAVAREZ");
        System.out.println("____________________________________________________");

        System.out.print("Enter the number of vertices in the graph: ");
        int numVertices = scanner.nextInt();

        System.out.print("Enter the number of edges in the graph: ");
        int numEdges = scanner.nextInt();

        int[][] incidenceMatrix = new int[numVertices][numEdges];

        System.out.println("Enter the edges of the graph as pairs of vertices followed by the number of times each edge appears (e.g., '0 1 2').");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt(), v = scanner.nextInt(), count = scanner.nextInt();
            for (int j = 0; j < count; j++) {
                incidenceMatrix[u][i + j] = 1;
                incidenceMatrix[v][i + j] = 1;
            }
            i += count - 1;
        }

        scanner.close();

        System.out.println("Incidence matrix:");
        for (int[] row : incidenceMatrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
