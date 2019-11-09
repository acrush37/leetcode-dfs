package medium;

/*
    Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array
    that is constructed by these N numbers successfully if one of the following is true
    for the ith position (1 <= i <= N) in this array:

    The number at the ith position is divisible by i.
    i is divisible by the number at the ith position.


    Now given N, how many beautiful arrangements can you construct?
 */
public class BeautifulArrangement {

    private int result = 0;

    public static void main(String... args) {

        BeautifulArrangement beautifulArrangement = new BeautifulArrangement();
        System.out.println(beautifulArrangement.countArrangement(2));
    }

    private void dfs(int k, int n, boolean[] t) {

        if (k == n+1) {

            result++;
            return;
        }

        for (int i = 1; i <= n; i++)
            if (!t[i] && (i % k == 0 || k % i == 0)) {

                t[i] = true;
                dfs(k+1, n, t);
                t[i] = false;
            }
    }

    public int countArrangement(int N) {

        dfs(1, N, new boolean[N+1]);
        return result;
    }

}
