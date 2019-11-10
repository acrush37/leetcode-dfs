package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

    Given an integer n, return all distinct solutions to the n-queens puzzle.

    Each solution contains a distinct board configuration of the n-queens' placement,
    where 'Q' and '.' both indicate a queen and an empty space respectively.
 */
public class NQueens {

    private List<List<String>> result = new ArrayList<>();

    public static void main(String... args) {

        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }

    private void dfs(int k, int n, int[][] t, char[][] f) {

        if (k == n) {

            List<String> list = new ArrayList<>();

            for (char[] c : f) {

                String s = "";
                for (char ch : c) s += ch == 'Q' ? 'Q' : '.';
                list.add(s);
            }

            result.add(list);
            return;
        }

        for (int i = 0; i < n; i++)
            if (t[k][i] == 0) {

                if (k == n-1) {

                    f[k][i] = 'Q';
                    t[k][i]++;
                    dfs(n, n, t, f);
                    f[k][i] = '.';
                    t[k][i]--;
                    continue;
                }

                int r = i-k;
                int s = i+k;
                int p = Math.min(n, n-i+k);
                int q = Math.min(n, i+k+1);
                for (int j = k; j < n; j++) t[j][i]++;
                for (int j = k+1; j < q; j++) t[j][s-j]++;
                for (int j = k+1; j < p; j++) t[j][r+j]++;
                f[k][i] = 'Q';
                dfs(k+1, n, t, f);
                f[k][i] = '.';
                for (int j = k; j < n; j++) t[j][i]--;
                for (int j = k+1; j < q; j++) t[j][s-j]--;
                for (int j = k+1; j < p; j++) t[j][r+j]--;
            }
    }

    public List<List<String>> solveNQueens(int n) {

        if (n == 0) return Arrays.asList(Arrays.asList());
        if (n == 1) return Arrays.asList(Arrays.asList("Q"));

        for (int i = 0; i < n >> 1; i++) {

            int[][] t = new int[n][n];
            char[][] f = new char[n][n];
            f[0][i] = 'Q';
            for (int j = 0; j < n; j++) t[j][i]++;
            for (int j = 1; j <= i; j++) t[j][i-j]++;
            for (int j = 1; j < n-i; j++) t[j][i+j]++;
            dfs(1, n, t, f);
        }

        int m = result.size();

        for (int i = 0; i < m; i++)
            result.add(result.get(i).stream()
                    .map(j -> new StringBuilder(j).reverse().toString())
                    .collect(Collectors.toList()));

        if ((n & 1) == 1) {

            int i = n >> 1;
            int[][] t = new int[n][n];
            char[][] f = new char[n][n];
            f[0][i] = 'Q';
            for (int j = 0; j < n; j++) t[j][i]++;
            for (int j = 1; j <= i; j++) t[j][i-j]++;
            for (int j = 1; j < n-i; j++) t[j][i+j]++;
            dfs(1, n, t, f);
        }

        return result;
    }
}
