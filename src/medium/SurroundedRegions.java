package medium;

/*
    Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

    A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class SurroundedRegions {

    private char[][] f;

    private boolean flag;

    private int[] a = {-1, 1, 0, 0};

    private int[] b = {0, 0, -1, 1};

    public static void main(String... args) {

        char[][] board = {{'X','X','X','X'}, {'X','O','O','X'}, {'X','O','O','X'}, {'X','O','X','X'}};
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(board);
        for (char[] c : board) System.out.println(String.valueOf(c));
    }

    private void dfs(int x, int y, int m, int n, boolean[][] t, char[][] board) {

        f[x][y] = 'X';
        t[x][y] = true;

        if (flag)
            for (int i = 0; i < 4; i++) {

                int u = x + a[i];
                int v = y + b[i];

                if (u == -1 || u == m || v == -1 || v == n) {
                    flag = false;
                    break;
                }
            }

        for (int i = 0; i < 4; i++) {

            int u = x + a[i];
            int v = y + b[i];
            if (u < 0 || u >= m || v < 0 || v >= n || t[u][v] || board[u][v] == 'X') continue;
            dfs(u, v, m, n, t, board);
        }
    }

    private void update(int m, int n, char[][] x, char[][] y) {

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (x[i][j] != y[i][j])
                    x[i][j] = y[i][j];
    }

    public void solve(char[][] board) {

        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        f = new char[m][n];
        boolean[][] t = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                f[i][j] = board[i][j];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!t[i][j] && board[i][j] == 'O') {

                    flag = true;
                    dfs(i, j, m, n, t, board);

                    if (flag) update(m, n, board, f);
                    else update(m, n, f, board);
                }
    }

}
