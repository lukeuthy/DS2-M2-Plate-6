import java.util.*;

public class PlateSixProblemFour {

    private static final List<List<Integer>> adjList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("____________________________________________________");
        System.out.println("Degrees of an Undirected Graph\nby Jasper Nikko M. NAVAREZ");
        System.out.println("____________________________________________________");
        System.out.print("Enter the number of vertices in the graph: ");
        int numVertices = scanner.nextInt();

        for (int i = 0; i < numVertices; i++) adjList.add(new ArrayList<>());

        System.out.println("Enter the edges of the graph as pairs of vertices (e.g., '0 1'). Enter '-1 -1' to stop:");
        while (true) {
            int u = scanner.nextInt(), v = scanner.nextInt();
            if (u == -1 && v == -1) break;
            if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            } else {
                System.out.println("Invalid vertex number. Please enter vertices between 0 and " + (numVertices - 1));
            }
        }

        int totalDegree = 0;
        for (int i = 0; i < numVertices; i++) {
            int degree = adjList.get(i).size();
            totalDegree += degree;
            System.out.println("deg(" + i + "): " + degree);
        }
        System.out.println("\nTotal Degree of Graph: " + totalDegree);
        scanner.close();
    }
}
