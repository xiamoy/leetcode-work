package com.example.leetcode.hot100;

import java.util.Arrays;

public class LeetCode_L72_EditDistance {

    public static void main(String[] args) {
        Arrays.copyOf(new int[]{}, 1);
    }

    //6ms, 42.6MB
    public static int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m][n];
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;

        for (int i = 1; i < m; i++) {// word1 to word2[0] with count
            dp[i][0] = word1.charAt(i) == word2.charAt(0) ? i : i + 1;
            dp[i][0] = Math.min(dp[i - 1][0] + 1, dp[i][0]);
        }

        for (int j = 1; j < n; j++) {// word2 to word1[0] with count
            dp[0][j] = word2.charAt(j) == word1.charAt(0) ? j : j + 1;
            dp[0][j] = Math.min(dp[0][j], dp[0][j - 1] + 1);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = word1.charAt(i) == word2.charAt(j) ? dp[i - 1][j - 1] : (dp[i - 1][j - 1]) + 1;
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);// delete one:i
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);// add one: word2[j]
            }
        }

        return dp[m - 1][n - 1];
    }

}
