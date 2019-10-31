package easy;

/*
    Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

    For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

        1
       / \
      2   2
     / \ / \
    3  4 4  3
 */
public class SymmetricTree {

    public static void main(String... args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);
        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric(node));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private boolean dfs(TreeNode left, TreeNode right) {

        if (left == null) return right == null;
        if (right == null) return false;
        return left.val == right.val && dfs(left.right, right.left) && dfs(right.right, left.left);
    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;
        return dfs(root.left, root.right);
    }
}
