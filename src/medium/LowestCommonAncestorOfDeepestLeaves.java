package medium;

import java.util.*;
import java.util.stream.Collectors;

/*
    Given a rooted binary tree, return the lowest common ancestor of its deepest leaves.

    Recall that:

    The node of a binary tree is a leaf if and only if it has no children
    The depth of the root of the tree is 0, and if the depth of a node is d, the depth of each of its children is d+1.
    The lowest common ancestor of a set S of nodes is the node A with the largest depth such that every node in S is in the subtree with root A.
 */
public class LowestCommonAncestorOfDeepestLeaves {

    private int max;
    private Map<TreeNode, TreeNode> parent;
    private Map<Integer, List<TreeNode>> leaves;

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        LowestCommonAncestorOfDeepestLeaves lowestCommonAncestorOfDeepestLeaves = new LowestCommonAncestorOfDeepestLeaves();
        System.out.println(lowestCommonAncestorOfDeepestLeaves.lcaDeepestLeaves(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(int k, TreeNode root) {

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left == null && right != null) {

            parent.put(right, root);
            dfs(k+1, right);
        } else if (left != null && right == null) {

            parent.put(left, root);
            dfs(k+1, left);
        } else if (left != null && right != null) {

            parent.put(left, root);
            parent.put(right, root);
            dfs(k+1, left);
            dfs(k+1, right);
        } else {

            max = Math.max(max, k);
            List<TreeNode> list = leaves.get(k);
            if (list == null) list = new ArrayList<>();
            list.add(root);
            leaves.put(k, list);
        }
    }

    private TreeNode build(int n, List<TreeNode> list) {

        boolean flag = true;

        for (int i = 0; i < n-1; i++)
            if (list.get(i) != list.get(i+1)) {

                flag = false;
                break;
            }

        if (flag) return list.get(0);
        return build(n, list.stream().map(i -> parent.get(i)).collect(Collectors.toList()));
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {

        max = 0;
        leaves = new HashMap<>();
        parent = new HashMap<>();
        dfs(0, root);
        List<TreeNode> list = leaves.get(max);
        int n = list.size();
        if (n == 1) return list.get(0);
        return build(n, list);
    }

}
