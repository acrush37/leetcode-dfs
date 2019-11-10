package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:

    0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
    F.length >= 3; and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.

    Also, note that when splitting the string into pieces, each piece must not have
    extra leading zeroes, except if the piece is the number 0 itself.

    Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.
 */
public class SplitArrayIntoFibonacciSequence {

    private List<Integer> result = new ArrayList<>();

    public static void main(String... args) {

        SplitArrayIntoFibonacciSequence splitArrayIntoFibonacciSequence = new SplitArrayIntoFibonacciSequence();
        System.out.println(splitArrayIntoFibonacciSequence.splitIntoFibonacci("0123"));
    }

    private void dfs(int k, int p, int n, char[] c, String s, Integer[] f) {

        if (p == n) {

            if (k >= 3) result = Arrays.asList(Arrays.copyOfRange(f,0, k));
            return;
        }

        if (c[p] == '0') {

            if (k >= 2 && f[k-1] + f[k-2] != 0) return;
            f[k] = 0;
            dfs(k+1, p+1, n, c, s, f);
            f[k] = null;
            return;
        }

        for (int i = p; i < n; i++) {

            String t = s.substring(p, i+1);
            int len = t.length();
            if (len > 10 || len == 10 && t.compareTo("2147483647") > 0) continue;
            int x = Integer.parseInt(t);
            if (k >= 2 && x != f[k-1] + f[k-2]) continue;
            f[k] = x;
            dfs(k+1, i+1, n, c, s, f);
            if (!result.isEmpty()) return;
            f[k] = null;
        }
    }

    public List<Integer> splitIntoFibonacci(String S) {

        int n = S.length();
        char[] c = S.toCharArray();
        dfs(0, 0, n, c, S, new Integer[n]);
        return result;
    }

}
