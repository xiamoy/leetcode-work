package com.example.leetcode;

import java.util.Arrays;

/**
 * 41 First Missing Positive
 *
 * @link https://leetcode.com/problems/first-missing-positive/
 */

public class LeetCode_L41_FirstMissingPositive {

    public static void main(String[] args) {
        Solution_L41 solutionL41 = new Solution_L41();
//        int[] nums = {1, 2, 0};// >3
//        int[] nums={7,8,9,11,12};// =>1
        int[] nums = {3, 4, -1, 1};// =>2

//        for (int i = 0; i < 20; i++) {
//            int[] generateNums = solutionL41.getGenerateNums(20, -10, 20);
//            int standard = solutionL41.standard(generateNums);
//            int missingPositive = solutionL41.firstMissingPositive(generateNums);
//            if (standard != missingPositive) {
//                SelfArrayUtils.printArr(generateNums);
//                System.out.println("Oops! standard:" + standard + ",self:" + missingPositive);
//            }
//        }

        System.out.println(solutionL41.firstMissingPositive(nums));

    }
}

class Solution_L41 {

    //TODO
    public int firstMissingPositive(int[] nums) {
        if (nums.length < 2) {
            if (nums.length == 0 || nums[0] < 1) {
                return 1;
            }
            return nums[0] == 1 ? nums[0] + 1 : Math.min(1,nums[0] - 1);
        }
        return firstMissingPositive(nums, nums.length - 1);

    }

    public int firstMissingPositive(int[] nums, int end) {
        if (end == 0) {
            if (nums[end] == 1) {
                return nums[end] + 1;
            } else if (nums[end] > 1) {
                return Math.min(1, nums[end] - 1);
            }
            return 1;
        }
        int res = firstMissingPositive(nums, end - 1);
        if (nums[end] == res) {
            res++;
        }
        return res;
    }

    public int standard(int[] arr) {
        Arrays.sort(arr);
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length && arr[i] > 0; i++) {// 1,2,3,4
            if (res + 1 == arr[i]) {
                res = arr[i];
            } else {
                if (arr[i] - 1 > 0) {
                    return arr[i] - 1;
                }
            }

        }
        return res == 0 ? 1 : res;
    }

    public int[] getGenerateNums(int maxSize, int minVal, int maxVal) {
        int size = (int) (Math.random() * (maxSize + 1));
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * (maxVal - minVal + 1)) + minVal;
        }
        return arr;

    }
}
