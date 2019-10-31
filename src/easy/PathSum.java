package easy;

/*
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 */
public class PathSum {

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        PathSum pathSum = new PathSum();
        System.out.println(pathSum.hasPathSum(root, 15));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private boolean dfs(int sum, TreeNode root) {

        if (root == null) return sum == 0;

        if (root.left == null) {
            return root.right == null ? sum == root.val : dfs(sum - root.val, root.right);
        }

        if (root.right == null) return dfs(sum - root.val, root.left);

        return dfs(sum - root.val, root.left) || dfs(sum - root.val, root.right);
    }

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) return false;
        return dfs(sum, root);
    }

}
