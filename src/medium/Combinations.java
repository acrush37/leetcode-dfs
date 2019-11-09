package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */
public class Combinations {

    private List<List<Integer>> result = new ArrayList<>();

    public static void main(String... args) {

        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }

    private void dfs(int k, int p, int n, String s) {

        if (k == 0) {

            String[] arr = s.split(",");
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < arr.length; i++) list.add(Integer.parseInt(arr[i]));
            result.add(list);
            return;
        }

        for (int i = p; i <= n; i++) dfs(k-1, i+1, n, s + i + ",");
    }

    public List<List<Integer>> combine(int n, int k) {

        if (k <= 0 || n < k) return Collections.EMPTY_LIST;
        dfs(k, 1, n, ",");
        return result;
    }

}
