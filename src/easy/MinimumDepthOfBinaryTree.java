package easy;

/*
    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {

    public static void main(String... args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
        System.out.println(minimumDepthOfBinaryTree.minDepth(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int dfs(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null) return root.right == null ? 1 : 1 + dfs(root.right);
        if (root.right == null) return 1 + dfs(root.left);
        return 1 + Math.min(dfs(root.left), dfs(root.right));
    }

    public int minDepth(TreeNode root) {
        return dfs(root);
    }

}
