package medium;

import java.util.*;

/*
    You need to find the largest value in each row of a binary tree.
 */
public class FindLargestValueInEachTreeRow {

    private Map<Integer, Integer> map;

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        FindLargestValueInEachTreeRow findLargestValueInEachTreeRow = new FindLargestValueInEachTreeRow();
        System.out.println(findLargestValueInEachTreeRow.largestValues(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(int k, TreeNode root) {

        if (root == null) return;
        Integer n = map.get(k);
        if (n == null || root.val > n) map.put(k, root.val);
        dfs(k+1, root.left);
        dfs(k+1, root.right);
    }

    public List<Integer> largestValues(TreeNode root) {

        map = new HashMap<>();
        dfs(0, root);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; ; i++) {

            Integer n = map.get(i);
            if (n == null) return list;
            list.add(n);
        }
    }
}
