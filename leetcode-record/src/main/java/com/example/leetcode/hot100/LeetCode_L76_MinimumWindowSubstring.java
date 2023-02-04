package com.example.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_L76_MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));//BANC
        System.out.println(minWindow("a", "a"));//a
        System.out.println(minWindow("aa", "aa"));//aa

    }

    //27ms, 46.5MB
    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int letterCount = map.size();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE, minStart = 0, minEnd = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (!map.containsKey(c)) {
                right++;
                continue;
            }

            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                letterCount--;
            }

            while (letterCount == 0 && left <= right) {
                if (!map.containsKey(s.charAt(left))) {
                    left++;
                } else {
                    char lf = s.charAt(left);
                    if (map.get(lf) < 0) {
                        map.put(lf, map.get(lf) + 1);
                        left++;
                    } else {
                        break;
                    }
                }
            }
            if (letterCount == 0 && minLen > (right - left + 1)) {
                minLen = right - left + 1;
                minStart = left;
                minEnd = right;
            }
            right++;

        }

        return minLen == Integer.MIN_VALUE ? "" : s.substring(minStart, minEnd + 1);
    }
}
