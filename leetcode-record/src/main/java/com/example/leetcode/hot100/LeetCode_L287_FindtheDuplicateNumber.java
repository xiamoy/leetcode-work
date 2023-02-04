package com.example.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_L287_FindtheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);//2

    }

    //hash
    public static int findDuplicate2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return nums[i];
            }
            map.put(nums[i], 1);
        }
        return 0;
    }

    //
    // https://leetcode.com/problems/find-the-duplicate-number/discuss/72846/My-easy-understood-solution-with-O(n)-time-and-O(1)-space-without-modifying-the-array.-With-clear-explanation.
    public static int findDuplicate(int[] nums) {
        if (nums.length < 2) {
            return -1;
        }

        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    // 1 3 4 2 2
    //   s   f
    //       s f
    //     s   f
    //         s/f  =>meet

    //f
    //   f s
    //       f s
    //
}
