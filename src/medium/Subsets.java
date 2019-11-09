package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Given a set of distinct integers, nums, return all possible subsets (the power set).
 */
public class Subsets {

    private List<List<Integer>> result = new ArrayList<>();

    public static void main(String... args) {

        int[] nums = {1, 2, 3};
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(nums));
    }

    private void dfs(int k, int p, int n, int[] nums, String s) {

        if (k == 0) {

            String[] arr = s.split(",");
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < arr.length; i++) list.add(Integer.parseInt(arr[i]));
            result.add(list);
            return;
        }

        for (int i = p; i < n; i++) dfs(k-1, i+1, n, nums, s + nums[i] + ",");
    }

    public List<List<Integer>> subsets(int[] nums) {

        int n = nums.length;
        result.add(Collections.EMPTY_LIST);
        for (int i = 1; i <= n; i++) dfs(i, 0, n, nums, ",");
        return result;
    }

}
