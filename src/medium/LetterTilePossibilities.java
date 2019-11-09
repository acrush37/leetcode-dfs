package medium;

import java.util.HashSet;
import java.util.Set;

/*
    You have a set of tiles, where each tile has one letter tiles[i] printed on it.

    Return the number of possible non-empty sequences of letters you can make.
 */
public class LetterTilePossibilities {

    private int result = 0;
    private Set<String> set = new HashSet<>();

    public static void main(String... args) {

        LetterTilePossibilities letterTilePossibilities = new LetterTilePossibilities();
        System.out.println(letterTilePossibilities.numTilePossibilities("AAABBC"));
    }

    private void dfs(int n, char[] a, boolean[] t, String s) {

        if (!set.contains(s)) {

            result++;
            set.add(s);
        }

        for (int i = 0; i < n; i++)
            if (!t[i]) {

                t[i] = true;
                dfs(n, a, t, s + a[i]);
                t[i] = false;
            }
    }

    public int numTilePossibilities(String tiles) {

        int n = tiles.length();
        char[] a = tiles.toCharArray();
        dfs(n, a, new boolean[n], "");
        return result - 1;
    }

}
