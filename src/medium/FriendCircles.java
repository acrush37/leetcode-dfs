package medium;

import java.util.HashSet;
import java.util.Set;

/*
    There are N students in a class. Some of them are friends, while some are not.
    Their friendship is transitive in nature.
    For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C.
    And we defined a friend circle is a group of students who are direct or indirect friends.

    Given a N*N matrix M representing the friend relationship between students in the class.
    If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not.
    And you have to output the total number of friend circles among all the students.
 */
public class FriendCircles {

    private boolean[] t;
    private Set<Integer>[] f;

    public static void main(String... args) {

        int[][] M = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        FriendCircles friendCircles = new FriendCircles();
        System.out.println(friendCircles.findCircleNum(M));
    }

    private void dfs(int n) {

        if (t[n]) return;
        t[n] = true;
        for (int i : f[n]) dfs(i);
    }

    public int findCircleNum(int[][] M) {

        int n = M.length;
        if (n == 1) return 1;
        t = new boolean[n];
        f = new Set[n];
        int count = 0;

        for (int i = 0; i < n; i++) {

            f[i] = new HashSet<>();

            for (int j = 0; j < n; j++)
                if (M[i][j] == 1)
                    f[i].add(j);
        }

        for (int i = 0; i < n; i++)
            if (!t[i]) {
                dfs(i);
                count++;
            }

        return count;
    }

}
