package com.example.leetcode.hot100;

public class LeetCode_L75_SortColors {
    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(nums);
    }

    //5ms, 42.5MB
    public static void sortColors2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    //1ms, 42.5MB
    //l为0的左开边界，r为2的右开边界
    public static void sortColors(int[] nums) {
        int r = nums.length - 1;
        int l = 0;
        for (int i = 0; i <= r; ) {
            if (nums[i] == 2) {
                swap(nums, i, r--);
            } else if (nums[i] == 0) {
                swap(nums, i++, l++);
            } else {
                i++;
            }
        }
        System.out.println();
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
