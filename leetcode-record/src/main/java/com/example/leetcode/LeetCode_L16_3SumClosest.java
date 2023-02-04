package com.example.leetcode;

import java.util.Arrays;

public class LeetCode_L16_3SumClosest {
    public static void main(String[] args) {

//        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));//2
//        System.out.println(threeSumClosest(new int[]{0,0,0},1));//0

//        System.out.println(threeSumClosest(new int[]{0, 1, 2}, 0));//3
        System.out.println(threeSumClosest(new int[]{1, 1, 1, 0}, -100));//2
    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int[] res = new int[]{target > 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE};
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i, target, res);
            if (res[0] == target) {
                return target;
            }

        }
        return res[0];
    }

    public static void twoSum(int[] nums, int index, int target, int[] result) {
        int left = index + 1, right = nums.length - 1;
        while (left < right) {
            int sum = nums[index] + nums[left] + nums[right];
            if (sum == target) {
                result[0] = target;
                return;
            }
            if (Math.abs(sum - target) < Math.abs(result[0] - target)) {
                result[0] = sum;
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}
