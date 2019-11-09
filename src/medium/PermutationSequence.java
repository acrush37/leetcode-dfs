package medium;

/*
    The set [1,2,3,...,n] contains a total of n! unique permutations.

    By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

    Given n and k, return the kth permutation sequence.
 */
public class PermutationSequence {

    private int m;
    private String result;

    public static void main(String... args) {

        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(4, 9));
    }

    private void dfs(int k, int n, boolean[] t, String s) {

        if (k == n) {

            if (--m == 0) result = s;
            return;
        }

        for (int i = 1; i <= n; i++)
            if (!t[i]) {

                t[i] = true;
                dfs(k + 1, n, t,s + i);
                if (result != null) return;
                t[i] = false;
            }
    }

    public String getPermutation(int n, int k) {

        m = k;
        dfs(0, n, new boolean[n+1], "");
        return result;
    }

}
