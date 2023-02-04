package com.example.leetcode.hot100;

public class LeetCode_L53_MaximumSubarray {
    public static void main(String[] args) {

//        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
//        int i = maxSubArray(nums);
//        System.out.println(i); //6

        int[] nums = {5, 4, -1, 7, 8};
        int i = maxSubArray(nums);
        System.out.println(i);//23
    }

    //动态规划
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];// dp[i]:以i结尾的最长子数组和
        for (int i = 1; i < len; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
