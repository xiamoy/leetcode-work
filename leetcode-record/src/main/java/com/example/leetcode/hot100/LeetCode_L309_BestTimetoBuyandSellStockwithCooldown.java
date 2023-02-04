package com.example.leetcode.hot100;

public class LeetCode_L309_BestTimetoBuyandSellStockwithCooldown {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 2};
//        System.out.println(maxProfit(nums));// 3
//        System.out.println(maxProfit(new int[]{2,1,4,5,2,9,7}));//10
        System.out.println(maxProfit(new int[]{1, 3, 5, 4, 3, 7, 6, 9, 2, 4}));//10

    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;

        return maxProfit(prices, 0, len);
    }

    public static int maxProfit(int[] prices, int begin, int end) {
        if (begin >= end - 1) {
            return 0;
        }
        if (begin == end - 2) {
            return Math.max(prices[end - 1] - prices[begin], 0);
        }

        int max = 0;
        for (int i = begin; i < end; i++) {
            int[] dp = new int[prices.length];
            for (int j = i + 1; j < end; j++) {
                if (prices[j] - prices[i] > dp[j - 1]) {
                    dp[j] = prices[j] - prices[i] + maxProfit(prices, j + 2, end);
                } else {
                    dp[j] = dp[j - 1];
                }
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }
}
