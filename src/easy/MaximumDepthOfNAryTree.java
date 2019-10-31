package easy;

import java.util.Arrays;
import java.util.List;

/*
    Given a n-ary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfNAryTree {

    public static void main(String... args) {

        Node root5 = new Node(5, null);
        Node root6 = new Node(6, null);
        Node root2 = new Node(2, null);
        Node root4 = new Node(4, null);
        Node root3 = new Node(3, Arrays.asList(root5, root6));
        Node root1 = new Node(1, Arrays.asList(root3, root2, root4));
        MaximumDepthOfNAryTree maximumDepthOfNAryTree = new MaximumDepthOfNAryTree();
        System.out.println(maximumDepthOfNAryTree.maxDepth(root1));
    }

    static class Node {

        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private int dfs(Node root) {

        if (root == null) return 0;
        List<Node> nodes = root.children;
        int max = 0;

        if (nodes != null)
            for (Node node : nodes)
                max = Math.max(max, dfs(node));

        return max+1;
    }

    public int maxDepth(Node root) {
        return dfs(root);
    }

}
