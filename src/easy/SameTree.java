package easy;

/*
    Given two binary trees, write a function to check if they are the same or not.

    Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
public class SameTree {

    public static void main(String... args) {

        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(1);
        node2.right = new TreeNode(2);
        SameTree sameTree = new SameTree();
        System.out.println(sameTree.isSameTree(node1 ,node2));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private boolean dfs(TreeNode p, TreeNode q) {

        if (p == null) return q == null;
        if (q == null) return false;
        return p.val == q.val && dfs(p.left, q.left) && dfs(p.right, q.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

}
