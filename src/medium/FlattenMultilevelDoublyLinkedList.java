package medium;

import java.util.ArrayList;
import java.util.List;

/*
    You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list.
    These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

    Flatten the list so that all the nodes appear in a single-level, doubly linked list.
    You are given the head of the first level of the list.
 */
public class FlattenMultilevelDoublyLinkedList {

    public static void main(String... args) {

        Node[] nodes = new Node[12];
        for (int i = 0; i < 12; i++) nodes[i] = new Node();
        nodes[0].next = nodes[1];nodes[0].val = 1;nodes[1].prev = nodes[0];
        nodes[1].next = nodes[2];nodes[1].val = 2;nodes[2].prev = nodes[1];
        nodes[2].next = nodes[3];nodes[2].child = nodes[6];nodes[2].val = 3;
        nodes[3].prev = nodes[2];nodes[3].next = nodes[4];nodes[3].val = 4;
        nodes[4].prev = nodes[3];nodes[4].next = nodes[5];nodes[4].val = 5;
        nodes[5].prev = nodes[4];nodes[5].val = 6;nodes[6].next = nodes[7];
        nodes[6].val = 7;nodes[7].prev = nodes[6];nodes[7].next = nodes[8];
        nodes[7].child = nodes[10];nodes[7].val = 8;nodes[8].prev = nodes[7];
        nodes[8].next = nodes[9];nodes[8].val = 9;nodes[9].prev = nodes[8];
        nodes[9].val = 10;nodes[10].next = nodes[11];nodes[10].val = 11;
        nodes[11].prev = nodes[10];nodes[11].val = 12;
        FlattenMultilevelDoublyLinkedList flattenMultilevelDoublyLinkedList = new FlattenMultilevelDoublyLinkedList();
        System.out.println(flattenMultilevelDoublyLinkedList.flatten(nodes[0]));
    }

    static class Node {

        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    private void dfs(Node node, List<Node> list) {

        if (node == null) return;
        list.add(node);
        if (node.child != null) dfs(node.child, list);
        if (node.next != null) dfs(node.next, list);
    }

    public Node flatten(Node head) {

        List<Node> list = new ArrayList<>();
        dfs(head, list);
        int n = list.size();
        if (n == 0) return null;
        for (Node node : list) node.child = null;
        for (int i = 0; i < n-1; i++) list.get(i).next = list.get(i+1);
        for (int i = 1; i < n; i++) list.get(i).prev = list.get(i-1);
        return list.get(0);
    }

}
