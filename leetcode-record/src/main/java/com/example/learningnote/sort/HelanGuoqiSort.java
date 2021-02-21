package com.example.learningnote.sort;

import com.example.SelfArrayUtils;

import static com.example.SelfArrayUtils.generateArr;
import static com.example.SelfArrayUtils.printArr;

/**
 * 荷兰国旗问题
 * description:
 */
public class HelanGuoqiSort {

    public static void main(String[] args) {
        int[] array = {16, 22, 15, 22, 26, 22, 4, 1, 7, 1, 9, 7, 8, 26};
        int num = 16;
        sortLeftMidRight(array, num);
        testSort(array, num);

        for (int i = 0; i < 500000; i++) {
            int[] arr = generateArr(5, 20, 1, 50);
            int target = (int) (Math.random() * (50 - 1) + 1) + 1;
            sortLeftMidRight(arr, target);
            testSort(arr, target);
        }

//        int[] arr={3,8,2,7,5,11,9,8};
//        int target=5;
//        sortLeftMidRight(arr, target);
//        testSort(arr, target);
    }

    public static void sortLeftMidRight(int[] arr, int target) {
        int left = -1, len = arr.length - 1, right = len;
        int index = 0;
        while (index <= right) {
            if (arr[index] == target) {
                index++;
//                SelfArrayUtils.swap(arr, left + 1, index++);
            } else if (arr[index] > target) {
                SelfArrayUtils.swap(arr, right--, index);
            } else {
                SelfArrayUtils.swap(arr, ++left, index++);
            }
        }
    }

    public static void testSort(int[] arr, int target) {

        int flag = 1;
        int i = 0;

        if (flag == 1) {
            while (i < arr.length - 1) {
                if (arr[i] < target) {
                    i++;
                } else {
                    flag = 2;
                    break;
                }
            }
        }

        if (flag == 2) {
            while (i < arr.length - 1) {
                if (arr[i] < target) {
                    printArr(arr);
                    System.out.println("Oops! with target:" + target);
                    System.exit(1);
                } else if (arr[i] == target) {
                    i++;
                } else {
                    flag = 3;
                    break;
                }
            }
        }
        if (flag == 3) {
            while (i <= arr.length - 1) {
                if (arr[i] <= target) {
                    printArr(arr);
                    System.out.println("Oops! with target:" + target);
                    System.exit(1);
                } else {
                    i++;
                }
            }
        }
        if (i < arr.length - 1) {
            printArr(arr);
            System.out.println("Oops! with target:  " + target + " with i:" + i + " in arr size:" + (arr.length - 1));
            System.exit(1);
        }
    }
}
