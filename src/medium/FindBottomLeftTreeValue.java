package medium;

/*
    Given a binary tree, find the leftmost value in the last row of the tree.
 */
public class FindBottomLeftTreeValue {

    private int max;
    private int result;

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        FindBottomLeftTreeValue findBottomLeftTreeValue = new FindBottomLeftTreeValue();
        System.out.println(findBottomLeftTreeValue.findBottomLeftValue(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(int k, TreeNode root) {

        if (root.left == null) {

            if (root.right != null) {
                dfs(k+1, root.right);
            } else if (k > max) {

                max = k;
                result = root.val;
            }

            return;
        }

        if (root.right == null) dfs(k+1, root.left);
        else {
            dfs(k+1, root.left);
            dfs(k+1, root.right);
        }
    }

    public int findBottomLeftValue(TreeNode root) {

        max = 0;
        result = root.val;
        dfs(0, root);
        return result;
    }

}
