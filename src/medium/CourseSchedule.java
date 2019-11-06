package medium;

import java.util.*;

/*
    There are a total of n courses you have to take, labeled from 0 to n-1.

    Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

    Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 */
public class CourseSchedule {

    public static void main(String... args) {

        int[][] prerequisites1 = {{1, 0}};
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.canFinish(2, prerequisites1));
        System.out.println(courseSchedule.canFinish(2, prerequisites2));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] in = new int[numCourses];
        Set<Integer>[] s = new Set[numCourses];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) s[i] = new HashSet<>();

        for (int[] p : prerequisites) {

            in[p[0]]++;
            s[p[1]].add(p[0]);
        }

        for (int i = 0; i < numCourses; i++) if (in[i] == 0) q.offer(i);

        while (!q.isEmpty()) {

            int x = q.poll();
            path.add(x);
            for (int y : s[x]) if (--in[y] == 0) q.offer(y);
        }

        return path.size() == numCourses;
    }

}
