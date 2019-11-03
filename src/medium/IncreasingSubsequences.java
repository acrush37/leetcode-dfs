package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Given an integer array, your task is to find all the different possible increasing subsequences
    of the given array, and the length of an increasing subsequence should be at least 2.
 */
public class IncreasingSubsequences {

    private Set<String> set;
    private List<List<Integer>> result;

    public static void main(String... args) {

        int[] nums = {4, 6, 7, 7};
        IncreasingSubsequences increasingSubsequences = new IncreasingSubsequences();
        System.out.println(increasingSubsequences.findSubsequences(nums));
    }

    private void dfs(int k, int p, int n, int last, int[] nums, String s, boolean[] t) {

        if (k >= 2) {

            if (!set.contains(s)) {

                set.add(s);
                List<Integer> list = new ArrayList<>();
                String[] a = s.split(",");

                for (int i = 1; i < a.length; i++)
                    list.add(Integer.parseInt(a[i]));

                result.add(list);
            }
        }

        for (int i = p; i < n; i++)
            if (!t[i] && nums[i] >= last) {

                t[i] = true;
                dfs(k+1, i, n, nums[i], nums, s + "," + nums[i], t);
                t[i] = false;
            }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {

        int n = nums.length;
        result = new ArrayList<>();
        if (n < 2) return result;
        set = new HashSet<>();
        dfs(0, 0, n,-100, nums, "", new boolean[n]);
        return result;
    }

}
