package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 */
public class PathSumII {

    private List<List<Integer>> result;

    public static void main(String... args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        PathSumII pathSumII = new PathSumII();
        System.out.println(pathSumII.pathSum(root, 22));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(int s, TreeNode root, List<Integer> list) {

        list.add(root.val);

        if (root.left == null && root.right == null && s == root.val) {

            result.add(new ArrayList<>(list));
            return;
        }

        if (root.left != null) {

            dfs(s - root.val, root.left, list);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {

            dfs(s - root.val, root.right, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        result = new ArrayList<>();
        if (root == null) return result;
        dfs(sum, root, new ArrayList<>());
        return result;
    }
}
