package com.example.leetcode.hot100;

public class LeetCode_L152_MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int maxProduct = maxProduct(nums);
        System.out.println(maxProduct);//6

        int[] nums2 = {-2, 0, -1};
        int maxProduct2 = maxProduct(nums2);
        System.out.println(maxProduct2);//0


    }

    // https://leetcode.com/problems/maximum-product-subarray/discuss/1608862/JAVA-or-3-Solutions-or-Detailed-Explanation-Using-Image
    public static int maxProduct(int[] nums) {
        int left = 1, right = 1;
        int result = nums[0];
        int len = nums.length;

        for (int i = 0; i < len; i++) {

            left = left == 0 ? 1 : left;
            right = right == 0 ? 1 : right;

            left *= nums[i];
            right *= nums[len - i - 1];

            int max = Math.max(left, right);
            result = Math.max(result, max);
        }
        return result;
    }


    public static int maxProduct2(int[] nums) {
        int result = nums[0];
        int preMax = nums[0], preMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int nowMax = preMax * nums[i];
            int nowMin = preMin * nums[i];
            preMax = Math.max(Math.max(nowMax, nowMin), nums[i]);
            preMin = Math.min(Math.min(nowMax, nowMin), nums[i]);
            result = Math.max(preMax, result);
        }
        return result;

    }
}
