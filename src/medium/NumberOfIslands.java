package medium;

/*
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

    private boolean[][] t;

    public static void main(String... args) {

        char[][] grid = {{'1','1','0','0','0'},
                         {'1','1','0','0','0'},
                         {'0','0','1','0','0'},
                         {'0','0','0','1','1'}};
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(grid));
    }

    private void dfs(int x, int y, int m, int n) {

        if (x < 0 || x >= m || y < 0 || y >= n || t[x][y]) return;
        t[x][y] = true;
        dfs(x-1, y, m, n);
        dfs(x+1, y, m, n);
        dfs(x, y-1, m, n);
        dfs(x, y+1, m, n);
    }

    public int numIslands(char[][] grid) {

        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        t = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == '0')
                    t[i][j] = true;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!t[i][j]) {

                    dfs(i, j, m, n);
                    count++;
                }

        return count;
    }

}
