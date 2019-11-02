package medium;

/*
    Given the root of a binary tree, each node has a value from 0 to 25 representing the letters
    'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.

    Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 */
public class SmallestStringStartingFromLeaf {

    private String min;
    private char[] a;

    public static void main(String... args) {

        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);
        SmallestStringStartingFromLeaf smallestStringStartingFromLeaf = new SmallestStringStartingFromLeaf();
        System.out.println(smallestStringStartingFromLeaf.smallestFromLeaf(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(String s, TreeNode root) {

        if (root.left == null && root.right == null) {

            String p = a[root.val] + s;
            if (min == null || p.compareTo(min) < 0) min = p;
            return;
        }

        if (root.left != null) dfs(a[root.val] + s, root.left);
        if (root.right != null) dfs(a[root.val] + s, root.right);
    }

    public String smallestFromLeaf(TreeNode root) {

        a = new char[26];
        for (int i = 0; i <= 25; i++) a[i] = (char) (i+97);
        min = null;
        dfs("", root);
        return min;
    }

}
