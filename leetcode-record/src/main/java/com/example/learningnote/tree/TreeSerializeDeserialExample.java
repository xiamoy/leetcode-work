package com.example.learningnote.tree;

import com.example.learningnote.TreeNode;

import java.util.Stack;

public class TreeSerializeDeserialExample {

    public static void main(String[] args) {
        TreeNode leftNode1 = new TreeNode(5, null, null);
        TreeNode leftNode = new TreeNode(2, leftNode1, null);

        TreeNode rightNode1 = new TreeNode(6, null, null);

        TreeNode rightNode = new TreeNode(3, null, rightNode1);
        TreeNode treeNode = new TreeNode(1, leftNode, rightNode);

//        String res = serializeNode(treeNode, 0);
//        System.out.println(res);

    }

    //TODO
    public static String serializeNode(TreeNode node, int n) {
        //by layer
        if (node == null) {
            return "null#";
        }
        String res = "";
        Stack<TreeNode> stack = new Stack();
        stack.push(node);
        TreeNode cur = node;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            res += cur.getValue() + "#";
            stack.push(cur.getRight());
            stack.push(cur.getLeft());

        }
        return res;
    }


}
