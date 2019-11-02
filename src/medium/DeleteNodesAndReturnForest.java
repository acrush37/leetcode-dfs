package medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Given the root of a binary tree, each node in the tree has a distinct value.

    After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

    Return the roots of the trees in the remaining forest.  You may return the result in any order.
 */
public class DeleteNodesAndReturnForest {

    private List<TreeNode> list;
    private boolean[] deletes;

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        int[] to_delete = {2, 1};
        DeleteNodesAndReturnForest deleteNodesAndReturnForest = new DeleteNodesAndReturnForest();
        System.out.println(deleteNodesAndReturnForest.delNodes(root, to_delete));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(TreeNode root) {

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left != null) {

            if (deletes[root.val] && !deletes[left.val]) list.add(left);
            else if (!deletes[root.val] && deletes[left.val]) root.left = null;
            dfs(left);
        }

        if (right != null) {

            if (deletes[root.val] && !deletes[right.val]) list.add(right);
            else if (!deletes[root.val] && deletes[right.val]) root.right = null;
            dfs(right);
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        list = new ArrayList<>();
        if (root == null) return list;
        deletes = new boolean[1001];
        for (int i : to_delete) deletes[i] = true;
        if (!deletes[root.val]) list.add(root);
        dfs(root);
        return list;
    }

}
