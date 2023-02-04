package com.example.leetcode.common;

public class GasGame {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        System.out.println(getGas(gas, cost));//3
    }

    public static int getGas(int[] gas, int[] cost) {
        int result = -1;
        int len = gas.length;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                int begin = i;
                int sum = gas[begin];
                int count = 0;
                while (sum >= cost[begin] && count < len) {
                    sum -= cost[begin++];
                    if (begin == len) {
                        begin = len - i;
                    }
                    sum += gas[begin];
                    count++;
                }
                if (count == len) {
                    return i;
                }
            }

        }
        return result;
    }
}
