package com.example.leetcode.hot100;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;


public class LeetCode_L347_TopKFrequentElements {
    public static void main(String[] args) {

        int[] ints = topKFrequent4(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(ints);// 1,2

//        int[] ints = topKFrequent(new int[]{3,0,1,0}, 1);
//        System.out.println(ints);// 0


//        int[] ints = topKFrequent(new int[]{5,3,1,1,1,3,73,1}, 2);
//        System.out.println(ints);
    }

    public static int[] topKFrequent4(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int x : nums) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> freqMap.get(o1) - freqMap.get(o2));
        for (Integer key : freqMap.keySet()) {
            queue.offer(key);
            if (queue.size() > k) {
                queue.poll();
            }

        }

        int[] res = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            res[index++] = queue.poll();
        }
        return res;
    }


    public static int[] topKLargest(int[] nums, int k) {
        int[] res = new int[k];
        int start = 0, end = nums.length - 1;
        int pivot = pivot(nums, start, end);
        while (start < end) {
            if (pivot == k - 1) {
                break;
            } else if (pivot > k - 1) {
                end = pivot - 1;
            } else {
                start = pivot + 1;
            }
            pivot = pivot(nums, start, end);
        }
        res = Arrays.copyOf(nums, k);
        return res;
    }

    public static int pivot(int[] nums, int start, int end) {
        int left = start;

        int selIndex = new Random().nextInt(end - start + 1) + start;
        swap(nums, start, selIndex);
        for (int i = end; i > left; i--) {
            if (nums[i] >= nums[start]) {
                left++;
                swap(nums, i, left);
            }
        }
        left++;
        swap(nums, left, start);
        return left;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //11ms, 45.3MB
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int item : nums) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());

        map.entrySet().forEach(x -> {
            queue.add(x);
            if (queue.size() > k) {
                queue.poll();
            }

        });
        int[] res = new int[k];
        int index = 0;
        while (index < k) {
            res[index++] = queue.poll().getKey();
        }
        return res;

    }

    //571ms, 50.6MB
    public static int[] topKFrequent2(int[] nums, int k) {
        PriorityQueue<LNode> queue = new PriorityQueue<>((l1, l2) -> l1.freq - l2.freq);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int curCnt = countMap.getOrDefault(current, 0);
            LNode lNode = new LNode(current, curCnt);
            if (queue.size() < k) {
                if (queue.contains(lNode)) {
                    queue.remove(lNode);
                }
                lNode.freq++;
                queue.add(lNode);
            } else {
                if (queue.contains(lNode)) {
                    queue.remove(lNode);
                    lNode.freq++;
                    queue.add(lNode);
                } else if (queue.peek().freq <= curCnt) {
                    queue.poll();
                    lNode.freq++;
                    queue.add(lNode);
                } else {

                }
            }

            countMap.put(current, curCnt + 1);
        }

        int[] res = new int[queue.size()];
        int index = 0;
        while (!queue.isEmpty()) {
            res[index++] = queue.poll().val;
        }
        return res;

    }

    static class LNode {
        public int val;
        public int freq;

        public LNode(int val) {
            this.val = val;
        }

        public LNode(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof LNode) {
                LNode lnode = (LNode) obj;
                return val == lnode.val && freq == lnode.freq;
            }
            return false;
        }
    }
}
