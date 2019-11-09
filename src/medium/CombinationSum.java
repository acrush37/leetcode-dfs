package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
    find all unique combinations in candidates where the candidate numbers sums to target.

    The same repeated number may be chosen from candidates unlimited number of times.
 */
public class CombinationSum {

    private List<List<Integer>> result = new ArrayList<>();

    public static void main(String... args) {

        int[] candidates = {2, 3, 5};
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(candidates, 8));
    }

    private void dfs(int p, int n, int s, int[] c, String f) {

        if (s < 0) return;

        if (s == 0) {

            String[] arr = f.split(",");
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < arr.length; i++) list.add(Integer.parseInt(arr[i]));
            result.add(list);
            return;
        }

        for (int i = p; i < n; i++) dfs(i, n, s - c[i], c, f + c[i] + ",");
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int n = candidates.length;
        if (n == 0) return result;
        dfs(0, n, target, candidates, ",");
        return result;
    }

}
