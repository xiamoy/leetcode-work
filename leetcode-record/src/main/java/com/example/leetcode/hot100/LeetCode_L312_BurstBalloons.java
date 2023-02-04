package com.example.leetcode.hot100;

public class LeetCode_L312_BurstBalloons {

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        int maxCoins = maxCoins(nums);
        System.out.println(maxCoins);

    }

    //TODO
    public static int maxCoins(int[] nums) {
        int len = nums.length;
        int[] visited = new int[len];
        int sum = 0;
        int i = 1;
        for (; i < len - 1; i++) {
            int lIndex = i - 1;
            while (lIndex >= 0 && visited[lIndex] == -1) {
                lIndex--;
            }
            int left = lIndex >= 0 ? nums[lIndex] : 1;
            lIndex = i + 1;
            while (lIndex < len && visited[lIndex] == -1) {
                lIndex++;
            }
            int right = lIndex < len ? nums[lIndex] : 1;
            visited[i] = -1;
            sum += nums[i] * left * right;
        }
        //
        sum += nums[0] * nums[len - 1];
        sum += Math.max(nums[0], nums[len - 1]);
        return sum;

    }
}
