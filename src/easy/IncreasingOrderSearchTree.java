package easy;

import java.util.ArrayList;
import java.util.List;

/*
    Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the
    tree is now the root of the tree, and every node has no left child and only 1 right child.
 */
public class IncreasingOrderSearchTree {

    public static void main(String... args) {

        TreeNode[] nodes = new TreeNode[10];
        for (int i = 1; i <= 9; i++) nodes[i] = new TreeNode(i);
        nodes[5].left = nodes[3];
        nodes[5].right = nodes[6];
        nodes[3].left = nodes[2];
        nodes[3].right = nodes[4];
        nodes[2].left = nodes[1];
        nodes[6].right = nodes[8];
        nodes[8].left = nodes[7];
        nodes[8].right = nodes[9];
        IncreasingOrderSearchTree increasingOrderSearchTree = new IncreasingOrderSearchTree();
        System.out.println(increasingOrderSearchTree.increasingBST(nodes[5]));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
          val = x;
      }
    }

    private void dfs(TreeNode root, List<Integer> list) {

        if (root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    public TreeNode increasingBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        TreeNode node = new TreeNode(list.get(0));
        TreeNode node1 = node;

        for (int i = 1; i < list.size(); i++) {
            node.right = new TreeNode(list.get(i));
            node = node.right;
        }

        return node1;
    }

}
