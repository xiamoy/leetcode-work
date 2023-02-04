package com.example.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_L78_Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);

    }

    //1ms, 43.1MB
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    public static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int n) {

        list.add(new ArrayList<>(temp));
        for (int i = n; i < nums.length; i++) {
            temp.add(nums[i]);
            int size = temp.size();
            backtrack(list, temp, nums, i + 1);
            temp.remove(size - 1);
        }
    }


    //包含重复元素集合的组合
    public static List<List<Integer>> combine(int[] nums, int target) {
        //TODO
        return null;
    }

    public static void backtrackCombine() {

    }
}
