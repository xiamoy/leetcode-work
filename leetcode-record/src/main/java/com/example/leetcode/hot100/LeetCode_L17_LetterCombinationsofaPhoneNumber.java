package com.example.leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_L17_LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));

    }

    static Map<String, String> map = new HashMap<>();

    //9ms,43.2MB
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }

        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");


        backtrack("", digits, 0, res);
        map.clear();
        return res;

    }

    public static void backtrack(String s, String digits, int index, List<String> list) {
        if (index >= digits.length()) {
            list.add(s);
            return;
        }

        String combine = map.get(digits.charAt(index) + "");
        for (int i = 0; i < combine.length(); i++) {
            backtrack(s + combine.charAt(i), digits, index + 1, list);
        }

    }
}
