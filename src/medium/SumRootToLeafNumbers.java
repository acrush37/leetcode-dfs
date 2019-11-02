package medium;

/*
    Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

    An example is the root-to-leaf path 1->2->3 which represents the number 123.

    Find the total sum of all root-to-leaf numbers.
 */
public class SumRootToLeafNumbers {

    private int result;

    public static void main(String... args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
        System.out.println(sumRootToLeafNumbers.sumNumbers(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(String s, TreeNode root) {

        if (root.left == null && root.right == null) {

            result += Integer.parseInt(s + root.val);
            return;
        }

        if (root.left != null) dfs(s + root.val, root.left);
        if (root.right != null) dfs(s + root.val, root.right);
    }

    public int sumNumbers(TreeNode root) {

        if (root == null) return 0;
        result = 0;
        dfs("", root);
        return result;
    }

}
