package medium;

/*
    In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

    Return the maximum amount of gold you can collect under the conditions:

    Every time you are located in a cell you will collect all the gold in that cell.
    From your position you can walk one step to the left, right, up or down.
    You can't visit the same cell more than once.
    Never visit a cell with 0 gold.
    You can start and stop collecting gold from any position in the grid that has some gold.
 */
public class PathWithMaximumGold {

    private int max = 0;
    private int[] a = {-1, 1, 0, 0};
    private int[] b = {0, 0, -1, 1};

    public static void main(String... args) {

        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        PathWithMaximumGold pathWithMaximumGold = new PathWithMaximumGold();
        System.out.println(pathWithMaximumGold.getMaximumGold(grid));
    }

    private void dfs(int x, int y, int m, int n, int[][] grid, boolean[][] t, int s) {

        max = Math.max(max, s);

        for (int i = 0; i < 4; i++) {

            int u = x + a[i];
            int v = y + b[i];

            if (u >= 0 && v >= 0 && u < m && v < n && !t[u][v] && grid[u][v] != 0) {

                t[u][v] = true;
                dfs(u, v, m, n, grid, t, s + grid[u][v]);
                t[u][v] = false;
            }
        }
    }

    public int getMaximumGold(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] != 0) {

                    boolean[][] t = new boolean[m][n];
                    t[i][j] = true;
                    dfs(i, j, m, n, grid, t, grid[i][j]);
                }

        return max;
    }

}
