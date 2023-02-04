package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_L18_4Sum {

    public static void main(String[] args) {
//        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0, 4)); //[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
//        System.out.println(fourSum(new int[]{0,0,0,0}, 0, 4));//[[0, 0, 0, 0]]
//        System.out.println(fourSum(new int[]{2, 2, 2, 2, 2}, 8,4));//[[2,2,2,2]]
//        System.out.println(fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0, 4));// [[-2, -1, 1, 2], [-1, -1, 1, 1]]
        System.out.println(fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11, 4));
        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296, 4));

//        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
//        System.out.println(fourSum(nums, 0));
//

//        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));


    }

    //22ms, 44.2MB
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                long remain = (long) target - nums[i] - nums[j];
                while (left < right) {
                    long curSum = nums[left] + nums[right];
                    if (curSum == remain) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left + 1 < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    } else if (curSum < remain) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }
        return list;
    }


    public static List<List<Integer>> fourSum(int[] nums, int target, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < k) {
            return list;
        }
        Arrays.sort(nums);
        list = kSum(nums, target, 4, 0, nums.length);
        return list;
    }

    public static List<List<Integer>> kSum(int[] nums, long target, int k, int begin, int end) {
        List<List<Integer>> list = new ArrayList<>();
        if (begin >= end) {
            return list;
        }

//        long ave = target / k;
//        if (nums[begin] > ave || ave > nums[end - 1]) {
//            return list;
//        }

        if (k == 2) {
            return twoSum(nums, target, begin, end);
        }


        for (int i = begin; i <= end - k; ++i) {
            if (i > begin && nums[i - 1] == nums[i]) {
                continue;
            }
            List<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1, end);
            for (List<Integer> it : temp) {
                List<Integer> newList = new ArrayList<>(Arrays.asList(nums[i]));
                newList.addAll(it);
                list.add(newList);
            }

        }


        return list;
    }

    public static List<List<Integer>> twoSum(int[] nums, long target, int start, int end) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = end - 1;
        while (lo < hi) {
            long currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (currSum > target || hi < end - 1 && nums[hi] == nums[hi + 1]) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[lo], nums[hi]));
                lo++;
                hi--;
            }
        }
        return res;
    }


    //official
    public static List<List<Integer>> kSum2(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // If we have run out of numbers to add, return res.
        if (start == nums.length) {
            return res;
        }

        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        long average_value = target / k;

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (nums[start] > average_value || average_value > nums[nums.length - 1]) {
            return res;
        }

        if (k == 2) {
            return twoSum2(nums, target, start);
        }

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum2(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }

        return res;
    }

    public static List<List<Integer>> twoSum2(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;

        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }

        return res;
    }
}
