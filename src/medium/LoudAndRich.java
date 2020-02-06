package medium;

import java.util.HashSet;
import java.util.Set;

/*
    In a group of N people (labelled 0, 1, 2, ..., N-1), each person has different amounts of money, and different levels of quietness.
    For convenience, we'll call the person with label x, simply "person x".

    We'll say that richer[i] = [x, y] if person x definitely has more money than person y.
    Note that richer may only be a subset of valid observations.
    Also, we'll say quiet[x] = q if person x has quietness q.

    Now, return answer, where answer[x] = y if y is the least quiet person (that is, the person y with the
    smallest value of quiet[y]), among all people who definitely have equal to or more money than person x.
 */
public class LoudAndRich {

    public static void main(String... args) {

        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        LoudAndRich loudAndRich = new LoudAndRich();
        System.out.println(loudAndRich.loudAndRich(richer, quiet));
    }

    private void dfs(int x, int n, Set<Integer>[] s, Boolean[][] t, boolean[] f) {

        for (int y : s[x]) {

            t[n][y] = true;
            t[y][n] = false;

            if (!f[y]) {
                f[y] = true;
                dfs(y, n, s, t, f);
            }
        }
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {

        int n = quiet.length;
        int[] result = new int[n];
        Set<Integer>[] s = new Set[n];
        Boolean[][] t = new Boolean[n][n];
        for (int i = 0; i < n; i++) s[i] = new HashSet<>();
        for (int[] x : richer) s[x[1]].add(x[0]);
        for (int i = 0; i < n; i++) dfs(i, i, s, t, new boolean[n]);

        for (int i = 0; i < n; i++) {

            int max = quiet[result[i] = i];

            for (int j = 0; j < n; j++)
                if (t[i][j] == Boolean.TRUE && quiet[j] < max) {
                    max = quiet[j];
                    result[i] = j;
                }
        }

        return result;
    }

}
