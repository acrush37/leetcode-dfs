package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    We are given a binary tree (with root node root), a target node, and an integer value K.

    Return a list of the values of all nodes that have a distance K from the target node.
    The answer can be returned in any order.
 */
public class AllNodesDistanceKInBinaryTree {

    private boolean[] t;
    private Set<Integer>[] f;
    private List<Integer> result;

    public static void main(String... args) {

        TreeNode root = new TreeNode(3);
        TreeNode target = new TreeNode(5);
        target.left = new TreeNode(6);
        target.right = new TreeNode(2);
        target.right.left = new TreeNode(7);
        target.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left = target;
        AllNodesDistanceKInBinaryTree allNodesDistanceKInBinaryTree = new AllNodesDistanceKInBinaryTree();
        System.out.println(allNodesDistanceKInBinaryTree.distanceK(root, target, 2));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void build(TreeNode root) {

        if (root.left != null) {

            f[root.val].add(root.left.val);
            f[root.left.val].add(root.val);
            build(root.left);
        }

        if (root.right != null) {

            f[root.val].add(root.right.val);
            f[root.right.val].add(root.val);
            build(root.right);
        }
    }

    private void dfs(int k, int n) {

        if (k == 0) {

            if (!result.contains(n)) result.add(n);
            return;
        }

        for (int x : f[n])
            if (!t[x]) {

                t[x] = true;
                dfs(k-1, x);
                t[x] = false;
            }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        f = new Set[501];
        t = new boolean[501];
        result = new ArrayList<>();
        for (int i = 0; i < 501; i++) f[i] = new HashSet<>();
        build(root);
        t[target.val] = true;
        dfs(K, target.val);
        return result;
    }

}
