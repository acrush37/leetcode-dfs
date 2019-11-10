package hard;

/*
    The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

    Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 */
public class NQueensII {

    private int result;

    public static void main(String... args) {

        NQueensII nQueensII = new NQueensII();
        System.out.println(nQueensII.totalNQueens(13));
    }

    private void dfs(int k, int n, int[][] t) {

        if (k == n) {

            result++;
            return;
        }

        for (int i = 0; i < n; i++)
            if (t[k][i] == 0) {

                if (k == n-1) {

                    t[k][i]++;
                    dfs(n, n, t);
                    t[k][i]--;
                    continue;
                }

                int p = Math.min(n, n-i+k);
                int q = Math.min(n, i+k+1);
                int r = i-k;
                int s = i+k;
                for (int j = k; j < n; j++) t[j][i]++;
                for (int j = k+1; j < q; j++) t[j][s-j]++;
                for (int j = k+1; j < p; j++) t[j][r+j]++;
                dfs(k+1, n, t);
                for (int j = k; j < n; j++) t[j][i]--;
                for (int j = k+1; j < q; j++) t[j][s-j]--;
                for (int j = k+1; j < p; j++) t[j][r+j]--;
            }
    }

    public int totalNQueens(int n) {

        if (n <= 1) return 1;

        for (int i = 0; i < n >> 1; i++) {

            int[][] t = new int[n][n];
            for (int j = 0; j < n; j++) t[j][i]++;
            for (int j = 1; j <= i; j++) t[j][i-j]++;
            for (int j = 1; j < n-i; j++) t[j][i+j]++;
            dfs(1, n, t);
        }

        result <<= 1;

        if ((n & 1) == 1) {

            int i = n >> 1;
            int[][] t = new int[n][n];
            for (int j = 0; j < n; j++) t[j][i]++;
            for (int j = 1; j <= i; j++) t[j][i-j]++;
            for (int j = 1; j < n-i; j++) t[j][i+j]++;
            dfs(1, n, t);
        }

        return result;
    }

}
