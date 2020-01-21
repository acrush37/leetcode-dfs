package hard;

import java.util.*;

/*
    There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections
    forming a network where connections[i] = [a, b] represents a connection between servers a and b.

    Any server can reach any other server directly or indirectly through the network.
    A critical connection is a connection that, if removed, will make some server unable to reach some other server.

    Return all critical connections in the network in any order.
 */
public class CriticalConnectionsInNetwork {

    private Integer[] f;

    private List<Integer>[] e;

    private List<List<Integer>> result  = new ArrayList<>();

    public static void main(String... args) {

        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        CriticalConnectionsInNetwork criticalConnectionsInNetwork = new CriticalConnectionsInNetwork();
        System.out.println(criticalConnectionsInNetwork.criticalConnections(4, connections));
    }

    private int dfs(int k, int x, int p) {

        if (f[x] != null) return f[x];
        int min = f[x] = k++;

        for (int y : e[x]) {
            if (y != p) {
                int z = dfs(k, y, x);
                if (z > f[x]) result.add(Arrays.asList(x,y));
                min = Math.min(z, min);
            }
        }

        return f[x] = min;
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        if (connections.size() == n-1) return connections;

        e = new List[n];
        f = new Integer[n];
        for (int i = 0; i < n; i++) e[i] = new ArrayList<>();

        for (List<Integer> c : connections) {

            int x = c.get(0);
            int y = c.get(1);
            e[x].add(y);
            e[y].add(x);
        }

        dfs(0, 0, -1);
        return result;
    }

}
