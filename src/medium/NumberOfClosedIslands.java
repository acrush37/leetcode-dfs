package medium;

/*
    Given a 2D grid consists of 0s (land) and 1s (water).
    An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally
    (all left, top, right, bottom) surrounded by 1s.

    Return the number of closed islands.
 */
public class NumberOfClosedIslands {

    private boolean flag;

    private int[] a = {-1, 1, 0, 0};

    private int[] b = {0, 0, -1, 1};

    public static void main(String... args) {

        int[][] grid = {{0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}};
        NumberOfClosedIslands numberOfClosedIslands = new NumberOfClosedIslands();
        System.out.println(numberOfClosedIslands.closedIsland(grid));
    }

    private void dfs(int x, int y, int m, int n, boolean[][] t, int[][] grid) {

        t[x][y] = true;

        if (flag)
            for (int i = 0; i < 4; i++) {

                int u = x + a[i];
                int v = y + b[i];

                if (u == -1 || u == m || v == -1 || v == n) {
                    flag = false;
                    break;
                }
            }

        for (int i = 0; i < 4; i++) {

            int u = x + a[i];
            int v = y + b[i];
            if (u < 0 || u >= m || v < 0 || v >= n || t[u][v] || grid[u][v] == 1) continue;
            dfs(u, v, m, n, t, grid);
        }
    }

    public int closedIsland(int[][] grid) {

        int result = 0, m = grid.length, n = grid[0].length;
        boolean[][] t = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!t[i][j] && grid[i][j] == 0) {

                    flag = true;
                    dfs(i, j, m, n, t, grid);
                    if (flag) result++;
                }

        return result;
    }

}
