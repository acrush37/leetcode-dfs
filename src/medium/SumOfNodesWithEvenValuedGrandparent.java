package medium;

/*
    Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)

    If there are no nodes with an even-valued grandparent, return 0.
 */
public class SumOfNodesWithEvenValuedGrandparent {

    public static void main(String... args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        SumOfNodesWithEvenValuedGrandparent sumOfNodesWithEvenValuedGrandparent = new SumOfNodesWithEvenValuedGrandparent();
        System.out.println(sumOfNodesWithEvenValuedGrandparent.sumEvenGrandparent(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sumEvenGrandparent(TreeNode root) {

        int result = 0, parent = -1, child = 1;
        TreeNode[] q = new TreeNode[10001];
        int[][] t = new int[10001][2];
        t[0][1] = root.val;
        q[0] = root;

        while (++parent < child) {

            TreeNode node = q[parent];

            if (node.left != null) {
                q[child] = node.left;
                t[child][0] = parent;
                t[child++][1] = node.left.val;
            }

            if (node.right != null) {
                q[child] = node.right;
                t[child][0] = parent;
                t[child++][1] = node.right.val;
            }
        }

        for (int i = 2; i < child; i++)
            if (t[i][0] != 0 && (t[t[t[i][0]][0]][1] & 1) == 0)
                result += t[i][1];

        return result;
    }

}
