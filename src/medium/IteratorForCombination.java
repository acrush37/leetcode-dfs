package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Design an Iterator class, which has:

    A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
    A function next() that returns the next combination of length combinationLength in lexicographical order.
    A function hasNext() that returns True if and only if there exists a next combination.
 */
public class IteratorForCombination {

    private int n;

    private List<String> f = new ArrayList<>();

    public static void main(String... args) {

        IteratorForCombination iteratorForCombination = new IteratorForCombination("abc", 2);
        System.out.println(iteratorForCombination.next());
        System.out.println(iteratorForCombination.hasNext());
        System.out.println(iteratorForCombination.next());
        System.out.println(iteratorForCombination.hasNext());
        System.out.println(iteratorForCombination.next());
        System.out.println(iteratorForCombination.hasNext());
    }

    private void dfs(int p, int m, char[] c, String s) {

        if (m == 0) {
            f.add(s);
            return;
        }

        for (int i = p; i < c.length; i++) dfs(i+1, m-1, c, s + c[i]);
    }

    public IteratorForCombination(String characters, int combinationLength) {
        dfs(0, combinationLength, characters.toCharArray(), "");
    }

    public String next() {
        return f.get(n++);
    }

    public boolean hasNext() {
        return n < f.size();
    }

}
