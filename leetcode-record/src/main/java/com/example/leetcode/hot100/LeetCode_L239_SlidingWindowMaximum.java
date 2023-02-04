package com.example.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class LeetCode_L239_SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = maxSlidingWindow3(nums, 3);//3,3,5,5,6,7
        System.out.println(ints);

    }

    //216ms, 117MB
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> nums[o2] - nums[o1]);

        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && i - k >= queue.peek()) {
                queue.poll();
            }
            queue.offer(i);
            if (queue.size() >= k) {
                res[index++] = nums[queue.peek()];
            }
        }

        return res;
    }

    //70ms, 149.9MB
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peekFirst() + k <= i) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            queue.offerLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

}
