package medium;

import java.util.HashSet;
import java.util.Set;

/*
    Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

    Each person may dislike some other people, and they should not go into the same group.

    Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

    Return true if and only if it is possible to split everyone into two groups in this way.
 */
public class PossibleBipartition {

    private Boolean[] t;
    private Set<Integer>[] f;

    public static void main(String... args) {

        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};
        PossibleBipartition possibleBipartition = new PossibleBipartition();
        System.out.println(possibleBipartition.possibleBipartition(3, dislikes));
    }

    private boolean dfs(int i, boolean flag) {

        t[i] = flag;

        for (int j : f[i])
            if (t[j] != null) {
                if (t[j] == t[i]) return false;
            } else if (!dfs(j, t[j] = !flag)) return false;

        return true;
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {

        f = new Set[N+1];
        t = new Boolean[N+1];

        for (int i = 1; i <= N; i++) f[i] = new HashSet<>();

        for (int[] d : dislikes) {

            f[d[0]].add(d[1]);
            f[d[1]].add(d[0]);
        }

        for (int i = 1; i <= N; i++)
            if (t[i] == null && !dfs(i, true))
                return false;

        return true;
    }

}
