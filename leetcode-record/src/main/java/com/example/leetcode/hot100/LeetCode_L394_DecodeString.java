package com.example.leetcode.hot100;

import java.util.Stack;

public class LeetCode_L394_DecodeString {
    public static void main(String[] args) {

        System.out.println(decodeString("3[a]2[bc]"));// aaabcbc

        System.out.println(decodeString("3[a2[c]]"));//accaccacc
        System.out.println(decodeString("abc"));//accaccacc

    }


    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int num = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(num);
                num = 0;
                strStack.push(res.toString());
                res = new StringBuilder();
            } else if (ch == ']') {
                String c = strStack.pop();
                String tmp = res.toString();
                int count = numStack.pop();
                while (count-- > 0) {
                    c = c.concat(tmp);
                }
                res = new StringBuilder(c);
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }

    //10ms,42.8MB
    public static String decodeString2(String s) {
        int len = s.length();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        for (int i = 0; i < s.length(); ) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int j = i + 1;
                while (j < len && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                numStack.push(Integer.parseInt(s.substring(i, j)));
                i = j;
                continue;
            }
            if (ch == '[') {
                int j = i + 1;
                while (j < len && Character.isLetter(s.charAt(j))) {
                    j++;
                }
                strStack.push(s.substring(i, j));
                i = j;
                continue;
            }
            if (ch == ']') {
                if (!strStack.isEmpty() && strStack.peek().startsWith("[")) {
                    String pop = strStack.pop();
                    pop = pop.substring(1);

                    String result = "";
                    if (!numStack.isEmpty()) {
                        int count = numStack.pop();
                        while (count-- > 0) {
                            result = result + pop;
                        }
                    }
                    if (!result.equals("")) {
                        if (!strStack.isEmpty()) {
                            strStack.push(strStack.pop() + result);
                        } else {
                            strStack.push(result);
                        }
                    }
                }
                i++;
                continue;
            }
            if (!strStack.isEmpty()) {
                strStack.push(strStack.pop() + ch);
            } else {
                strStack.push(ch + "");
            }
            i++;
        }

        if (strStack.isEmpty()) {
            return "";
        }

        String pop = strStack.pop();
        return pop.startsWith("[") ? pop.substring(1) : pop;

    }
}
