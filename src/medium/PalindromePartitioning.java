package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given a string s, partition s such that every substring of the partition is a palindrome.

    Return all possible palindrome partitioning of s.
 */
public class PalindromePartitioning {

    private List<List<String>> result = new ArrayList<>();

    public static void main(String... args) {

        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        System.out.println(palindromePartitioning.partition("aab"));
    }

    private void dfs(int p, int n, char[] a, boolean[][] f, String s) {

        if (p == n+1) {

            String[] arr = s.split(",");
            List<String> list = new ArrayList<>();
            for (int i = 1; i < arr.length; i++) list.add(arr[i]);
            result.add(list);
            return;
        }

        for (int i = p; i <= n; i++)
            if (f[p][i])
                dfs(i+1, n, a, f, s + String.valueOf(Arrays.copyOfRange(a, p-1, i)) + ",");
    }

    public List<List<String>> partition(String s) {

        int n = s.length();
        if (n == 0) return Arrays.asList(Arrays.asList());
        char[] a = s.toCharArray();
        if (n == 1) return Arrays.asList(Arrays.asList(a[0] + ""));
        boolean[][] f = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) f[i][i] = true;

        for (int i = 1; i < n; i++)
            if (a[i] == a[i-1])
                f[i][i+1] = true;

        for (int j = 2; j < n; j++)
            for (int i = 1; i <= n-j; i++)
                f[i][i+j] = f[i+1][i+j-1] && a[i-1] == a[i+j-1];

        dfs(1, n, a, f, ",");
        return result;
    }

}
