package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class LeetCode_QTMn0o {
    public static void main(String[] args) {
//        System.out.println(subarraySum(new int[]{1, 2, 3}, 3)); // 2
//        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));  // 2
//        System.out.println(subarraySum(new int[]{-1, -1, 1}, 0));  // 1
        System.out.println(subarraySum(new int[]{1}, 1));  // 1
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));  // 3

    }

    // only positive integers for slide window
    public static int subarraySum2(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 0, right = 0;
        int count = 0;
        int sum = 0;
        for (; right < nums.length; right++) {
            sum += nums[right];
            while (left < right && sum > k) {
                sum -= nums[left++];
            }
            if (sum == k) {
                count++;
            }
        }
        return count;
    }

    //前缀和
    // [j,i]为 和为k的子数组
    // nums[0]+...+nums[j-1] = sum-k
    public static int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;

    }
}
