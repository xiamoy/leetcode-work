package com.example.leetcode.hot100;

import java.util.Arrays;
import java.util.List;

public class LeetCode_L139_WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, wordDict));//true

        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));//true
        System.out.println(wordBreak("bb", Arrays.asList("a", "b", "bbb", "bbbb")));//true
        System.out.println(wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));//true
    }

    public static boolean wordBreak(String s1, List<String> wordDict) {

        boolean[] dp = new boolean[s1.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s1.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s1.length()];

    }


    //TODO today
    public static boolean wordBreak2(String s1, List<String> wordDict) {
        DicNode dicNode = new DicNode();

        for (String s : wordDict) {
            DicNode cur = dicNode;
            char[] arr = s.toCharArray();
            for (char c : arr) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new DicNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.end = true;
        }
        return traversal(s1, dicNode, 0);
    }

    public static boolean traversal(String s, DicNode dicNode, int begin) {
        if (begin >= s.length()) {
            return true;
        }
        DicNode cur = dicNode;
        int tryIndex = -1;
        for (int i = begin; i < s.length(); i++) {
            char curC = s.charAt(i);
            if (cur.children[curC - 'a'] == null) {
                return false;
            } else {
                cur = cur.children[curC - 'a'];
                if (cur.end) {
                    if (i == s.length() - 1) {
                        return true;
                    }
                    if (cur.children[s.charAt(i + 1) - 'a'] == null) {
                        return traversal(s, dicNode, i + 1);
                    } else if (tryIndex != 1) {
                        tryIndex = i + 1;
                    }

                }
            }
        }
        return cur.end || (tryIndex != -1 && traversal(s, dicNode, tryIndex));
    }
}

class DicNode {
    DicNode[] children;
    boolean end;

    DicNode() {
        this.children = new DicNode[26];
    }

}