package easy;

/*
    Given a binary tree, determine if it is height-balanced.

    For this problem, a height-balanced binary tree is defined as:

    a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
public class BalancedBinaryTree {

    public static void main(String... args) {

        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        System.out.println(balancedBinaryTree.isBalanced(null));
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        return false;
    }

}
