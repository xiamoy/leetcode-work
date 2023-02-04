package com.example.leetcode;

public class LeetCode_L213_HouseRobberII {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2}));//3
        System.out.println(rob(new int[]{1, 2, 3, 1}));//4
        System.out.println(rob(new int[]{1, 7, 9, 2}));//10

    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int firstHouseRes = rob(nums, 0, nums.length - 1, true);
        int secondHouseRes = rob(nums, 1, nums.length, false);
        return Math.max(firstHouseRes, secondHouseRes);

    }

    public static int rob(int[] nums, int start, int end, boolean first) {
        int[] dp = new int[2];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        int i = start + 2;
        for (; i < end; i++) {
            if (!first) {
                dp[(i - 1) % 2] = Math.max(dp[(i) % 2], dp[(i - 1) % 2] + nums[i]);
            } else {
                dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i]);
            }

        }

        return Math.max(dp[0], dp[1]);

    }

}
