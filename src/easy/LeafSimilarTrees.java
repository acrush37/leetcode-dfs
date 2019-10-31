package easy;

/*
    Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 */
public class LeafSimilarTrees {

    public static void main(String... args) {

        LeafSimilarTrees leafSimilarTrees = new LeafSimilarTrees();
        System.out.println(leafSimilarTrees.leafSimilar(null, null));
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return false;
    }

}
