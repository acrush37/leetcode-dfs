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

        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric(null));
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        return false;
    }
}
