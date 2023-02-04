package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode_L20_ValidParentheses {
    public static void main(String[] args) {
      
        System.out.println(isValid("{[]}"));
    }

    //1ms, 37.5M
    public static boolean isValid2(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        int i = 0;
        while (i < chars.length) {
            if (!stack.isEmpty() && stack.peek() == chars[i]) {
                stack.pop();
            } else {
                if (chars[i] == '(') {
                    stack.push(')');
                } else if (chars[i] == '[') {
                    stack.push(']');
                } else if (chars[i] == '{') {
                    stack.push('}');
                } else {
                    return false;
                }
            }
            i++;
        }
        return stack.isEmpty();
    }

    //3ms, 42.2M
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else {
                if (stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
            i++;
        }
        return stack.isEmpty();

    }

}
