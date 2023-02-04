package com.example.leetcode.hot100;

public class LeetCode_L62_UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));// 28
    }

    //2ms, 42MB
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 0;
        for (int i = m - 1; i >= 0; i--) {// 最后一列，每行的位置只能向下,只有1个
            dp[i][n - 1] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {// 最后一行，每列只能往右，只有1个
            dp[m - 1][i] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {//中间位置，右边+下边的可能性
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];

    }
}
