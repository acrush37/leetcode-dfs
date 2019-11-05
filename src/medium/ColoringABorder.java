package medium;

/*
    Given a 2-dimensional grid of integers, each value in the grid represents the color of the grid square at that location.

    Two squares belong to the same connected component if and only if they have the same color and are next to each other in any of the 4 directions.

    The border of a connected component is all the squares in the connected component that are either 4-directionally adjacent to a square not in the component,
    or on the boundary of the grid (the first or last row or column).

    Given a square at location (r0, c0) in the grid and a color, color the border of the connected component of that square with the given color, and return the final grid.
 */
public class ColoringABorder {

    private boolean[][] t;
    private boolean[][] f;

    public static void main(String... args) {

        int[][] grid = {{1,2,1,2,1,2}, {2,2,2,2,1,2}, {1,2,2,2,1,2}};
        ColoringABorder coloringABorder = new ColoringABorder();
        System.out.println(coloringABorder.colorBorder(grid, 1, 3, 1));
    }

    private void dfs(int x, int y, int m, int n, int old, int color, int[][] grid) {

        if (x < 0 || x >= m || y < 0 || y >= n || t[x][y] || grid[x][y] != old) return;
        t[x][y] = true;

        if (x == 0 || x == m-1 || y == 0 || y == n-1 || grid[x-1][y] != old
                || grid[x+1][y] != old || grid[x][y-1] != old || grid[x][y+1] != old)
            f[x][y] = true;

        dfs(x-1, y, m, n, old, color, grid);
        dfs(x+1, y, m, n, old, color, grid);
        dfs(x, y-1, m, n, old, color, grid);
        dfs(x, y+1, m, n, old, color, grid);
    }

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {

        if (color == grid[r0][c0]) return grid;
        int m = grid.length;
        int n = grid[0].length;
        t = new boolean[m][n];
        f = new boolean[m][n];
        dfs(r0, c0, m, n, grid[r0][c0], color, grid);

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (f[i][j]) grid[i][j] = color;

        return grid;
    }

}
