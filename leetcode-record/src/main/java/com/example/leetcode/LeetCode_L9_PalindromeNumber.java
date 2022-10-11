package com.example.leetcode;

/**
 * Palindrome Number
 *
 * @link https://leetcode.com/problems/palindrome-number/
 */
public class LeetCode_L9_PalindromeNumber {
    public static void main(String[] args) {
     
//        System.out.println(isPalindrome(121));

        System.out.println(isPalindromeN1(12321));
    }

    //Runtime 7ms,Memory 38.5MB
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    //Runtime 6ms,Memory 37.9MB
    public static boolean isPalindromeN1(int x) { //12321
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int mirrorRight = 0;
        while (x > mirrorRight) {
            mirrorRight = mirrorRight * 10 + x % 10;
            x = x / 10;
        }
        //x==12 mirrorRight=123
        return x == mirrorRight || x == mirrorRight / 10;
    }

}
