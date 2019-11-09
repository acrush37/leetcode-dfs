package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    Given a collection of distinct integers, return all possible permutations.
 */
public class Permutations {

    private List<List<Integer>> result = new ArrayList<>();

    public static void main(String... args) {

        int[] nums = {1, 2, 3};
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(nums));
    }

    private void dfs(int k, int n, int[] nums, boolean[] t, String s) {

        if (k == n) {

            String[] arr = s.split(",");
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) list.add(Integer.parseInt(arr[i]));
            result.add(list);
            return;
        }

        for (int i = 0; i < n; i++)
            if (!t[i]) {

                t[i] = true;
                dfs(k+1, n, nums, t, s + nums[i] + ",");
                t[i] = false;
            }
    }

    public List<List<Integer>> permute(int[] nums) {

        int n = nums.length;
        if (n == 0) return Arrays.asList(Collections.EMPTY_LIST);
        dfs(0, n, nums, new boolean[n], ",");
        return result;
    }

}
