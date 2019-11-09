package medium;

import java.util.*;

/*
    The gray code is a binary numeral system where two successive values differ in only one bit.

    Given a non-negative integer n representing the total number of bits in the code,
    print the sequence of gray code. A gray code sequence must begin with 0.
 */
public class GrayCode {

    private boolean flag;

    public static void main(String... args) {

        GrayCode grayCode = new GrayCode();
        System.out.println(grayCode.grayCode(3));
    }

    private void dfs(int k, int n, char[] c, Set<String> t) {

        if (k == n) {

            flag = true;
            return;
        }

        for (int i = 0; i < n; i++) {

            c[i] = c[i] == '0' ? '1' : '0';
            String s = String.valueOf(c);

            if (!t.contains(s)) {

                t.add(s);
                dfs(k+1, n, c, t);
                if (flag) return;
                t.remove(s);
            }

            c[i] = c[i] == '0' ? '1' : '0';
        }
    }

    public List<Integer> grayCode(int n) {

        if (n == 0) return Arrays.asList(0);
        String s = "";
        for (int i = 0; i < n; i++) s += '0';
        Set<String> t = new LinkedHashSet<>();
        t.add(s);
        dfs(1, (int) Math.pow(2, n), s.toCharArray(), t);
        List<Integer> result = new ArrayList<>();

        for (String x : t) {

            int sum = 0;
            char[] c = x.toCharArray();
            for (int i = 0; i < n; i++) sum += (c[n-i-1] - 48) * Math.pow(2, i);
            result.add(sum);
        }

        return result;
    }

}
