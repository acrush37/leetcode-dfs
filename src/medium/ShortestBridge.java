package medium;

import java.util.ArrayList;
import java.util.List;

/*
    In a given 2D binary array A, there are two islands.
    (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

    Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

    Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 */
public class ShortestBridge {

    private boolean[][] t;

    public static void main(String... args) {

        int[][] A = {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        ShortestBridge shortestBridge = new ShortestBridge();
        System.out.println(shortestBridge.shortestBridge(A));
    }

    static class Pair {

        public int x, y;

        public Pair(int x, int y) {

            this.x = x;
            this.y = y;
        }
    }

    private void dfs(int x, int y, int n, int[][] A, List<Pair> list) {

        if (x < 0 || x >= n || y < 0 || y >= n || t[x][y] || A[x][y] == 0) return;
        t[x][y] = true;
        list.add(new Pair(x, y));
        dfs(x-1, y, n, A, list);
        dfs(x+1, y, n, A, list);
        dfs(x, y-1, n, A, list);
        dfs(x, y+1, n, A, list);
    }

    public int shortestBridge(int[][] A) {

        int n = A.length;
        t = new boolean[n][n];
        List<Pair> a = new ArrayList<>();
        List<Pair> b = new ArrayList<>();
        boolean flag = false;

        for (int i = 0; i < n; i++) {

            if (flag) break;

            for (int j = 0; j < n; j++)
                if (A[i][j] == 1 && !t[i][j] && !flag) {

                    dfs(i, j, n, A, a);
                    flag = true;
                    break;
                }
        }

        for (int i = 0; i < n; i++) {

            if (!flag) break;

            for (int j = 0; j < n; j++)
                if (A[i][j] == 1 && !t[i][j] && flag) {

                    dfs(i, j, n, A, b);
                    flag = false;
                    break;
                }
        }

        int min = 200;
        int x = a.size();
        int y = b.size();
        Pair[] c = new Pair[x];
        Pair[] d = new Pair[y];
        a.toArray(c);
        b.toArray(d);

        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                min = Math.min(min, Math.abs(c[i].x - d[j].x) + Math.abs(c[i].y - d[j].y));

        return min-1;
    }

}
