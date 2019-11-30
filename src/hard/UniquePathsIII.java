package hard;

/*
    On a 2-dimensional grid, there are 4 types of squares:

    1 represents the starting square.  There is exactly one starting square.
    2 represents the ending square.  There is exactly one ending square.
    0 represents empty squares we can walk over.
    -1 represents obstacles that we cannot walk over.

    Return the number of 4-directional walks from the starting square to the
    ending square, that walk over every non-obstacle square exactly once.
 */
public class UniquePathsIII {

    private int result;

    private int[] a = {-1, 1, 0, 0};

    private int[] b = {0, 0, 1, -1};

    public static void main(String... args) {

        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
        UniquePathsIII uniquePathsIII = new UniquePathsIII();
        System.out.println(uniquePathsIII.uniquePathsIII(grid));
    }

    private void dfs(int s, int x, int y, int m, int n, int[][] grid, boolean[][] t) {

        if (s == 0) {
            if (grid[x][y] == 2) result++;
            return;
        }

        for (int i = 0; i <= 3; i++) {

            int u = x + a[i];
            int v = y + b[i];
            if (u < 0 || v < 0 || u >= m || v >= n || !t[u][v]) continue;
            t[u][v] = false;
            dfs(s-1, u, v, m, n, grid, t);
            t[u][v] = true;
        }
    }

    public int uniquePathsIII(int[][] grid) {

        int x = 0;
        int y = 0;
        int s = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] t = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0 || grid[i][j] == 2) {
                    s++;
                    t[i][j] = true;
                } else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }

        dfs(s, x, y, m, n, grid, t);
        return result;
    }

}
