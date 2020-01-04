package hard;

import java.util.ArrayList;
import java.util.List;

/*
    Given a 2D board and a list of words from the dictionary, find all words in the board.

    Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are
    those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 */
public class WordSearchII {

    private int[] a = {-1, 1, 0, 0};

    private int[] b = {0, 0, -1, 1};

    public static void main(String... args) {

        String[] words = {"aaa"};
        char[][] board = {{'a','a'}};
        WordSearchII wordSearchII = new WordSearchII();
        System.out.println(wordSearchII.findWords(board, words));
    }

    private boolean dfs(int k, int x, int y, int m, int n, char[] c, char[][] f, boolean[][] t) {

        if (k == -1) return true;

        for (int i = 0; i < 4; i++) {

            int u = x + a[i];
            int v = y + b[i];
            if (u < 0 || v < 0 || u >= m || v >= n || t[u][v] || f[u][v] != c[k]) continue;
            t[u][v] = true;
            if (dfs(k-1, u, v, m, n, c, f, t)) return true;
            t[u][v] = false;
        }

        return false;
    }

    private boolean check(int m, int n, char[][] f, char[] c) {

        int p = c.length - 1;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (f[i][j] == c[p]) {

                    boolean[][] t = new boolean[m][n];
                    t[i][j] = true;
                    if (dfs(p-1, i, j, m, n, c, f, t)) return true;
                }

        return false;
    }

    public List<String> findWords(char[][] board, String[] words) {

        int m = board.length;
        List<String> result = new ArrayList<>();
        if (m == 0) return result;
        int n = board[0].length;

        for (String word : words)
            if (check(m, n, board, word.toCharArray()))
                result.add(word);

        return result;
    }

}
