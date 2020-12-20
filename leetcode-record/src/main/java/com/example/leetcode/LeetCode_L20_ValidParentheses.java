package com.example.leetcode;

import java.util.Stack;

public class LeetCode_L20_ValidParentheses {
    public static void main(String[] args) {
        Solution_L20 solution_l20 = new Solution_L20();

        System.out.println(solution_l20.isValid("{[]}"));
    }
}

class Solution_L20 {
    public boolean isValid(String s) {
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

    //[{()}]
//    public boolean isValid2(String s) {
//

//        char[] chars = s.toCharArray();
//        if (s.length()==0){
//            return true;
//        }
//        int left=0,right=left+1;
//        char expected='\0';
//        while (right<chars.length){
//            if (chars[left] == '(') {
//                expected=')';
//            } else if (chars[left] == '[') {
//               expected=']';
//            } else  if (chars[left] == '{') {
//                expected='}';
//            }
//            if (chars[right]==expected){
//                if (right==chars.length-1){
//                    return true;
//                }else if(right<chars.length-1){
//                    left=right+1;
//                    right=left+1;
//                    if (right==chars.length){
//                        return false;
//                    }
//                }else{
//                    right++;
//                    left--;
//                }
//            }else{
//                left++;
//                right=left+1;
//            }
//        }
//
//        return left==-1;
//    }
}
