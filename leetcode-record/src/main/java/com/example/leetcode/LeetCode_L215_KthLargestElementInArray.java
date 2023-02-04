package com.example.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode_L215_KthLargestElementInArray {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
//        System.out.println(findKthLargest(nums,2));
        System.out.println(findKthLargest(nums2, 4));
        Arrays.sort(nums2);
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
//        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2.intValue() - o1.intValue());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
//            if (!queue.contains(nums[i])) {
            queue.offer(nums[i]);
//            }
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
