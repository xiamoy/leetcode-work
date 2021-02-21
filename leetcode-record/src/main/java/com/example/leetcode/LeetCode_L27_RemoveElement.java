package com.example.leetcode;

/**
 * 27.  Remove Element
 * @link https://leetcode.com/problems/remove-element/
 */
public class LeetCode_L27_RemoveElement {
    public static void main(String[] args) {
        Solution_L27 solution_l27 = new Solution_L27();
//        int arr[]={3,2,2,3};
//        int val=3;
        int arr[] = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

//        int arr[] = {1};
//        int val = 1;
//        int arr[] = {2};
//        int val = 3;
//        int arr[] = {};
//        int val = 2;

//        int arr[] = {3,3};
//        int val = 3;

//        int arr[] = {1,2};
//        int val = 3;
        int len = solution_l27.removeElement_o2(arr, val);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }
}

class Solution_L27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length<2){
            return (nums.length==0 || nums[0]==val)?0:1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            while (left< nums.length && nums[left] != val) {
                left++;
            }
            while (right>=0 && nums[right] == val) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

    //simple
    int removeElement_o1(int A[], int n, int elem) {
        int begin=0;
        for(int i=0;i<n;i++) {
            if(A[i]!=elem) {
                A[begin++]=A[i];
            }
        }
        return begin;
    }

    int removeElement_o2(int A[], int elem) {
        int begin=0,end=A.length-1;
        while (begin<=end){
            if (A[begin] == elem){
                A[begin]=A[end];
                end--;
            }else{
                begin++;
            }
        }
        return begin;
    }
}
