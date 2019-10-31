package easy;

import java.util.List;

/*
    Given a binary tree, return all root-to-leaf paths.
 */
public class BinaryTreePaths {

    public static void main(String... args) {

        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        System.out.println(binaryTreePaths.binaryTreePaths(null));
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        return null;
    }

}
