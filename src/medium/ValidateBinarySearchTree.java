package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {

    private List<Integer> list;

    public static void main(String... args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        System.out.println(validateBinarySearchTree.isValidBST(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(TreeNode root) {

        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;
        list = new ArrayList<>();
        dfs(root);
        int n = list.size();

        for (int i = 0; i < n-1; i++)
            if (list.get(i) >= list.get(i+1))
                return false;

        return true;
    }

}
