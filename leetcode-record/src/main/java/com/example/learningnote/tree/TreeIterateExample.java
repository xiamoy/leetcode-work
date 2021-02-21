package com.example.learningnote.tree;

import com.example.learningnote.TreeNode;

import java.util.Stack;

public class TreeIterateExample {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, leftNode(), rightNode());

        System.out.println("preOrderRecur------");
        preOrderRecur(treeNode);
        System.out.println();


        System.out.println("preOrderUnRecur------");
        preOrderUnRecur(treeNode);
        System.out.println();

        System.out.println("inOrderRecur------");
        inOrderRecur(treeNode);
        System.out.println();

        System.out.println("inOrderUnRecur------");
        inOrderUnRecur(treeNode);
        System.out.println();

//        postOrderRecur(treeNode);

    }

    public static TreeNode leftNode() {
        TreeNode t1 = new TreeNode(5, null, null);
        TreeNode t2 = new TreeNode(7, null, null);
        TreeNode left = new TreeNode(2, t1, t2);
        return left;
    }

    public static TreeNode rightNode() {
        TreeNode t1 = new TreeNode(6, null, null);
        TreeNode t2 = new TreeNode(4, t1, null);
        TreeNode left = new TreeNode(3, t2, null);
        return left;
    }

    public static void preOrderRecur(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.getValue() + " ");
        preOrderRecur(treeNode.getLeft());
        preOrderRecur(treeNode.getRight());
    }

    public static void inOrderRecur(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrderRecur(treeNode.getLeft());
        System.out.print(treeNode.getValue() + " ");
        inOrderRecur(treeNode.getRight());
    }

    public static void postOrderRecur(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrderRecur(treeNode.getLeft());
        postOrderRecur(treeNode.getRight());
        System.out.print(treeNode.getValue() + " ");
    }

    public static void preOrderUnRecur(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        TreeNode cur = treeNode;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            System.out.print(cur.getValue() + " ");

            if (cur.getRight() != null) {
                stack.push(cur.getRight());
            }
            if (cur.getLeft() != null) {
                stack.push(cur.getLeft());
            }
        }

    }

    public static void inOrderUnRecur(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = treeNode;
        while (!stack.isEmpty() || cur != null) {
            if (cur == null) {
                cur = stack.pop();
                System.out.print(cur.getValue() + " ");
                cur = cur.getRight();
            } else {
                stack.push(cur);
                cur = cur.getLeft();
            }
        }

    }

}
