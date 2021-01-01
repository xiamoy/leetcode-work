package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 *
 * @link https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LeetCode_L3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Solution_L3 solution_l3 = new Solution_L3();
        String s = "abcabcbb";
//        System.out.println(solution_l3.lengthOfLongestSubstring(s));//3
//        System.out.println(solution_l3.lengthOfLongestSubstring("bbbbb"));//1
//        System.out.println(solution_l3.lengthOfLongestSubstring("pwwkew"));//3
//        System.out.println(solution_l3.lengthOfLongestSubstring("au"));//2

        System.out.println(solution_l3.lengthOfLongestSubstringN1(s));//3
        System.out.println(solution_l3.lengthOfLongestSubstringN1("bbbbb"));//1
        System.out.println(solution_l3.lengthOfLongestSubstringN1("pwwkew"));//3
        System.out.println(solution_l3.lengthOfLongestSubstringN1("au"));//2

    }
}

class Solution_L3 {
    //Runtime 1736ms,Memory 39.5MB
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int size = 0;
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(chars[i])) {
                list = list.subList(list.indexOf(chars[i]) + 1, list.size());
            }
            list.add(chars[i]);
            size = Math.max(list.size(), size);
        }
        return size;

    }

    //Others solutions
    public int lengthOfLongestSubstringN1(String s) {

        int n = s.length();
        //no duplicated
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }

        }
        return ans;

    }
}
