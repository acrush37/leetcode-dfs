package easy;

/*
    Given a binary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String... args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        System.out.println(maximumDepthOfBinaryTree.maxDepth(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int dfs(TreeNode root) {

        if (root == null) return 0;
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

}
