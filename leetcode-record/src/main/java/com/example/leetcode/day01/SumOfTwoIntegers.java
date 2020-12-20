package com.example.leetcode.day01;

public class SumOfTwoIntegers {

    public static void main(String[] args) {
        int sum = new Solution2().getSum(2,3);
        System.out.println(sum);
    }
}

class Solution2 {
    public int getSum(int a, int b) {
        int tmp1=Integer.MAX_VALUE|a;
        int tmp2=Integer.MAX_VALUE|b;
//        int sum = tmp1|tmp2;
        int sum=a|b;
        return sum;
    }
}
