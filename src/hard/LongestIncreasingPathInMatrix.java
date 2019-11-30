package hard;

/*
    Given an integer matrix, find the length of the longest increasing path.

    From each cell, you can either move to four directions: left, right, up or down.

    You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 */
public class LongestIncreasingPathInMatrix {

    private int[][] f;

    private int[] a = {-1, 1, 0, 0};

    private int[] b = {0, 0, 1, -1};

    public static void main(String... args) {

        int[][] matrix = {{7, 8, 9}, {9, 7, 6}, {7, 2, 3}};
        LongestIncreasingPathInMatrix longestIncreasingPathInMatrix = new LongestIncreasingPathInMatrix();
        System.out.println(longestIncreasingPathInMatrix.longestIncreasingPath(matrix));
    }

    private void dfs(int x, int y, int m, int n, int[][] matrix) {

        f[x][y] = 1;

        for (int i = 0; i <= 3; i++) {

            int u = x + a[i];
            int v = y + b[i];
            if (u < 0 || v < 0 || u >= m || v >= n) continue;

            if (matrix[u][v] < matrix[x][y]) {
                if (f[u][v] == 0) dfs(u, v, m, n, matrix);
                f[x][y] = Math.max(f[x][y], 1 + f[u][v]);
            }
        }
    }

    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        if (m == 0) return 0;
        int result = 0;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                f = new int[m][n];
                dfs(i, j, m, n, matrix);
                result = Math.max(result, f[i][j]);
            }

        return result;
    }

}
