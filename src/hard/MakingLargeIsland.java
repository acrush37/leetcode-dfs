package hard;

/*
    In a 2D grid of 0s and 1s, we change at most one 0 to a 1.

    After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).
 */
public class MakingLargeIsland {

    private int count, result;

    private int[] a = {-1, 1, 0, 0};

    private int[] b = {0, 0, -1, 1};

    public static void main(String... args) {

        int[][] grid = {{1, 1}, {1, 0}};
        MakingLargeIsland makingLargeIsland = new MakingLargeIsland();
        System.out.println(makingLargeIsland.largestIsland(grid));
    }

    private void dfs(int x, int y, int m, int n, boolean[][] t, int[][] grid) {

        count++;
        t[x][y] = true;

        for (int i = 0; i < 4; i++) {

            int u = x + a[i];
            int v = y + b[i];
            if (u < 0 || u >= m || v < 0 || v >= n || t[u][v] || grid[u][v] == 0) continue;
            dfs(u, v, m, n, t, grid);
        }
    }

    public int largestIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] t = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!t[i][j]) {
                    count = 0;
                    dfs(i, j, m, n, t, grid);
                    result = Math.max(result, count);
                }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0) {

                    boolean flag = false;

                    for (int k = 0; k < 4; k++) {

                        int x = i + a[k];
                        int y = j + b[k];

                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                            flag = true;
                            break;
                        }
                    }

                    if (flag) {

                        grid[i][j] = 1;
                        count = 0;
                        dfs(i, j, m, n, new boolean[m][n], grid);
                        result = Math.max(result, count);
                        grid[i][j] = 0;
                    }
                }

        return result;
    }

}
