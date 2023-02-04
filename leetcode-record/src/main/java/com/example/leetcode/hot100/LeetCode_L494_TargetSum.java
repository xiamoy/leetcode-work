package com.example.leetcode.hot100;

public class LeetCode_L494_TargetSum {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int targetSumWays = findTargetSumWays(nums, 3);//5
        System.out.println(targetSumWays);
    }


    // recursive
    public static int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, target, nums.length - 1);
    }

    public static int findTargetSumWays(int[] nums, int target, int end) {
        if (end < 0) {
            return 0;
        }
        if (end == 0) {
            int count = 0;
            if (nums[end] == target) {
                count++;
            }
            if (nums[end] + target == 0) {
                count++;
            }
            return count;
        }

        int curPlusCount = findTargetSumWays(nums, target - nums[end], end - 1);
        int curSubCount = findTargetSumWays(nums, target + nums[end], end - 1);
        return curPlusCount + curSubCount;
    }


}
