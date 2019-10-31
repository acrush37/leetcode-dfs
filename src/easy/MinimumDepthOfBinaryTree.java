package easy;

/*
    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {

    public static void main(String... args) {

        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
        System.out.println(minimumDepthOfBinaryTree.minDepth(null));
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        return 0;
    }

}
