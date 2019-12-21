package medium;

/*
    On a 2D plane, we place stones at some integer coordinate points.
    Each coordinate point may have at most one stone.

    Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

    What is the largest possible number of moves we can make?
 */
public class MostStonesRemovedWithSameRowOrColumn {

    public static void main(String... args) {

        int[][] stones = {{0, 1}, {1, 0}, {1, 1}};
        MostStonesRemovedWithSameRowOrColumn mostStonesRemovedWithSameRowOrColumn = new MostStonesRemovedWithSameRowOrColumn();
        System.out.println(mostStonesRemovedWithSameRowOrColumn.removeStones(stones));
    }

    private void dfs(int n, int x, int[][] stones, boolean[] t) {

        t[x] = true;

        for (int i = 0; i < n; i++)
            if (!t[i] && (stones[x][0] == stones[i][0] || stones[x][1] == stones[i][1]))
                dfs(n, i, stones, t);
    }

    public int removeStones(int[][] stones) {

        int count = 0, n = stones.length;
        boolean[] t = new boolean[n];

        for (int i = 0; i < n; i++)
            if (!t[i]) {
                count++;
                dfs(n, i, stones, t);
            }

        return n - count;
    }

}
