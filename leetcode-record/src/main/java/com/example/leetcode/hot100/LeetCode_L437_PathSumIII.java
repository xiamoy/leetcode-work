package com.example.leetcode.hot100;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeetCode_L437_PathSumIII {
    public static void main(String[] args) {
//        TreeNode root=new TreeNode(3,
//                new TreeNode(4,new TreeNode(5),new TreeNode(1)),
//                new TreeNode(2,null,new TreeNode(9)));
//        System.out.println(maxInEachLevel(root));

// 1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000
        TreeNode leftNode = new TreeNode(1000000000, new TreeNode(294967296,
                new TreeNode(1000000000, new TreeNode(1000000000, new TreeNode(1000000000, null, null), null), null), null), null);
        TreeNode root = new TreeNode(1000000000, leftNode, null);
        System.out.println(pathSum(root, 0));

    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Long, Integer> preSum = new HashMap<>();
        preSum.put(0L, 1);

        return sumTraversal(root, 0L, sum, preSum);
    }

    public static int sumTraversal(TreeNode node, long curSum, int target, Map<Long, Integer> preSum) {
        if (node == null) {
            return 0;
        }
        curSum += node.val;
        int count = preSum.getOrDefault(curSum - target, 0);
        int exist = preSum.getOrDefault(curSum, 0);
        preSum.put(curSum, exist + 1);
        count += sumTraversal(node.left, curSum, target, preSum);
        count += sumTraversal(node.right, curSum, target, preSum);
        preSum.put(curSum, exist);
        return count;
    }


    public static int pathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }


        return sumTraversal(root, 0, targetSum) +
                pathSum2(root.left, targetSum) + pathSum2(root.right, targetSum);
    }

    public static int sumTraversal(TreeNode cur, long curSum, long target) {
        if (cur == null) {
            return 0;
        }
        curSum += cur.val;
        int count = 0;
        if (curSum == target) {
            count++;
        }
        return count + sumTraversal(cur.left, curSum, target) + sumTraversal(cur.right, curSum, target);
    }


    public static int leastLeftAtBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        int size = queue.size();
        int index = 0;
        int bot = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();

            if (index == 0) {
                bot = poll.val;
            }
            index++;
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            if (index == size) {
                index = 0;
                size = queue.size();
            }

        }
        return bot;
    }


    public static List<Integer> maxInEachLevel(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        int size = queue.size();
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            max = Math.max(max, node.val);
            size--;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (size == 0) {
                size = queue.size();
                list.add(max);
                max = Integer.MIN_VALUE;
            }
        }
        return list;
    }


}
