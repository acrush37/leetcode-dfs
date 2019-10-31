package easy;

import java.util.ArrayList;
import java.util.List;

/*
    Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 */
public class LeafSimilarTrees {

    private List<Integer> a;
    private List<Integer> b;

    public static void main(String... args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(8);
        LeafSimilarTrees leafSimilarTrees = new LeafSimilarTrees();
        System.out.println(leafSimilarTrees.leafSimilar(root, root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(TreeNode root, boolean flag) {

        if (root.left == null) {

            if (root.right == null) {

                if (flag) a.add(root.val);
                else b.add(root.val);
                return;
            }

            dfs(root.right, flag);
            return;
        }

        if (root.right == null) dfs(root.left, flag);
        else {
            dfs(root.left, flag);
            dfs(root.right, flag);
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        a = new ArrayList<>();
        b = new ArrayList<>();
        dfs(root1, true);
        dfs(root2, false);
        int n = a.size();
        if (b.size() != n) return false;
        for (int i = 0; i < n; i++) if (a.get(i) != b.get(i)) return false;
        return true;
    }

}
