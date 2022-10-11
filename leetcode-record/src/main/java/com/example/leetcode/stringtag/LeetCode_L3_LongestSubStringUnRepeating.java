package com.example.leetcode.stringtag;


import java.util.HashMap;
import java.util.Map;

public class LeetCode_L3_LongestSubStringUnRepeating {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abba"));//2
//        System.out.println(lengthOfLongestSubstring("bb"));//1
//        System.out.println(lengthOfLongestSubstring("   "));//1
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));//3
//        System.out.println(lengthOfLongestSubstring("bbbbb"));//1
//        System.out.println(lengthOfLongestSubstring("pwwkew"));//3
    }

    //49ms, 54M
    public static int lengthOfLongestSubstring1(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        char[] arr = s.toCharArray();
        int size = 0;
        int left = 0, right = left;
        int cursor = right + 1;
        for (; cursor < s.length(); ) {
            String currentWindow = String.valueOf(arr, left, right - left + 1);
            int index = currentWindow.indexOf(arr[cursor] + "");
            if (index != -1) {
                left++;
            } else {
                size = Math.max(size, currentWindow.length() + 1);
                right++;
                cursor = right + 1;
            }

        }

        return size;
    }

    //11ms,44.8M
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }


        Map<Character, Integer> map = new HashMap<>();
        int size = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if(map.containsKey(c)){
                //abba
                left = Math.max(left,map.get(c)+1);
            }
            map.put(c,right);
            size=Math.max(size,right-left+1);
        }

        return size;
    }
}
