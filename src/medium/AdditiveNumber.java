package medium;

import java.math.BigInteger;

/*
    Additive number is a string whose digits can form additive sequence.

    A valid additive sequence should contain at least three numbers. Except for the first two numbers,
    each subsequent number in the sequence must be the sum of the preceding two.

    Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 */
public class AdditiveNumber {

    private boolean flag;

    public static void main(String... args) {

        AdditiveNumber additiveNumber = new AdditiveNumber();
        System.out.println(additiveNumber.isAdditiveNumber("199100199"));
    }

    private void dfs(int k, int p, int n, char[] c, String s, BigInteger[] f) {

        if (p == n) {

            if (k >= 3) flag = true;
            return;
        }

        if (c[p] == '0') {

            if (k >= 2 && !BigInteger.ZERO.equals(f[k-1].add(f[k-2]))) return;
            f[k] = BigInteger.ZERO;
            dfs(k+1, p+1, n, c, s, f);
            f[k] = null;
            return;
        }

        for (int i = p; i < n; i++) {

            String t = s.substring(p, i+1);
            BigInteger x = new BigInteger(t);
            if (k >= 2 && !x.equals(f[k-1].add(f[k-2]))) continue;
            f[k] = x;
            dfs(k+1, i+1, n, c, s, f);
            if (flag) return;
            f[k] = null;
        }
    }

    public boolean isAdditiveNumber(String num) {

        int n = num.length();
        char[] c = num.toCharArray();
        dfs(0, 0, n, c, num, new BigInteger[n]);
        return flag;
    }

}
