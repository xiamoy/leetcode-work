package com.example.leetcode.hot100;

import java.util.Arrays;

public class LeetCode_L581_ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int res = findUnsortedSubarray(nums);//0
        System.out.println(res);
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));//5
    }

    public static int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int left = -1, right = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[len - 1 - i], min);
            if (nums[i] < max) {
                left = i;
            }
            if (nums[len - 1 - i] > min) {
                right = len - 1 - i;
            }
        }
        return left - right + 1;
    }

    public static int findUnsortedSubarray2(int[] nums) {

        int len = nums.length;
        int[] copyNums = Arrays.copyOf(nums, len);
        Arrays.sort(copyNums);
        int count = len;
        int begin = 0, end = len - 1;
        boolean startFlag = true, endFlag = true;
        while ((startFlag || endFlag) && begin <= end) {

            if (startFlag && (copyNums[begin] == nums[begin])) {
                count--;
                begin++;
            } else {
                startFlag = false;
            }

            if (endFlag && begin <= end && (copyNums[end] == nums[end])) {
                count--;
                end--;
            } else {
                endFlag = false;
            }

        }

        return count;

    }
}
