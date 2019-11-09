package medium;

import java.util.*;

/*
    Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 */
public class SubsetsII {

    private Set<String> set = new HashSet<>();
    private List<List<Integer>> result = new ArrayList<>();

    public static void main(String... args) {

        int[] nums = {1, 2, 2};
        SubsetsII subsetsII = new SubsetsII();
        System.out.println(subsetsII.subsetsWithDup(nums));
    }

    private void dfs(int p, int n, int[] nums, String s) {

        if (!set.contains(s)) {

            set.add(s);
            String[] arr = s.split(",");
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < arr.length; i++) list.add(Integer.parseInt(arr[i]));
            result.add(list);
        }

        for (int i = p; i < n; i++) dfs(i+1, n, nums, s + nums[i] + ",");
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        dfs(0, n, nums, ",");
        return result;
    }

}
