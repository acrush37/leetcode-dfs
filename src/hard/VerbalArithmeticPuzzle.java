package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Given an equation, represented by words on left side and the result on right side.
    You need to check if the equation is solvable under the following rules:

    Each character is decoded as one digit (0 - 9).
    Every pair of different characters they must map to different digits.
    Each words[i] and result are decoded as one number without leading zeros.
    Sum of numbers on left side (words) will equal to the number on right side (result).

    Return True if the equation is solvable otherwise return False.
 */
public class VerbalArithmeticPuzzle {

    public static void main(String... args) {

        String[] words = {"GEMINI","VIRGO"};
        VerbalArithmeticPuzzle verbalArithmeticPuzzle = new VerbalArithmeticPuzzle();
        System.out.println(verbalArithmeticPuzzle.isSolvable(words, "CANCER"));
    }

    private boolean dfs(int k, int n, int[] b, List<Integer> w, int[][] a, boolean[][] f, boolean[] t, List<Integer> p) {

        if (k == -1) {

            String s = "";
            for (int i = 1; i <= a[0][0]; i++) s += b[a[0][i]]-1;
            int x = Integer.parseInt(s);

            for (int i = 1; i <= n; i++) {

                s = "";
                for (int j = 1; j <= a[i][0]; j++) s += b[a[i][j]] - 1;
                if ((x -= Integer.parseInt(s)) < 0) return false;
            }

            return x == 0;
        }

        int x = w.get(k), y = 0, z = 9;

        if (x == a[0][1]) {
            for (int u : p) if (b[u] != 0) y += b[u] - 1;
            z = Math.min(y+1, 9);
        }

        for (int i = y; i <= z; i++)
            if (!t[i] && !f[x][i]) {

                b[x] = i+1;
                t[i] = true;
                if (dfs(k-1, n, b, w, a, f, t, p)) return true;
                t[i] = false;
                b[x] = 0;
            }

        return false;
    }

    public boolean isSolvable(String[] words, String result) {

        int max = 0, n = words.length;
        int[][] a = new int[n+1][8];
        boolean[][] f = new boolean[26][10];
        Set<Integer> t = new HashSet<>();

        for (int i = 1; i <= n; i++) {

            char[] c = words[i-1].toCharArray();
            max = Math.max(max, a[i][0] = c.length);
            for (int j = 1; j <= a[i][0]; j++) t.add(a[i][j] = c[j-1] - 65);
            if (a[i][0] != 1) f[a[i][1]][0] = true;
        }

        char[] c = result.toCharArray();
        a[0][0] = c.length;
        if (a[0][0] != max && a[0][0] != max+1) return false;
        for (int i = 1; i <= a[0][0]; i++) t.add(a[0][i] = c[i-1] - 65);
        if (a[0][0] != 1) f[a[0][1]][0] = true;
        List<Integer> p = new ArrayList<>();

        if (a[0][0] == max+1) {
            int x = n*9/10 + 2;
            for (int i = x; i <= 9; i++) f[a[0][1]][i] = true;
        } else {

            for (int i = 1; i <= n; i++)
                if (a[i][0] == a[0][0])
                    p.add(a[i][1]);

            Set<Integer> y = new HashSet<>(p);
            int z = (y.size() * (y.size()+1)) >> 1;
            for (int i = 0; i <= z-1; i++) f[a[0][1]][i] = true;
        }

        List<Integer> list = new ArrayList<>(t);

        for (int i = 0; i < list.size(); i++)
            if (p.contains(list.get(i)) || list.get(i) == a[0][1])
                list.remove(i--);

        list.add(a[0][1]);
        for (int i = 1; i <= n; i++) if (a[i][0] == a[0][0]) list.add(a[i][1]);
        return dfs(t.size()-1, n, new int[26], list, a, f, new boolean[10], p);
    }

}
