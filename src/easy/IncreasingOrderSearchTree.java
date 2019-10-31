package easy;

/*
    Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the
    tree is now the root of the tree, and every node has no left child and only 1 right child.
 */
public class IncreasingOrderSearchTree {

    public static void main(String... args) {

        IncreasingOrderSearchTree increasingOrderSearchTree = new IncreasingOrderSearchTree();
        System.out.println(increasingOrderSearchTree.increasingBST(null));
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
          val = x;
      }
    }

    public TreeNode increasingBST(TreeNode root) {
        return null;
    }

}
