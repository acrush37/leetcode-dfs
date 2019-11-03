package medium;

/*
    Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
    You may assume all four edges of the grid are surrounded by water.

    Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 */
public class MaxAreaOfIsland {

    private int s;
    private int max;
    private boolean[][] t;
    private int[] a = {-1, 1, 0, 0};
    private int[] b = {0, 0, 1, -1};

    public static void main(String... args) {

        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(grid));
    }

    private void dfs(int x, int y, int m, int n) {

        if (x < 0 || x >= m || y < 0 || y >= n || t[x][y]) return;
        t[x][y] = true;
        s++;
        dfs(x-1, y, m, n);
        dfs(x+1, y, m, n);
        dfs(x, y-1, m, n);
        dfs(x, y+1, m, n);
    }

    public int maxAreaOfIsland(int[][] grid) {

        max = 0;
        int m = grid.length;
        int n = grid[0].length;
        t = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0)
                    t[i][j] = true;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1) {

                    s = 0;
                    dfs(i, j, m, n);
                    max = Math.max(max, s);
                }

        return max;
    }

}
