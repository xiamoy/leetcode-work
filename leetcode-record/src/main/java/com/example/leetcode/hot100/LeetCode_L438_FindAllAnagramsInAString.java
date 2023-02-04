package com.example.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_L438_FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));//[0,6]

    }

    //6ms, 43.4MB
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) {
            return result;
        }
        int[] records = new int[26];
        int i = 0;
        for (; i < p.length(); i++) {
            records[p.charAt(i) - 'a']++;
            records[s.charAt(i) - 'a']--;
        }

        if (isAllZero(records)) {
            result.add(0);
        }
        int len = p.length();
        for (; i < s.length(); i++) {
            records[s.charAt(i - len) - 'a']++;
            records[s.charAt(i) - 'a']--;
            if (isAllZero(records)) {
                result.add(i - len + 1);
            }
        }


        return result;

    }

    private static boolean isAllZero(int[] counts) {
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
