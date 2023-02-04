package com.example.leetcode.hot100;

import com.example.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_L297_SerializeandDeserializeBinaryTree {
    public static void main(String[] args) {
        LeetCode_L297_SerializeandDeserializeBinaryTree exec = new LeetCode_L297_SerializeandDeserializeBinaryTree();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        String serialize = exec.serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = exec.deserialize(serialize);
        System.out.println(exec.serialize(deserialize));

    }

    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        buildString(root, builder);
        return builder.toString();

    }

    public void buildString(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("#").append(",");
        } else {
            builder.append(node.val + ",");
            buildString(node.left, builder);
            buildString(node.right, builder);
        }
    }

    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] strArr = data.split(",");
        LinkedList<String> list = new LinkedList<>();
        list.addAll(Arrays.asList(strArr));
        return buildNode(list);
    }

    public TreeNode buildNode(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String s = list.removeFirst();
        if ("#".equals(s)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = buildNode(list);
        node.right = buildNode(list);
        return node;
    }


    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return 1 + Math.max(left, right);
    }

    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        if (root == null) {
            return "#";
        }
        int level = getDepth(root);
        int len = 1 << level;
        String[] records = new String[len - 1];

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 0;
        while (index < len - 1) {
            TreeNode pop = queue.poll();

            if (pop == null) {
                records[index] = "#";
                queue.offer(null);
                queue.offer(null);
            } else {
                records[index] = pop.val + "";
                queue.offer(pop.left);
                queue.offer(pop.right);
            }
            index++;

        }
        return String.join(",", records);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        int len = nodes.length;
        TreeNode[] treeNodes = new TreeNode[len];
        treeNodes[0] = "#".equals(nodes[0]) ? null : root;

        for (int i = 0; 2 * i + 2 < len; i++) {
            if (treeNodes[i] != null) {
                treeNodes[2 * i + 1] = "#".equals(nodes[2 * i + 1]) ? null : new TreeNode(Integer.parseInt(nodes[2 * i + 1]));
                treeNodes[2 * i + 2] = "#".equals(nodes[2 * i + 2]) ? null : new TreeNode(Integer.parseInt(nodes[2 * i + 2]));
                treeNodes[i].left = treeNodes[2 * i + 1];
                treeNodes[i].right = treeNodes[2 * i + 2];
            }

        }

        return root;

    }


}
