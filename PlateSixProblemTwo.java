import java.util.*;

public class PlateSixProblemTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("____________________________________________________");
        System.out.println("Edge Counter\nby Jasper Nikko M. NAVAREZ");
        System.out.println("____________________________________________________");
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        char[] vertexNames = new char[vertices];
        for (int i = 0; i < vertices; i++) {
            vertexNames[i] = (char) ('a' + i);
        }

        int[][] adjMatrix = new int[vertices][vertices];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            String[] row = scanner.nextLine().split(" ");
            if (row.length != vertices) {
                System.out.println("Invalid Input. Please enter the matrix again with " + vertices + " columns.");
                i--; // Re-enter the current row
                continue;
            }
            for (int j = 0; j < vertices; j++) {
                adjMatrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        Map<String, Integer> edgeCount = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            for (int j = i; j < vertices; j++) { // Avoid counting duplicate edges
                if (adjMatrix[i][j] > 0) {
                    String edge = vertexNames[i] + "" + vertexNames[j];
                    edgeCount.put(edge, edgeCount.getOrDefault(edge, 0) + adjMatrix[i][j]);
                }
            }
        }

        System.out.println("Edges List and Number of Times Appears:");
        edgeCount.forEach((edge, times) -> System.out.println("Edge " + edge + ": " + times + " times"));

        scanner.close();
    }
}
