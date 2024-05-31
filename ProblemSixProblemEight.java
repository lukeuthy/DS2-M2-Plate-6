import java.util.*;
 
public class ProblemSixProblemEight {
    private static int[][] adj1, adj2;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("____________________________________________________");
        System.out.println("Isomorphism Checker\nby Jasper Nikko M. NAVAREZ");
        System.out.println("____________________________________________________");
        
        // Get the number of vertices
        System.out.print("Enter the number of vertices in the graphs: ");
        n = scanner.nextInt();

        // Initialize adjacency matrices for the two graphs
        adj1 = new int[n][n];
        adj2 = new int[n][n];

        // Get the edges of the first graph
        System.out.println("Enter the edges of the 1st graph as pairs of vertices, e.g. '0 1'. (Enter '-1 -1' to stop): ");
        readEdges(adj1, scanner);

        // Get the edges of the second graph
        System.out.println("Enter the edges of the 2nd graph as pairs of vertices, e.g. '0 1'. (Enter '-1 -1' to stop): ");
        readEdges(adj2, scanner);

        scanner.close();

        // Check if the graphs are isomorphic
        System.out.println(isIsomorphic() ? "The graphs are isomorphic." : "The graphs are not isomorphic.");
    }

    private static void readEdges(int[][] adj, Scanner scanner) {
        int u, v;
        while ((u = scanner.nextInt()) != -1 && (v = scanner.nextInt()) != -1) {
            if (isValidVertex(u) && isValidVertex(v)) {
                adj[u][v]++;
                adj[v][u]++;
            } else {
                System.out.println("Invalid vertex number. Vertex numbers must be between 0 and " + (n - 1) + ".");
            }
        }
    }

    private static boolean isValidVertex(int vertex) {
        return vertex >= 0 && vertex < n;
    }

    private static boolean isIsomorphic() {
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) permutation[i] = i;
        return checkIsomorphism(permutation, 0);
    }

    private static boolean checkIsomorphism(int[] perm, int index) {
        if (index == n) return matchPermutation(perm);
        for (int i = index; i < n; i++) {
            swap(perm, index, i);
            if (checkIsomorphism(perm, index + 1)) return true;
            swap(perm, index, i);
        }
        return false;
    }

    private static boolean matchPermutation(int[] perm) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adj1[i][j] != adj2[perm[i]][perm[j]]) return false;
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
