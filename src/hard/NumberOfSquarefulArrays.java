package hard;

import java.util.HashSet;
import java.util.Set;

/*
    Given an array A of non-negative integers, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.

    Return the number of permutations of A that are squareful.
    Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].
 */
public class NumberOfSquarefulArrays {

    private int result;

    private boolean[][] t;

    private Set<String> set = new HashSet<>();

    public static void main(String... args) {

        int[] A = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        NumberOfSquarefulArrays numberOfSquarefulArrays = new NumberOfSquarefulArrays();
        System.out.println(numberOfSquarefulArrays.numSquarefulPerms(A));
    }

    private void dfs(int k, int p, int n, int[] A, boolean[] f, String s) {

        if (k == n-1) {

            if (!set.contains(s)) {
                result++;
                set.add(s);
            }

            return;
        }

        for (int i = 0; i < n; i++)
            if (!f[i] && t[p][i]) {

                f[i] = true;
                dfs(k+1, i, n, A, f, s + "," + A[i]);
                f[i] = false;
            }
    }

    public int numSquarefulPerms(int[] A) {

        int n = A.length;
        if (n == 1) return 1;
        t = new boolean[n][n];
        boolean flag = true;

        for (int i = 0; i < n-1; i++) {

            if (A[i] != A[i+1]) flag = false;

            for (int j = i + 1; j < n; j++) {

                int x = A[i] + A[j];
                int y = (int) Math.sqrt(x);
                if (x == y * y) t[i][j] = t[j][i] = true;
            }
        }

        if (flag) {
            int x = A[0] + A[1];
            int y = (int) Math.sqrt(x);
            return x == y*y ? 1 : 0;
        }

        for (int i = 0; i < n; i++) {

            boolean[] f = new boolean[n];
            f[i] = true;
            dfs(0, i, n, A, f, A[i] + "");
        }

        return result;
    }
}
