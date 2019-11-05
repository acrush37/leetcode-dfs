package medium;

/*
    There are N network nodes, labelled 1 to N.

    Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node,
    v is the target node, and w is the time it takes for a signal to travel from source to target.

    Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal?
    If it is impossible, return -1.
 */
public class NetworkDelayTime {

    public static void main(String... args) {

        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        System.out.println(networkDelayTime.networkDelayTime(times, 4, 2));
    }

    public int networkDelayTime(int[][] times, int N, int K) {

        int max = 600001;
        int[][] f = new int[N+1][N+1];

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                if (i != j) f[i][j] = max;

        for (int[] t : times) f[t[0]][t[1]] = t[2];

        for (int k = 1; k <= N; k++)
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    if (i != j && i != k && f[i][k] != max && f[k][j] != max)
                        f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j]);

        int result = 0;

        for (int i = 1; i <= N; i++)
            if (f[K][i] == max) return -1;
            else result = Math.max(result, f[K][i]);

        return result;
    }

}
