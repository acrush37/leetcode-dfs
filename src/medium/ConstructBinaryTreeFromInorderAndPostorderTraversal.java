package medium;

import java.util.Arrays;

/*
    Given inorder and postorder traversal of a tree, construct the binary tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String... args) {

        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};
        ConstructBinaryTreeFromInorderAndPostorderTraversal constructBinaryTreeFromInorderAndPostorderTraversal = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        System.out.println(constructBinaryTreeFromInorderAndPostorderTraversal.buildTree(inorder, postorder));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode dfs(int[] postorder, int[] inorder) {

        int n = postorder.length;
        TreeNode root = new TreeNode(postorder[n-1]);
        if (n == 1) return root;
        int i = 0;
        while (inorder[i] != postorder[n-1]) i++;

        if (i == 0) root.right = dfs(Arrays.copyOfRange(postorder, 0, n-1), Arrays.copyOfRange(inorder, 1, n));
        else if (i == n-1) root.left = dfs(Arrays.copyOfRange(postorder, 0, n-1), Arrays.copyOfRange(inorder, 0, n-1));
        else {
            root.left = dfs(Arrays.copyOfRange(postorder, 0, i), Arrays.copyOfRange(inorder, 0, i));
            root.right = dfs(Arrays.copyOfRange(postorder, i, n-1), Arrays.copyOfRange(inorder, i + 1, n));
        }

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder.length == 0) return null;
        return dfs(postorder, inorder);
    }

}
