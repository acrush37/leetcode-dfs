package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Find all possible combinations of k numbers that add up to a number n,
    given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 */
public class CombinationSumIII {

    private List<List<Integer>> result = new ArrayList<>();

    public static void main(String... args) {

        CombinationSumIII combinationSumIII = new CombinationSumIII();
        System.out.println(combinationSumIII.combinationSum3(3, 7));
    }

    private void dfs(int p, int k, int n, String s) {

        if (n < 0) return;

        if (k == 0) {

            if (n != 0) return;
            String[] arr = s.split(",");
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < arr.length; i++) list.add(Integer.parseInt(arr[i]));
            result.add(list);
            return;
        }

        for (int i = p; i <= 9; i++) dfs(i+1, k-1, n-i, s+i + ",");
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        if (((19 - k) * k) >> 1 < n) return result;
        dfs(1, k, n, ",");
        return result;
    }

}
