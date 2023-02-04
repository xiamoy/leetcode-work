package com.example.leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_L448_FindAllNumbersDisappearedinanArray {
    public static void main(String[] args) {
        int[] nums = {1, 1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);

    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= nums.length; i++) {
            map.put(i, 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            }
        }

        return new ArrayList<>(map.keySet());
    }

    //如果数组包含1-n的完整数字，从任意位置i开始，以(对应的位置值-1)为下标再进行访问（再偏移到下一个位置i+1,往复），最终会访问完所有数组中的元素
    //2 2 1
    //2 1 1
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int index = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
