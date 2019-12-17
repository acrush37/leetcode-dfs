package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

    Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 */
public class SequentialDigits {

    private List<Integer> t = new ArrayList<>();

    private int[] f = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

    public static void main(String... args) {

        SequentialDigits sequentialDigits = new SequentialDigits();
        System.out.println(sequentialDigits.sequentialDigits(1000, 13000));
    }

    private void dfs(int k, int n, int p, int s) {

        if (k == n) {
            t.add(s);
            return;
        }

        if (p == 0) return;

        if (k != 0) dfs(k+1, n, p-1,s + p * f[k]);
        else for (int i = 9; i >= 1; i--) dfs(k+1, n, i-1, s + i * f[k]);
    }

    public List<Integer> sequentialDigits(int low, int high) {

        int left = (low + "").length();
        int right = (high - 1 + "").length();
        for (int i = left; i <= right; i++) dfs(0, i, 1, 0);
        left = 0;
        right = t.size()-1;
        Collections.sort(t);
        while (left <= right && t.get(left) < low) left++;
        while (right >= 0 && t.get(right) > high) right--;
        return t.subList(left, right+1);
    }

}
