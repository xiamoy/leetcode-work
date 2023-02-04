package com.example.leetcode.hot100;

public class LeetCode_L31_NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 8, 4, 7, 6, 5, 3, 1};// right to left, keep ascending

        int[] nums1 = new int[]{1, 1, 5};
        nextPermutation(nums1);
        System.out.println(nums1);//1,5,1

    }

    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int right = i + 1;
            while (right < nums.length && nums[right] > nums[i]) {
                right++;
            }
            right--;
            swap(nums, i, right);

        }
        int begin = i + 1, end = nums.length - 1;
        while (begin < end) {
            swap(nums, begin, end);
            begin++;
            end--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
