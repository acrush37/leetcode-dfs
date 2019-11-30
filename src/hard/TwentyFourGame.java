package hard;

/*
    You have 4 cards each containing a number from 1 to 9.

    You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.
 */
public class TwentyFourGame {

    private boolean flag;

    private double zero = 0.00000001;

    public static void main(String... args) {

        int[] nums = {4, 1, 8, 7};
        TwentyFourGame twentyFourGame = new TwentyFourGame();
        System.out.println(twentyFourGame.judgePoint24(nums));
    }

    private void dfs(int k, double s, int[] nums, boolean[] t) {

        if (k == 3) {
            if (Math.abs(s-24) < zero) flag = true;
            return;
        }

        for (int i = 0; i < 4; i++)
            if (!t[i]) {

                t[i] = true;
                dfs(k+1, s + nums[i], nums, t);
                if (flag) return;
                dfs(k+1, s - nums[i], nums, t);
                if (flag) return;
                dfs(k+1, nums[i]- s, nums, t);
                if (flag) return;
                dfs(k+1, s * nums[i], nums, t);
                if (flag) return;
                dfs(k+1, s / nums[i], nums, t);
                if (flag) return;
                if (Math.abs(s) > zero) dfs(k+1, nums[i] / s, nums, t);
                if (flag) return;
                t[i] = false;
            }
    }

    public boolean judgePoint24(int[] nums) {

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (i != j)
                    for (int k = 0; k < 4; k++)
                        if (k != i && k != j)
                            for (int p = 0; p < 4; p++)
                                if (p != i && p != j && p != k) {

                                    if (Math.abs((nums[i] - nums[j]) * (nums[k] - nums[p]) - 24) < zero) return true;
                                    if (Math.abs((nums[i] - nums[j]) * (nums[k] + nums[p]) - 24) < zero) return true;
                                    if (Math.abs((nums[i] + nums[j]) * (nums[k] - nums[p]) - 24) < zero) return true;
                                    if (Math.abs((nums[i] + nums[j]) * (nums[k] + nums[p]) - 24) < zero) return true;
                                    if (Math.abs((nums[i] * nums[j]) - (nums[k] * nums[p]) - 24) < zero) return true;
                                    if (Math.abs((nums[i] * nums[j]) + (nums[k] * nums[p]) - 24) < zero) return true;
                                    if (Math.abs((nums[i] * nums[j]) + (nums[k] * 1.0 / nums[p]) - 24) < zero) return true;
                                    if (Math.abs((nums[i] * nums[j]) - (nums[k] * 1.0 / nums[p]) - 24) < zero) return true;
                                }

        for (int i = 0; i < 4; i++) {

            boolean[] t = new boolean[4];
            t[i] = true;
            dfs(0, nums[i], nums, t);
            if (flag) return true;
        }

        return false;
    }

}
