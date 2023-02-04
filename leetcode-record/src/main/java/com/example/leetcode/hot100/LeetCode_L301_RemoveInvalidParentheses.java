package com.example.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_L301_RemoveInvalidParentheses {

    public static void main(String[] args) {
        LeetCode_L301_RemoveInvalidParentheses test = new LeetCode_L301_RemoveInvalidParentheses();
//        Input: s = "()())()"
//        Output: ["(())()","()()()"]

//        List<String> list = test.removeInvalidParentheses("()())()");
//        System.out.println(list);// ["(())()","()()()"]

//        Input: s = "(a)())()"
//        Output: ["(a())()","(a)()()"]

//        List<String> list1 = test.removeInvalidParentheses("(a)())()");
//        System.out.println(list1);

        List<String> list2 = test.removeInvalidParentheses(")(");
        System.out.println(list2);
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();


        int lRemove = 0, rRemove = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lRemove++;
            } else if (s.charAt(i) == ')') {
                if (lRemove == 0) {
                    rRemove++;
                } else {
                    lRemove--;
                }
            }
        }
        backtrack(0, s, res, lRemove, rRemove);
        return res;
    }

    public void backtrack(int begin, String s, List<String> res, int lRemove, int rRemove) {
        if (lRemove == 0 && rRemove == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }

        for (int i = begin; i < s.length(); i++) {
            if (i + lRemove + rRemove > s.length()) {
                return;
            }

            if (i > begin && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            char ch = s.charAt(i);
            if (ch == '(' && lRemove > 0) {
                backtrack(i, s.substring(0, i) + s.substring(i + 1), res, lRemove - 1, rRemove);
            }
            if (ch == ')' && rRemove > 0) {
                backtrack(i, s.substring(0, i) + s.substring(i + 1), res, lRemove, rRemove - 1);
            }

        }
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
