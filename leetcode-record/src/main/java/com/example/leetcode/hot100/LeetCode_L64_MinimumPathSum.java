package com.example.leetcode.hot100;

public class LeetCode_L64_MinimumPathSum {

    public static void main(String[] args) {
//        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
//        System.out.println(minPathSum(grid));// 7

        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(minPathSum(grid));//12

    }


    //2ms, 44.5MB
    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {//第一行，只能从左到此处
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {//第一列，只能从上一个到此处
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[row - 1][col - 1];
    }
}