package com.example.leetcode.hot100;

public class LeetCode_L283_MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);

    }

    //2ms, 54.6MB
    public static void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int left = -1, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[++left] = nums[right++];
            } else {
                right++;
            }
        }
        for (int i = left + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(nums);
    }
}
