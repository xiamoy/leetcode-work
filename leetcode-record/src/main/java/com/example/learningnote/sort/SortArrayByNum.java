package com.example.learningnote.sort;

import static com.example.SelfArrayUtils.*;

/**
 * Description:
 * 给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，大于num的数放在数组的右边。
 * 要求额外空间复杂度O(1)，时间复杂度O(N)
 */

public class SortArrayByNum {
    public static void main(String[] args) {
        int[] array = {16, 22, 15, 22, 26, 22, 4, 1, 7, 1, 9, 7, 8, 26};
        int num = 16;
//        sort_self(array, num);
//        testSort(array, num);
//        printArr(array);

        int minVal = 1, maxVal = 30, maxSize = 15;

        for(int i=0;i<5000000;i++) {
            int[] arr = generateArr(5,maxSize,minVal,maxVal);
            int target =(int)(Math.random() * (maxVal - minVal + 1))  + minVal;
//            sort(arr,target);
//            sort_self(arr,target);
            sort_self_p2(arr,target);
            testSort(arr,target);
        }
    }

    //passed
    public static void sort_self(int[] arr, int target) {

        int left = 0, right = arr.length - 1;
        int index = 0;

        while (index <= right) {
            if (arr[left] <= target) { //只有在未找到第一个大于target之前的数有意义，
                // 在确定left所在位置的值是大于target之后，不再需要该判断
                left++;
                index++;
            } else if (arr[index] <= target) {
                swap(arr, left++, index++);
            } else {
                index++;
            }

        }
    }

    //优化:确定第一个>target的位置，开始往后找
    public static void sort_self_p2(int[] arr, int target) {

        int left = 0, right = arr.length - 1;
        int index = 0;
        while (index <= right && arr[left] <= target) {
            left++;
            index++;
        }
        //确保以left位置上的数为界，之前的值都是<target，left~index-1上的都是>target
        while (index <= right) {
            if (arr[index] <= target) {
                swap(arr, left++, index++);
            } else {
                index++;
            }

        }
    }

    //始终保持0~left为小于target,避免0位置上的特殊处理，left从-1开始，
    public static void sort(int[] arr, int target) {
        int left = -1, right = arr.length - 1;
        int index = 0;
        while (index <= right) {
            if (arr[index] <= target) {
                swap(arr, ++left, index++);
            } else {
                index++;
            }

        }
    }





    public static void testSort(int[] arr, int target) {
        int breakFlag = -1;
        boolean meetCondition = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (meetCondition && arr[i] <= target) {
                printArr(arr);
                System.out.println("Oops!!---target:" + target);
                break;
            }
            if (arr[i] > target && breakFlag == -1) {
                breakFlag = i;
                meetCondition = true;
            }
        }
    }
}
