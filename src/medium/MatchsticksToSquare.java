package medium;

import java.util.*;

/*
    Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has,
    please find out a way you can make one square by using up all those matchsticks.
    You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

    Your input will be several matchsticks the girl has, represented with their stick length. Your output will either
    be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
 */
public class MatchsticksToSquare {

    private int n;
    private int sum;
    private boolean result;
    private Set<String> set;
    private Map<Integer, Integer> map;

    public static void main(String... args) {

        int[] nums = {1, 1, 2, 2, 2};
        MatchsticksToSquare matchsticksToSquare = new MatchsticksToSquare();
        System.out.println(matchsticksToSquare.makesquare(nums));
    }

    private boolean find(int s, int k, int[] nums) {

        if (s == 0) return true;
        if (k < 0 || nums[k] > s) return false;
        return find(s - nums[k], k - 1, nums) || find(s, k - 1, nums);
    }

    private int[] build(List<Integer> list) {

        Map<Integer, Integer> m = new HashMap<>();
        m.putAll(map);
        list.forEach(i -> m.put(i, m.get(i) - 1));
        int[] a = new int[n-list.size()];
        int i = 0;

        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {

            int key = entry.getKey();
            int value = entry.getValue();
            for (int j = 0; j < value; j++) a[i++] = key;
        }

        return a;
    }

    private void dfs(int s, int k, int[] nums, List<Integer> list) {

        if (result) return;

        if (s == 0) {

            String combine = list.toString();
            if (set.contains(combine)) return;
            set.add(combine);
            int size = list.size();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) arr[i] = list.get(i);
            if (!find(sum >> 1, size-1, arr)) return;
            int[] other = build(list);
            if (find(sum >> 1, other.length-1, other)) result = true;
            return;
        }

        if (k < 0 || nums[k] > s) return;
        list.add(nums[k]);
        dfs(s - nums[k], k - 1, nums, list);
        list.remove(list.size()-1);
        dfs(s, k-1, nums, list);
    }

    public boolean makesquare(int[] nums) {

        n = nums.length;
        if (n < 4) return false;
        sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 3) != 0) return false;
        sum >>= 1;
        Arrays.sort(nums);
        if (nums[n-1] > sum >> 1) return false;
        result = false;
        if (!find(sum, n-1, nums)) return false;
        set = new HashSet<>();
        map = new HashMap<>();

        for (int num : nums) {

            Integer x = map.get(num);
            map.put(num, x == null ? 1 : x+1);
        }

        dfs(sum, n-1, nums, new ArrayList<>());
        return result;
    }

}
