import java.util.*;

public class PlateSixProblemThree {

    private static List<List<Integer>> adjList = new ArrayList<>();
    private static boolean hasCycle = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("____________________________________________________");
        System.out.println("Graph Cycle Checker\nby Jasper Nikko M. NAVAREZ");
        System.out.println("____________________________________________________");
        System.out.print("Enter the number of vertices in the graph: ");
        int numVertices = scanner.nextInt();
        
        for (int i = 0; i < numVertices; i++) adjList.add(new ArrayList<>());
        
        System.out.println("Enter edges (e.g., '0 1'). Enter '-1 -1' to stop:");
        while (true) {
            int u = scanner.nextInt(), v = scanner.nextInt();
            if (u == -1 && v == -1) break;
            if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            } else {
                System.out.println("Invalid vertices. Please enter vertices between 0 and " + (numVertices - 1));
            }
        }

        System.out.println(hasCycle(numVertices) ? "The graph contains a cycle." : "The graph does not contain a cycle.");
        scanner.close();
    }

    private static boolean hasCycle(int vertices) {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && dfs(i, -1, visited)) {
                hasCycle = true;
                break;
            }
        }
        return hasCycle;
    }

    private static boolean dfs(int v, int parent, boolean[] visited) {
        visited[v] = true;
        for (int neighbor : adjList.get(v)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, v, visited)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
}
