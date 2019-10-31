package easy;

import java.util.List;

/*
    Given a n-ary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfNAryTree {

    public static void main(String... args) {

        MaximumDepthOfNAryTree maximumDepthOfNAryTree = new MaximumDepthOfNAryTree();
        System.out.println(maximumDepthOfNAryTree.maxDepth(null));
    }

    class Node {

        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        return 0;
    }

}
