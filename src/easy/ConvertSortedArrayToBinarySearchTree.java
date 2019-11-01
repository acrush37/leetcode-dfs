package easy;

import java.util.Arrays;

/*
    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String... args) {

        int[] nums = {-10, -3, 0, 5, 9};
        ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree = new ConvertSortedArrayToBinarySearchTree();
        System.out.println(convertSortedArrayToBinarySearchTree.sortedArrayToBST(nums));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode dfs(int[] nums, int left, int right) {

        int n = right - left;
        if (n == 0) return null;
        if (n == 1) return new TreeNode(nums[left]);
        int middle = (left + right) >> 1;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = dfs(nums, left, middle);
        node.right = dfs(nums, middle+1, right);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

}
