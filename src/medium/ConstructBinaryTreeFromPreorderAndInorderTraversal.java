package medium;

import java.util.Arrays;

/*
    Given preorder and inorder traversal of a tree, construct the binary tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String... args) {

        int[] preorder = {3, 2, 1, 4};
        int[] inorder = {1, 2, 3, 4};
        ConstructBinaryTreeFromPreorderAndInorderTraversal constructBinaryTreeFromPreorderAndInorderTraversal = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        System.out.println(constructBinaryTreeFromPreorderAndInorderTraversal.buildTree(preorder, inorder));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode dfs(int[] preorder, int[] inorder) {

        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        if (n == 1) return root;
        int i = 0;
        while (inorder[i] != preorder[0]) i++;

        if (i == 0) root.right = dfs(Arrays.copyOfRange(preorder, 1, n), Arrays.copyOfRange(inorder, 1, n));
        else if (i == n-1) root.left = dfs(Arrays.copyOfRange(preorder, 1, n), Arrays.copyOfRange(inorder, 0, n-1));
        else {
            root.left = dfs(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
            root.right = dfs(Arrays.copyOfRange(preorder, i + 1, n), Arrays.copyOfRange(inorder, i + 1, n));
        }

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0) return null;
        return dfs(preorder, inorder);
    }

}
