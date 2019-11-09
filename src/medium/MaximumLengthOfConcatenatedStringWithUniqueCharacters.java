package medium;

import java.util.Arrays;
import java.util.List;

/*
    Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

    Return the maximum possible length of s.
 */
public class MaximumLengthOfConcatenatedStringWithUniqueCharacters {

    private int max = 0;

    public static void main(String... args) {

        List<String> arr = Arrays.asList("cha", "r", "act", "ers");
        MaximumLengthOfConcatenatedStringWithUniqueCharacters maximumLengthOfConcatenatedStringWithUniqueCharacters = new MaximumLengthOfConcatenatedStringWithUniqueCharacters();
        System.out.println(maximumLengthOfConcatenatedStringWithUniqueCharacters.maxLength(arr));
    }

    private void dfs(int p, int n, String[] a, int[] f) {

        int s = 0;
        for (char c = 'a'; c <= 'z'; c++) s += f[c-97];
        max = Math.max(max, s);

        for (int i = p; i < n; i++) {

            boolean flag = false;
            int[] t = Arrays.copyOf(f, 26);

            for (int j = 0; j < a[i].length(); j++) {

                int x = a[i].charAt(j) - 97;

                if (t[x] != 0) {

                    flag = true;
                    break;
                }

                t[x] = 1;
            }

            if (flag) continue;
            dfs(i+1, n, a, t);
        }
    }

    public int maxLength(List<String> arr) {

        int n = arr.size();
        String[] a = new String[n];
        arr.toArray(a);
        dfs(0, n, a, new int[26]);
        return max;
    }

}
