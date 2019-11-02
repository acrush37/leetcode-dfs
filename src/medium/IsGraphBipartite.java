package medium;

/*
    Given an undirected graph, return true if and only if it is bipartite.

    Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets
    A and B such that every edge in the graph has one node in A and another node in B.

    The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.
    Each node is an integer between 0 and graph.length - 1.
    There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 */
public class IsGraphBipartite {

    private boolean[][] t;
    private boolean[] f;

    public static void main(String... args) {

        int[][] graph = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        IsGraphBipartite isGraphBipartite = new IsGraphBipartite();
        System.out.println(isGraphBipartite.isBipartite(graph));
    }

    private void dfs(int n, int k, int[][] graph) {

        if (f[n]) return;

        if (t[n][1-k]) {
            t[n][k] = true;
            return;
        }

        t[n][k] = true;
        f[n] = true;
        for (int x : graph[n]) dfs(x, 1-k, graph);
    }

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        f = new boolean[n];
        t = new boolean[n][2];

        for (int i = 0; i < n; i++) {

            dfs(i, 0, graph);
            if (t[i][0] && t[i][1]) return false;

            for (int j : graph[i])
                if (t[i][0] && t[j][0] || t[i][1] && t[j][1])
                    return false;
        }

        return true;
    }

}
