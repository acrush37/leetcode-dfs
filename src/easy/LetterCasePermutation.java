package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.

    Return a list of all possible strings we could create.
 */
public class LetterCasePermutation {

    private List<String> result = new ArrayList<>();

    public static void main(String... args) {

        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        System.out.println(letterCasePermutation.letterCasePermutation("a1B2"));
    }

    private void dfs(int k, char[] a, String s) {

        if (k < 0) {

            result.add(s);
            return;
        }

        dfs(k-1, a, a[k] + s);

        if (!Character.isDigit(a[k]))
            dfs(k-1, a, (char) (a[k] > 'Z' ? a[k] - 32 : a[k] + 32) + s);
    }

    public List<String> letterCasePermutation(String S) {

        int n = S.length();
        if (n == 0) return Collections.EMPTY_LIST;
        char[] a = S.toCharArray();
        dfs(n-1, a, "");
        return result;
    }

}
