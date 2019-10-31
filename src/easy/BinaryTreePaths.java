package easy;

import java.util.ArrayList;
import java.util.List;

/*
    Given a binary tree, return all root-to-leaf paths.
 */
public class BinaryTreePaths {

    private List<String> list;

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        System.out.println(binaryTreePaths.binaryTreePaths(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(String s, TreeNode root) {

        if (root == null) {

            list.add(s);
            return;
        }

        if (root.left == null) {

            if (root.right == null) {

                list.add(s);
                return;
            }

            dfs(s + "->" + root.right.val, root.right);
            return;
        }

        if (root.right == null) dfs(s + "->" + root.left.val, root.left);
        else {
            dfs(s + "->" + root.left.val, root.left);
            dfs(s + "->" + root.right.val, root.right);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {

        list = new ArrayList<>();
        if (root == null) return list;
        dfs(root.val + "", root);
        return list;
    }

}
