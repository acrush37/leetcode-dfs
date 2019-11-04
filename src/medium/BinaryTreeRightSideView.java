package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Given a binary tree, imagine yourself standing on the right side of it,
    return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {

    private List<Integer> result;

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        System.out.println(binaryTreeRightSideView.rightSideView(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(int k, TreeNode root) {

        if (root == null) return;

        if (result.size() > k) result.set(k, root.val);
        else result.add(root.val);

        dfs(k+1, root.left);
        dfs(k+1, root.right);
    }

    public List<Integer> rightSideView(TreeNode root) {

        result = new ArrayList<>();
        dfs(0, root);
        return result;
    }

}
