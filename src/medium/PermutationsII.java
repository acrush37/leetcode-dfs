package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
public class PermutationsII {

    private Set<String> set = new HashSet<>();
    private List<List<Integer>> result = new ArrayList<>();

    public static void main(String... args) {

        int[] nums = {1, 1, 2};
        PermutationsII permutationsII = new PermutationsII();
        System.out.println(permutationsII.permuteUnique(nums));
    }

    private void dfs(int k, int n, int[] nums, boolean[] t, String s) {

        if (k == n) {

            if (set.contains(s)) return;
            String[] arr = s.split(",");
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) list.add(Integer.parseInt(arr[i]));
            result.add(list);
            set.add(s);
            return;
        }

        for (int i = 0; i < n; i++)
            if (!t[i]) {

                t[i] = true;
                dfs(k+1, n, nums, t, s + nums[i] + ",");
                t[i] = false;
            }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        int n = nums.length;
        dfs(0, n, nums, new boolean[n], ",");
        return result;
    }

}
