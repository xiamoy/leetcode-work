package com.example.leetcode;

public class LeetCode_MaxProfixOfStockOntransaction {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(getMaxProfit(prices));
        System.out.println(getMaxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public static int getMaxProfit(int[] prices) {
        int len = prices.length;
        int leftMin = prices[0], rightMax = prices[len - 1];
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 1; i < len; i++) {
            left[i] = leftMin;
            leftMin = Math.min(prices[i], leftMin);
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = rightMax;
            rightMax = Math.max(prices[i], rightMax);
        }
        int res = 0;
        for (int i = 1; i < len; i++) {
            int temp = right[i] - left[i];
            res = Math.max(temp, res);
        }
        return res;
    }
}
