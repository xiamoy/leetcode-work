package com.example.leetcode.hot100;

public class LeetCode_L169_MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        int i = majorityElement(nums);
        System.out.println(i);//3

    }

    //摩尔投票法 https://www.cs.utexas.edu/~moore/best-ideas/mjrty/
    //在任意0-i区间内，majority 大于半数的元素,counter：对应比其他元素多的次数
    // A A A C C B B C C C B C C
    // A 在0-4 下标区间内是majority，在5位置不是多数，其他元素的次数之和等于A，相当于平票
    // 从6位置开始继续寻找， B C C C B C C, 7和8位置各右不同元素出现一次，即也是平票
    // 从9位置开始继续，C C B C C，最终C为大多数
    public static int majorityElement(int[] nums) {
        int res = -1, counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (counter == 0) {
                counter++;
                res = nums[i];
            } else if (nums[i] == res) {
                counter++;
            } else {
                counter--;
            }
        }
        return res;

    }
}
