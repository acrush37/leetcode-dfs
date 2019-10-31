package easy;

/*
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 */
public class PathSum {

    public static void main(String... args) {

        PathSum pathSum = new PathSum();
        System.out.println(pathSum.hasPathSum(null, 0));
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return false;
    }

}
