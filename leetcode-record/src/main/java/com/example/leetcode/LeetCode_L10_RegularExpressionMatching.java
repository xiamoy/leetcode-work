package com.example.leetcode;

public class LeetCode_L10_RegularExpressionMatching {
    public static void main(String[] args) {
        Solution_L10 solution_l10 = new Solution_L10();
        System.out.println(solution_l10.isMatch("aa", "a"));//false
        System.out.println(solution_l10.isMatch("aa", "a*"));//true
        System.out.println(solution_l10.isMatch("ab", ".*"));//true
        System.out.println(solution_l10.isMatch("aab", "c*a*b"));//true
        System.out.println(solution_l10.isMatch("caab", "c*a*b"));//true

        System.out.println(solution_l10.isMatch("mississippi", "mis*is*p*."));//false
        System.out.println(solution_l10.isMatch("mississippi", "mis*is*ip*."));//true
        System.out.println(solution_l10.isMatch("ab", ".*c"));//false
        System.out.println(solution_l10.isMatch("aaa", "a*a"));//true

    }
}

class Solution_L10 {

    //Hard Runtime: 67 ms, faster than 15.82% Memory Usage: 39.5 MB, less than 17.76%
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean firstCharMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        int p1 = 0, pLen = p.length();

        if (p1 + 1 < pLen && p.charAt(p1 + 1) == '*') {
            return isMatch(s, p.substring(2)) || (firstCharMatch &&
                    isMatch(s.substring(1), p));
        } else {
            //compare char one by one
            return firstCharMatch && isMatch(s.substring(1), p.substring(1));
        }

    }

    public boolean isMatchN1(String s, String p) {
        if (".*".equals(p)) {
            return true;
        }

        int s1 = 0, p1 = 0;
        int sLen = s.length(), pLen = p.length();
        while (s1 < sLen && p1 < pLen) {
            if (p.charAt(p1) == '.') {
                if (p1 == pLen - 1 || p.charAt(p1 + 1) != '*') {
                    p1++;
                }
                s1++;
                continue;
            }

            if (p1 < pLen - 1 && p.charAt(p1 + 1) == '*') {
                while (s1 < sLen && s.charAt(s1) == p.charAt(p1)) {
                    s1++;
                }
                p1 += 2;
            } else {
                if (s1 < sLen && p1 < pLen && s.charAt(s1) == p.charAt(p1)) {
                    s1++;
                    p1++;
                }
            }
        }
        return s1 >= sLen && p1 >= pLen;
    }

    public boolean isMatchN2(String s, String p) {
        if (!p.contains(".") && !p.contains("*")) {
            return s.equals(p);
        }

        int beginIndex = 0;
        String[] split = p.split("\\*");
        int i = 0;
        for (; i < split.length && beginIndex < s.length(); ) {

            String symbol = split[i];
            if (symbol.equals(".")) {
                beginIndex++;
                if (beginIndex == s.length()) {
                    return i == split.length;
                }
                if (i != 0 && i == split.length - 1) {
                    i++;
                }
                continue;
            }

            if (symbol.length() > 1) {
                String currentStr = s.substring(beginIndex, beginIndex + symbol.length() - 1);
                if (!currentStr.equals(symbol.substring(0, symbol.length() - 1))) {
                    return false;
                }
                split[i] = symbol.substring(symbol.length() - 1);
                beginIndex += symbol.length() - 1;
                if (beginIndex >= s.length()) {
                    return true;
                }
                continue;
            } else {
                String currentStr = s.charAt(beginIndex) + "";
                if (!symbol.equals(currentStr)) {
                    i++;
                } else {
                    while (symbol.equals(currentStr)) {
                        beginIndex++;
                        if (beginIndex >= s.length()) {
                            return true;
                        }
                        currentStr = s.charAt(beginIndex) + "";
                    }
                    i++;
                }
            }
        }
        return beginIndex == s.length() && i == split.length;
    }
}
