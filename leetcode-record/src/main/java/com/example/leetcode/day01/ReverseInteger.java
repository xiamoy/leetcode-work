package com.example.leetcode.day01;

public class ReverseInteger {

    public static void main(String[] args) {

//        System.out.println(Integer.MAX_VALUE);//2147483647
        System.out.println(new Solution().reverse(-123));//0
    }
}

class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (Integer.MAX_VALUE / 10 < result || Integer.MIN_VALUE / 10 > result) {
                return 0;
            }
            int mod = x % 10;

            if (mod >= 0 && (Integer.MAX_VALUE - mod) < result * 10) {//over the max value
                return 0;
            }

            if (mod < 0 && (Integer.MIN_VALUE - mod) > result * 10){
                return 0;
            }
            int temp = result * 10 + mod;
            result = temp;
            x = x / 10;
        }

        return result;
    }
}