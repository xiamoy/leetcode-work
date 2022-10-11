package com.example.leetcode;

/**
 * Longest Palindromic Substring
 *
 * @link https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LeetCode_L5_LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";

//        System.out.println(longestPalindrome(s));//"bab" or "aba"
//        System.out.println(longestPalindrome("cbbd"));//"bb"
        System.out.println(longestPalindrome("ac"));//"a"
        System.out.println(longestPalindrome("bb"));//"bb"
    }

    // 24ms, 42Mb
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 1.当前位置为中心的奇回文，左右寻找
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (res.length() < right - left) {
                res = s.substring(left + 1, right);
            }

            // 2.当前位置为左边界开始的偶回文
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (res.length() < right - left) {
                res = s.substring(left + 1, right);
            }
        }
        return res;
    }


    //Runtime 695ms,Memory 39.8MB
    public static String longestPalindrome1(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String res = s.substring(0, 1);
        int i, j;
        for (i = 0; i < s.length(); i++) {
            j = i + 1;
            while (j < s.length()) {
                if (s.charAt(i) == s.charAt(j++)) {
                    String tmpStr = s.substring(i, j);
                    if (tmpStr.length() > res.length() && isPalindrome(tmpStr)) {
                        res = tmpStr;
                    }
                }
            }
        }

        return res;

    }

    public static boolean isPalindrome(String val) {
        int i = 0, j = val.length() - 1;
        while (i < j) {
            if (val.charAt(i++) != val.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

}