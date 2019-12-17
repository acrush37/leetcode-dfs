package medium;

import java.util.Arrays;
import java.util.List;

/*
    We are stacking blocks to form a pyramid. Each block has a color which is a one letter string.
    We are allowed to place any color block C on top of two adjacent blocks of colors A and B, if and only if ABC is an allowed triple.

    We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed.
    Each allowed triple is represented as a string of length 3.

    Return true if we can build the pyramid all the way to the top, otherwise false.
 */
public class PyramidTransitionMatrix {

    private boolean result;

    public static void main(String... args) {

        List<String> allowed = Arrays.asList("BCG", "CDE", "GEA", "FFF");
        PyramidTransitionMatrix pyramidTransitionMatrix = new PyramidTransitionMatrix();
        System.out.println(pyramidTransitionMatrix.pyramidTransition("BCD", allowed));
    }

    private void dfs(int k, int n, int[][] f, boolean[][][] t) {

        if (n == -1) {
            result = true;
            return;
        }

        if (k == n+1) {
            dfs(0, n-1, f, t);
            return;
        }

        for (int j = 1; j <= 7; j++)
            if (t[f[n+1][k]][f[n+1][k+1]][j]) {

                f[n][k] = j;
                dfs(k+1, n, f, t);
                if (result) return;
                f[n][k] = 0;
            }
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {

        int n = bottom.length();
        int[][] f = new int[n][n];
        boolean[][][] t = new boolean[8][8][8];
        for (int i = 0; i < n; i++) f[n-1][i] = bottom.charAt(i) - 64;
        for (String s : allowed) t[s.charAt(0)-64][s.charAt(1)-64][s.charAt(2)-64] = true;
        dfs(0, n-2, f, t);
        return result;
    }

}
