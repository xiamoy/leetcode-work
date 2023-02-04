package com.example.leetcode;

public class LeetCode_L367_ValidPerfectSquare {

    public static void main(String[] args) {
//        System.out.println(Math.sqrt(808201));
//        System.out.println(isPerfectSquare(16));//true
//        System.out.println(isPerfectSquare(14));//false
        System.out.println(isPerfectSquare(808201));//true  899
    }

    public static boolean isPerfectSquare2(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }

    //0ms, 40.7MB
    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int right = num / 2;
        int left = 1;

        while (left <= right) {
            int i = (right + left) / 2;
            if (i == num / i && num % i == 0) {
                return true;
            }
            if (i > num / i) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return false;
    }
}
