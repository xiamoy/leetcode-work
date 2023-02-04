package com.example.leetcode.hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_L128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int i = longestConsecutive(nums);
        System.out.println(i);//4, [1,2,3,4]
    }

    public static int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            } else {
                // duplicates
                continue;
            }
        }
        return res;
    }

    public static int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int res = 0;
        for (int x : set) {
            int cur = x;
            if (!set.contains(cur + 1)) {
                int left = cur - 1;
                while (set.contains(left)) {
                    left--;
                }
                res = Math.max(res, cur - left);
            }
        }
        return res;

    }
}
