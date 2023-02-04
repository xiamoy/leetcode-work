package com.example.leetcode;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
前序：中左右
 */
public class LeetCode_L144_BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        System.out.println(preorderTraversal(treeNode));// 1,3,2
    }

    //1ms,42.3 MB
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }

    public static void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }

    //1ms, 42.4MB
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

        }
        return list;
    }

}
