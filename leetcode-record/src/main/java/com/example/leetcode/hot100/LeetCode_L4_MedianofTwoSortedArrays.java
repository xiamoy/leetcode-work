package com.example.leetcode.hot100;

public class LeetCode_L4_MedianofTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);//2.5

        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4, 5, 6}));//

    }

    //4ms, 50MB
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        double leftVal = findKthMinInArrays(nums1, nums2, 0, 0, left);
        double rightVal = findKthMinInArrays(nums1, nums2, 0, 0, right);
        return (leftVal + rightVal) / 2;
    }

    public static double findKthMinInArrays(int[] nums1, int[] nums2, int start1, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int mid1 = start1 + Math.min(nums1.length, k / 2) - 1;
        int mid2 = start2 + Math.min(nums2.length, k / 2) - 1;
        if (nums1[mid1] < nums2[mid2]) {
            return findKthMinInArrays(nums1, nums2, mid1 + 1, start2, k - Math.min(nums1.length, k / 2));
        }
        return findKthMinInArrays(nums1, nums2, start1, mid2 + 1, k - Math.min(nums2.length, k / 2));

    }


    //3ms, 49.5MB
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        if ((m + n) % 2 == 0) {
            double leftOne = findKthInSortedArrays(nums1, nums2, 0, 0, (m + n) / 2);//2
            double rightOne = findKthInSortedArrays(nums1, nums2, 0, 0, (m + n) / 2 + 1);//3
            return (leftOne + rightOne) / 2;
        }
        return findKthInSortedArrays(nums1, nums2, 0, 0, (m + n) / 2 + 1);

    }


    public static double findKthInSortedArrays(int[] nums1, int[] nums2, int aBegin, int bBegin, int k) {
        if (aBegin >= nums1.length) {
            return nums2[bBegin + k - 1];
        }
        if (bBegin >= nums2.length) {
            return nums1[aBegin + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[aBegin], nums2[bBegin]);
        }
        int aMid = aBegin - 1 + k / 2;
        int bMid = bBegin - 1 + k / 2;
        int aVal = aMid >= nums1.length ? Integer.MAX_VALUE : nums1[aMid];
        int bVal = bMid >= nums2.length ? Integer.MAX_VALUE : nums2[bMid];

        if (aVal <= bVal) {
            return findKthInSortedArrays(nums1, nums2, aMid + 1, bBegin, k - k / 2);
        }
        return findKthInSortedArrays(nums1, nums2, aBegin, bMid + 1, k - k / 2);
    }

}
