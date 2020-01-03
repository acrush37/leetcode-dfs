package hard;

import java.util.ArrayList;
import java.util.List;

/*
    Write a program to solve a Sudoku puzzle by filling the empty cells.

    A sudoku solution must satisfy all of the following rules:

    Each of the digits 1-9 must occur exactly once in each row.
    Each of the digits 1-9 must occur exactly once in each column.
    Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
    Empty cells are indicated by the character '.'.
 */
public class SudokuSolver {

    private int[][] result;

    public static void main(String... args) {

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudoku(board);
        for (char[] c : board) System.out.println(String.valueOf(c));
    }

    private void dfs(int k, List<int[]> f, boolean[][][] t, int[][] a) {

        if (k == -1) {

            result = new int[9][9];
            for (int[] x : f) result[x[0]][x[1]] = a[x[0]][x[1]];
            return;
        }

        int[] x = f.get(k);

        for (int i = 1; i <= 9; i++)
            if (!t[x[0]][i][0] && !t[x[1]][i][1]) {

                int y = x[0]/3*3 + x[1]/3;

                if (!t[y][i][2]) {

                    a[x[0]][x[1]] = i;
                    t[x[0]][i][0] = t[x[1]][i][1] = t[y][i][2] = true;
                    dfs(k-1, f, t, a);
                    if (result != null) return;
                    t[x[0]][i][0] = t[x[1]][i][1] = t[y][i][2] = false;
                }
            }
    }

    public void solveSudoku(char[][] board) {

        List<int[]> f = new ArrayList<>();
        boolean[][][] t = new boolean[9][10][3];

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] == '.') f.add(new int[]{i, j});
                else {
                    int k = board[i][j] - 48;
                    t[i][k][0] = t[j][k][1] = t[i/3*3+j/3][k][2] = true;
                }

        dfs(f.size()-1, f, t, new int[9][9]);
        for (int[] x : f) board[x[0]][x[1]] = (char) (result[x[0]][x[1]] + 48);
    }

}
