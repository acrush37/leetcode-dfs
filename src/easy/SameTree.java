package easy;

/*
    Given two binary trees, write a function to check if they are the same or not.

    Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
public class SameTree {

    public static void main(String... args) {

        SameTree sameTree = new SameTree();
        System.out.println(sameTree.isSameTree(null ,null));
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return false;
    }

}
