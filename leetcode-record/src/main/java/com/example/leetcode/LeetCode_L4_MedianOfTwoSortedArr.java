package com.example.leetcode;




/**
 * Media Of Two sorted arrays
 *
 * @link https://leetcode.com/problems/two-sum/
 */
public class LeetCode_L4_MedianOfTwoSortedArr {
    public static void main(String[] args) {


    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length+nums2.length];
        int left=0,right=0;
        int index=0;
        while(left<nums1.length && right<nums2.length){
            if(nums1[left] <=nums2[right] && left<nums1.length){
                arr[index++] =  nums1[left++];
            }
            if(left<nums1.length){
                while(nums1[left] > nums2[right]&& right<nums2.length){
                    arr[index++] =  nums2[right++];
                }
            }

        }

        while(left<nums1.length){
            arr[index++] = nums1[left++];
        }
        while(right<nums2.length){
            arr[index++] = nums2[right++];
        }
        int medi = arr.length/2 ;
        if(arr.length%2==0){

            return (arr[medi-1]+arr[medi])/2;
        }
        return arr[medi];

    }
}


