package hard;

import java.util.*;

/*
    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in
    s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 */
public class WordBreakII {

    private int m;

    private Set<String> result = new HashSet<>();

    private Set<String> f = new HashSet<>(), t = new HashSet<>();

    public static void main(String... args) {

        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        WordBreakII wordBreakII = new WordBreakII();
        System.out.println(wordBreakII.wordBreak("pineapplepenapple", wordDict));
    }

    private void dfs(int p, int n, char[] c, StringBuilder s) {

        if (p == n) {
            result.add(s.substring(1));
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = p; i < n; i++) {

            sb.append(c[i]);
            String x = sb.toString();
            if (!t.contains(x)) return;
            if (f.contains(x) && m++ <= 1000000) dfs(i+1, n, c, new StringBuilder(s).append(' ').append(sb));
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        boolean[] b = new boolean[255];

        for (String word : wordDict) {

            f.add(word);
            char[] ch = word.toCharArray();
            StringBuilder sb = new StringBuilder();

            for (char c : ch) {
                b[c] = true;
                sb.append(c);
                t.add(sb.toString());
            }
        }

        char[] ch = s.toCharArray();
        for (char c : ch) if (!b[c]) return new ArrayList<>(result);
        dfs(0, s.length(), ch, new StringBuilder());
        return new ArrayList<>(result);
    }

}
