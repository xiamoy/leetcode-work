package com.example.leetcode;


import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_L102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> list = levelOrder(treeNode);
        System.out.println(list);

    }

    //2ms, 43.6MB
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curList = new ArrayList<>();
            while (size-- > 0) {
                TreeNode cur = queue.removeFirst();
                curList.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            list.add(curList);
        }
        return list;
    }

    //1ms, 43MB
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderOnHeight(root, res, 0);
        return res;
    }

    public static void levelOrderOnHeight(TreeNode root, List<List<Integer>> res, int height) {
        if (root == null) {
            return;
        }
        if (height == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);
        levelOrderOnHeight(root.left, res, height + 1);
        levelOrderOnHeight(root.right, res, height + 1);
    }
}
