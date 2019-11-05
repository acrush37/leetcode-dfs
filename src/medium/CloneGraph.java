package medium;

import java.util.*;
import java.util.stream.Collectors;

/*
    Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
    Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 */
public class CloneGraph {

    private int size;
    private List<Node> list;
    private Map<Node, Integer> map;
    private Map<Node, Boolean> t;

    public static void main(String... args) {

        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        node1.val = 1;
        node2.val = 2;
        node3.val = 3;
        node4.val = 4;
        node5.val = 5;
        node1.neighbors = Arrays.asList(node2, node3);
        node2.neighbors = Arrays.asList(node1, node4, node5);
        node3.neighbors = Arrays.asList(node1);
        node4.neighbors = Arrays.asList(node2);
        node5.neighbors = Arrays.asList(node2);
        CloneGraph cloneGraph = new CloneGraph();
        System.out.println(cloneGraph.cloneGraph(node1));
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private void dfs(Node node) {

        if (map.containsKey(node)) return;
        map.put(node, size++);
        list.add(new Node(node.val, node.neighbors));
        List<Node> neighbors = node.neighbors;
        if (neighbors != null) for (Node n : neighbors) dfs(n);
    }

    private void dfs1(Node node) {

        if (t.containsKey(node)) return;
        t.put(node, true);
        List<Node> nodes = node.neighbors;
        if (nodes == null) return;
        list.get(map.get(node)).neighbors = nodes.stream().map(i -> list.get(map.get(i))).collect(Collectors.toList());
        nodes.forEach(i -> dfs1(i));
    }

    public Node cloneGraph(Node node) {

        if (node == null) return null;
        map = new HashMap<>();
        list = new ArrayList<>();
        t = new HashMap<>();
        size = 0;
        dfs(node);
        dfs1(node);
        return list.get(0);
    }

}
