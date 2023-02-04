package com.example.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 *
 * @link https://leetcode.com/problems/two-sum/
 */
public class LeetCode_L1_TwoSum {
    public static void main(String[] args) {


        int[] case1 = new int[]{2, 7, 11, 15};
        int[] twoSum1 = twoSum(case1, 9);//[0,1]
        int[] case2 = new int[]{0, 4, 3, 0};
        int[] twoSum2 = twoSum(case2, 0);//[0,3]
        System.out.println(twoSum2);
        int[] case3 = new int[]{-1, -2, -3, -4, -5};
        int[] twoSum3 = twoSum(case2, -8);//[2,4]

        int[] case4 = new int[]{3, 3};
        int[] twoSum4 = twoSumN2(case4, 6);//[0,1]
        System.out.println(twoSum4);

        int[] case5 = new int[]{3, 2, 4};
        int[] twoSum5 = twoSumN2(case5, 6);//[1,2]
        System.out.println(twoSum5);
    }

    //Runtime 0ms,Memory 39.2MB
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};

    }

    //Runtime 9ms, Memory 39.9MB
    public static int[] twoSumN1(int[] nums, int target) {

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            String value = String.valueOf(i);
            if (map.containsKey(nums[i])) {
                value = map.get(nums[i]) + "->" + value;
            }
            map.put(nums[i], value);
        }

        for (int i = 0; i < nums.length; i++) {

            int toFindVal = target - nums[i];
            if (map.containsKey(toFindVal)) {
                String[] split = map.get(toFindVal).split("->");
                int index1 = i;
                int index2 = split.length > 1 ? Integer.valueOf(split[split.length - 1]) : Integer.valueOf(split[0]);
                if (index1 != index2) {
                    return new int[]{index1, index2};
                }
            }
        }

        return new int[]{};

    }

    // //Runtime 0ms,Memory 39.2MB
    public static int[] twoSumN2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int toFindVal = target - nums[i];
            if (map.containsKey(toFindVal)) {
                return new int[]{i, map.get(toFindVal)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
