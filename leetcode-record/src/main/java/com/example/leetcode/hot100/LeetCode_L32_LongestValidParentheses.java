package com.example.leetcode.hot100;

import java.util.Stack;

public class LeetCode_L32_LongestValidParentheses {

    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(longestValidParentheses(s));//2
        System.out.println(longestValidParentheses(")()())"));//4
        System.out.println(longestValidParentheses("(()"));//2
        System.out.println(longestValidParentheses(")()())()()("));//4
    }

    //10ms,43.7MB
    public static int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    stack.push(i);
//                    res=Math.max(res,i-1);
                } else {
                    if (s.charAt(stack.peek()) == '(') {
                        stack.pop();
                        res = Math.max(res, stack.isEmpty() ? i + 1 : i - stack.peek());
                    } else {
                        stack.push(i);
                    }
                }

            }
        }
        return res;
    }

    //v2
    public static int longestValidParentheses2(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    //dp function
    public static int longestValidParentheses3(String s) {
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
        }
        return dp[len - 1];
    }
}
