package com.example.leetcode;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
后序：左右中
 */
public class LeetCode_L145_BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        System.out.println(postorderTraversal(treeNode)); //1 2 3
    }


    //0ms, 42.3MB
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        postorderTraversal(root, list);
        return list;
    }

    public static void postorderTraversal(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
    }

    //1ms,42.8MB
    public static List<Integer> postorderTraversal3(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return list;
    }

    //1ms, 40.1MB
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        // 压栈 pop出来加入list的顺序 中右左
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        //反转list，得到左右中，即为后序
        Collections.reverse(list);
        return list;
    }


}
