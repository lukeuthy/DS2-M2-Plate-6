import java.util.*;

public class PlateSixProblemFive {
    private static final List<List<Integer>> adj = new ArrayList<>();
    private static int[] color;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("____________________________________________________");
        System.out.println("Bipartite Graph Checker\nby Jasper Nikko M. NAVAREZ");
        System.out.println("____________________________________________________");
        System.out.print("Enter the number of vertices in the graph: ");
        int numVertices = scanner.nextInt();

        for (int i = 0; i < numVertices; i++) adj.add(new ArrayList<>());

        System.out.println("Enter the edges of the graph as pairs of vertices (e.g., '0 1'). Enter '-1 -1' to stop:");
        while (true) {
            int u = scanner.nextInt(), v = scanner.nextInt();
            if (u == -1 && v == -1) break;
            if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
                adj.get(u).add(v);
                adj.get(v).add(u);
            } else {
                System.out.println("Invalid vertex number. Please enter vertices between 0 and " + (numVertices - 1));
            }
        }

        scanner.close();
        color = new int[numVertices];
        Arrays.fill(color, -1);

        System.out.println(isBipartite(numVertices) ? "The graph is bipartite." : "The graph is not bipartite.");
    }

    private static boolean dfs(int u, int c) {
        color[u] = c;
        for (int v : adj.get(u)) {
            if (color[v] == -1) {
                if (!dfs(v, 1 - c)) return false;
            } else if (color[v] == c) return false;
        }
        return true;
    }

    private static boolean isBipartite(int numVertices) {
        for (int i = 0; i < numVertices; i++) {
            if (color[i] == -1 && !dfs(i, 0)) return false;
        }
        return true;
    }
}
