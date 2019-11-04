package medium;

/*
    Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)

    A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.

    Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.
 */
public class NumberOfEnclaves {

    private boolean[][] t;

    public static void main(String... args) {

        int[][] A = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        NumberOfEnclaves numberOfEnclaves = new NumberOfEnclaves();
        System.out.println(numberOfEnclaves.numEnclaves(A));
    }

    private void dfs(int x, int y, int m, int n) {

        if (x < 0 || x == m || y < 0 || y == n || t[x][y]) return;
        t[x][y] = true;
        dfs(x-1, y, m, n);
        dfs(x+1, y, m, n);
        dfs(x, y-1, m, n);
        dfs(x, y+1, m, n);
    }

    public int numEnclaves(int[][] A) {

        int count = 0;
        int m = A.length;
        int n = A[0].length;
        t = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                t[i][j] = A[i][j] == 0;

        for (int i = 0; i < m; i++) {

            if (A[i][0] == 1) dfs(i, 0, m, n);
            if (A[i][n-1] == 1) dfs(i, n-1, m, n);
        }

        for (int i = 0; i < n; i++) {

            if (A[0][i] == 1) dfs(0, i, m, n);
            if (A[m-1][i] == 1) dfs(m-1, i, m, n);
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!t[i][j]) count++;

        return count;
    }

}
