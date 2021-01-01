package com.example.leetcode;

/**
 * Longest Palindromic Substring
 *
 * @link https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LeetCode_L5_LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        Solution_L5 solution_l5 = new Solution_L5();
        System.out.println(solution_l5.longestPalindrome(s));//"bab" or "aba"
        System.out.println(solution_l5.longestPalindrome("cbbd"));//"bb"
        System.out.println(solution_l5.longestPalindrome("ac"));//"bb"
    }
}

class Solution_L5 {

    //Runtime 695ms,Memory 39.8MB
    public String longestPalindrome(String s) {
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

    public boolean isPalindrome(String val) {
        int i = 0, j = val.length() - 1;
        while (i < j) {
            if (val.charAt(i++) != val.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
