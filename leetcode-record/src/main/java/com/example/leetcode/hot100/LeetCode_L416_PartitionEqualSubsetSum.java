package com.example.leetcode.hot100;

public class LeetCode_L416_PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));//true
        System.out.println(canPartition(new int[]{1, 2, 3, 5}));//false

    }

    //66ms, 53.9MB
    public static boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (nums.length < 2 || sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int len = nums.length;
        boolean[][] dp = new boolean[len][target + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (!dp[i][j] && j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[len - 1][target];
    }

    public static boolean canPartition1(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length + 1][target + 1];

        return backtrack(0, nums, target, dp);
    }

    public static boolean backtrack(int begin, int[] nums, int target, Boolean[][] dp) {

        if (begin >= nums.length || target < 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }
        if (dp[begin][target] != null) {
            return dp[begin][target];
        }

        dp[begin][target] = backtrack(begin + 1, nums, target, dp) || backtrack(begin + 1, nums, target - nums[begin], dp);

        return dp[begin][target];


    }
}
