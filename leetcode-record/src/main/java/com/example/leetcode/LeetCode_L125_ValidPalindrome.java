package com.example.leetcode;

public class LeetCode_L125_ValidPalindrome {
    public static void main(String[] args) {


        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

    }

    //7ms, 48.7MB
    public static boolean isPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            char l = s.charAt(left);
            if (!isValidChar(l)) {
                left++;
                continue;
            }
            char r = s.charAt(right);
            if (!isValidChar(r)) {
                right--;
                continue;
            }

            if (!String.valueOf(l).toLowerCase().equals(String.valueOf(r).toLowerCase())) {
                return false;
            } else {
                right--;
                left++;
            }

        }

        return true;
    }


    public static boolean isValidChar(char c) {
        // A-Z a-z 0-9
        if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57)) {
            return true;
        }
        return false;
    }

    //3ms, 44MB
    public static boolean isPalindrome3(String s) {
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i <= j; ) {
            char left = s.charAt(i);
            if (!Character.isLetterOrDigit(left)) {
                i++;
                continue;
            }
            char right = s.charAt(j);
            if (!Character.isLetterOrDigit(right)) {
                j--;
                continue;
            }
            if (left != right) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //3ms, 42.3MB
    public static boolean isPalindrome(String s) {

        for (int i = 0, j = s.length() - 1; i <= j; ) {
            char left = s.charAt(i);
            if (!Character.isLetterOrDigit(left)) {
                i++;
                continue;
            }
            char right = s.charAt(j);
            if (!Character.isLetterOrDigit(right)) {
                j--;
                continue;
            }
            int abs = Math.abs(right - left);
            if (abs != 0 && abs != 32) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
