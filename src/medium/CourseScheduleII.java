package medium;

import java.util.*;

/*
    There are a total of n courses you have to take, labeled from 0 to n-1.

    Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

    Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

    There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 */
public class CourseScheduleII {

    public static void main(String... args) {

        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        System.out.println(courseScheduleII.findOrder(4, prerequisites));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int z = 0;
        int[] path = new int[numCourses];
        int[] in = new int[numCourses];
        Set<Integer>[] s = new Set[numCourses];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) s[i] = new HashSet<>();

        for (int[] p : prerequisites) {

            in[p[0]]++;
            s[p[1]].add(p[0]);
        }

        for (int i = 0; i < numCourses; i++) if (in[i] == 0) q.offer(i);

        while (!q.isEmpty()) {

            int x = q.poll();
            path[z++] = x;
            for (int y : s[x]) if (--in[y] == 0) q.offer(y);
        }

        return z == numCourses ? path : new int[0];
    }

}
