package easy;

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

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return null;
    }

}
