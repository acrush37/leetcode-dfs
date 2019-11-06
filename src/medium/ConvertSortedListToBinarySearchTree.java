package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class ConvertSortedListToBinarySearchTree {

    public static void main(String... args) {

        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        ConvertSortedListToBinarySearchTree convertSortedListToBinarySearchTree = new ConvertSortedListToBinarySearchTree();
        System.out.println(convertSortedListToBinarySearchTree.sortedListToBST(node1));
    }

    static class ListNode {

        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode dfs(int[] a) {

        int n = a.length;
        if (n == 0) return null;
        int m = n >> 1;
        TreeNode node = new TreeNode(a[m]);
        node.left = dfs(Arrays.copyOfRange(a, 0, m));
        node.right = dfs(Arrays.copyOfRange(a, m+1, n));
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) return null;
        List<Integer> list = new ArrayList<>();

        while (head != null) {

            list.add(head.val);
            head = head.next;
        }

        return dfs(list.stream().mapToInt(i -> i).toArray());
    }

}
