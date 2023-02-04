package com.example.leetcode.hot100;

public class LeetCode_L121_BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] p = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(p);
        System.out.println(maxProfit);

    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        if (prices.length < 2) {
            return max;
        }
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > min) {
                max = Math.max(prices[i] - min, max);
            } else {
                min = prices[i];
            }
        }
        return max;
    }


    public static int maxProfit2(int[] prices) {
        int res = 0;
        if (prices.length < 2) {
            return res;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(prices[i] - prices[i - 1] + dp[i - 1], 0);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
