package medium;

import java.util.*;

/*
    Given a collection of candidate numbers (candidates) and a target number (target),
    find all unique combinations in candidates where the candidate numbers sums to target.

    Each number in candidates may only be used once in the combination.
 */
public class CombinationSumII {

    private Set<String> set = new HashSet<>();
    private List<List<Integer>> result = new ArrayList<>();

    public static void main(String... args) {

        int[] candidates = {2, 5, 2, 1, 2};
        CombinationSumII combinationSumII = new CombinationSumII();
        System.out.println(combinationSumII.combinationSum2(candidates, 5));
    }

    private void dfs(int p, int n, int target, int[] c, String s) {

        if (target < 0) return;

        if (target == 0) {

            if (set.contains(s)) return;
            set.add(s);
            String[] arr = s.split(",");
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < arr.length; i++) list.add(Integer.parseInt(arr[i]));
            result.add(list);
            return;
        }

        for (int i = p; i < n; i++) dfs(i+1, n, target - c[i], c, s + c[i] + ",");
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        int n = candidates.length;
        if (n == 0) return result;
        Arrays.sort(candidates);
        dfs(0, n, target, candidates, ",");
        return result;
    }

}
