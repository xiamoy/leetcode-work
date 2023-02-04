package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * @link https://leetcode.com/problems/generate-parentheses/
 */
public class LeetCode_L22_GenerateParentheses {

    public static void main(String[] args) {

        List<String> list = generateParenthesis(2);
        System.out.println(list);
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, n, "", res);
        return res;
    }

    public static void backtrack(int left, int right, String temp, List<String> list) {
        if (left == 0 && right == 0) {
            list.add(temp);
            return;
        }
        if (left > 0) {
            backtrack(left - 1, right, temp + "(", list);
        }
        if (left < right) {
            backtrack(left, right - 1, temp + ")", list);
        }
    }
}

