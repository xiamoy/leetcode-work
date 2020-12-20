package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 22. Generate Parentheses
 *
 * @link https://leetcode.com/problems/generate-parentheses/
 */
public class LeetCode_L22_GenerateParentheses {

    public static void main(String[] args) {
        Solution_L22 solution_l22 = new Solution_L22();
        List<String> list = solution_l22.generateParenthesis(4);
        System.out.println(list);
    }
}

class Solution_L22 {
    public List<String> generateParenthesis(int n) {
        //TODO wrong answer
        Set<String> set = generateParenthesis("", n);
        return new ArrayList<>(set);
    }

    public Set<String> generateParenthesis(String current, int n) {
        Set<String> list = new HashSet<>();
        String start = "()";
        if (current.length() == 2 * n) {
            list.add(current);
            return list;
        }

        list.addAll(generateParenthesis(start + current, n));
        list.addAll(generateParenthesis("(" + current + ")", n));
        list.addAll(generateParenthesis(current + start, n));
        return list;

    }
}
