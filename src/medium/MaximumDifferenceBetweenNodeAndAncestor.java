package medium;

/*
    Given the root of a binary tree, find the maximum value V for which there exists
    different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.

    (A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.)
 */
public class MaximumDifferenceBetweenNodeAndAncestor {

    private int max;

    public static void main(String... args) {

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(10);
        root.right.right.left = new TreeNode(13);
        MaximumDifferenceBetweenNodeAndAncestor maximumDifferenceBetweenNodeAndAncestor = new MaximumDifferenceBetweenNodeAndAncestor();
        System.out.println(maximumDifferenceBetweenNodeAndAncestor.maxAncestorDiff(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(int x, int y, TreeNode root) {

        max = Math.max(max, Math.abs(x - root.val));
        max = Math.max(max, Math.abs(y - root.val));
        int u = root.val > x ? root.val : x;
        int v = root.val < y ? root.val : y;
        if (root.left != null) dfs(u, v, root.left);
        if (root.right != null) dfs(u, v, root.right);
    }

    public int maxAncestorDiff(TreeNode root) {

        max = 0;
        dfs(root.val, root.val, root);
        return max;
    }

}
