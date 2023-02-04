package com.example.leetcode;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_L257_BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3)
        );
        System.out.println(binaryTreePaths(node));

    }

    //9ms,42.5MB
    public static List<String> binaryTreePaths1(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        String path = "";
        binaryTreePaths1(root, path, list);
        return list;
    }

    public static void binaryTreePaths1(TreeNode root, String path, List<String> list) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            path += root.val;
            list.add(path);
            return;
        }
        path += root.val + "->";
        binaryTreePaths1(root.left, path, list);
        binaryTreePaths1(root.right, path, list);

    }

    //11ms, 43.5MB
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        StringBuilder path = new StringBuilder();
        binaryTreePaths(root, path, list);
        return list;
    }

    public static void binaryTreePaths(TreeNode root, StringBuilder builder, List<String> list) {
        if (root == null) {
            return;
        }
        int length = builder.length();
        if (root.left == null && root.right == null) {
            builder.append(root.val);
            list.add(builder.toString());
            builder.delete(length, builder.length());
            return;
        }
        builder.append(root.val + "->");
        binaryTreePaths(root.left, builder, list);
        binaryTreePaths(root.right, builder, list);
        builder.delete(length, builder.length());
    }

}
