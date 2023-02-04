package com.example.leetcode.hot100;

import com.example.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_L337_HouseRobberIII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(3, null, new TreeNode(1)));

        int res = rob(root);
        System.out.println(res);//7

    }


    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, Integer> map = new HashMap<>();
        int res1 = backtrack(root, map);
        return res1;
    }


    public static int backtrack(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) {
            return 0;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        if (node.left == null && node.right == null) {
            int res = node.val;
            map.put(node, res);
            return res;
        }

        int val = node.val;
        if (node.left != null) {
            val += backtrack(node.left.left, map) + backtrack(node.left.right, map);
        }
        if (node.right != null) {
            val += backtrack(node.right.left, map) + backtrack(node.right.right, map);
        }
        int result = Math.max(backtrack(node.left, map) + backtrack(node.right, map), val);
        map.put(node, result);
        return result;
    }
}
