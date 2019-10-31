package easy;

/*
    Given a binary tree, determine if it is height-balanced.

    For this problem, a height-balanced binary tree is defined as:

    a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
public class BalancedBinaryTree {

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right.right.right= new TreeNode(4);
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        System.out.println(balancedBinaryTree.isBalanced(root));
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

    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;
        if (Math.abs(dfs(root.left) - dfs(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

}
