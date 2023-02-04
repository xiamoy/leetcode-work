package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_L15_3Sum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));

    }

    //39ms, 58.7MB
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();


        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            twoSum(nums, i, result);
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    public static void twoSum(int[] nums, int i, List<List<Integer>> list) {
        int left = i + 1, right = nums.length - 1;

        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                while (left + 1 < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (left < right - 1 && nums[right] == nums[right - 1]) {
                    right--;
                }
                left++;
                right--;
            }
        }
    }

    //25ms,46.3MB
    public static List<List<Integer>> threeSum2(int[] nums) {
        if (nums.length < 3) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return list;
        }
        for (int i = 0; i < nums.length - 2; ) {
            twoSum(nums, i, list);
            int temp = nums[i];
            while (temp == nums[i] && i < nums.length - 1) {
                i++;
            }


        }
        return list;

    }

    public void twoSum2(int[] nums, int i, List<List<Integer>> list) {
        int left = i + 1, right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum == 0) {
                list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                int tempLeft = nums[left];
                while (tempLeft == nums[left] && left < right) {
                    left++;
                }

            } else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

    }
}
