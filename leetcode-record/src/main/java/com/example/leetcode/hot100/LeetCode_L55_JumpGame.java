package com.example.leetcode.hot100;

public class LeetCode_L55_JumpGame {
    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 0};
        System.out.println(canJump(nums));
    }

    //7ms,68.5MB
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        int last = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }
        return last <= 0;
    }
}
