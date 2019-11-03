package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Given a binary tree, flatten it to a linked list in-place.
 */
public class FlattenBinaryTreeToLinkedList {

    private List<Integer> list;

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
        flattenBinaryTreeToLinkedList.flatten(root);
        System.out.println(root);
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(TreeNode root) {

        list.add(root.val);
        if (root.left != null) dfs(root.left);
        if (root.right != null) dfs(root.right);
    }

    private void build(int k, TreeNode root) {

        if (k == list.size()) return;
        root.left = null;
        root.right = new TreeNode(list.get(k));
        build(k+1, root.right);
    }

    public void flatten(TreeNode root) {

        if (root == null) return;
        list = new ArrayList<>();
        dfs(root);
        build(1, root);
    }

}
