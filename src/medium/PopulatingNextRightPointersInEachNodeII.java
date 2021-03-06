package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Populate each next pointer to point to its next right node.
    If there is no next right node, the next pointer should be set to NULL.

    Initially, all next pointers are set to NULL.
 */
public class PopulatingNextRightPointersInEachNodeII {

    private List<Node> list;

    public static void main(String... args) {

        Node node7 = new Node(7, null, null, null);
        Node node3 = new Node(3, null, node7, null);
        Node node5 = new Node(5, null, null, node7);
        Node node4 = new Node(4, null, null, node5);
        Node node2 = new Node(2, node4, node5, node3);
        Node node1 = new Node(1, node2, node3, null);
        PopulatingNextRightPointersInEachNodeII populatingNextRightPointersInEachNodeII = new PopulatingNextRightPointersInEachNodeII();
        System.out.println(populatingNextRightPointersInEachNodeII.connect(node1));
    }

    static class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    private void dfs(int k, Node root) {

        if (root == null) return;

        if (list.size() > k) {

            list.get(k).next = root;
            list.set(k, root);
        } else {
            list.add(root);
        }

        dfs(k+1, root.left);
        dfs(k+1, root.right);
    }

    public Node connect(Node root) {

        list = new ArrayList<>();
        dfs(0, root);
        return root;
    }

}
