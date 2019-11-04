package medium;

/*
    The thief has found himself a new place for his thievery again.
    There is only one entrance to this area, called the "root."
    Besides the root, each house has one and only one parent house.
    After a tour, the smart thief realized that "all houses in this place forms a binary tree".
    It will automatically contact the police if two directly-linked houses were broken into on the same night.

    Determine the maximum amount of money the thief can rob tonight without alerting the police.
 */
public class HouseRobberIII {

    public static void main(String... args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(7);
        HouseRobberIII houseRobberIII = new HouseRobberIII();
        System.out.println(houseRobberIII.rob(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rob(TreeNode root) {

        if (root == null) return 0;
        int left = 0, right = 0;
        int sum = root.val;

        if (root.left != null) {

            left = rob(root.left);
            if (root.left.left != null) sum += root.left.left.val;
            if (root.left.right != null) sum += root.left.right.val;
        }

        if (root.right != null) {

            right = rob(root.right);
            if (root.right.left != null) sum += root.right.left.val;
            if (root.right.right != null) sum += root.right.right.val;
        }

        root.val = Math.max(left + right, sum);
        return root.val;
    }

}
