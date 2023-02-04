package com.example.leetcode.hot100;

import com.example.leetcode.common.TreeNode;

import java.util.Arrays;

public class LeetCode_L105_ConstructBinaryTreefromPreorderandInorderTraversal {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }


    //5ms, 43.7MB
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        return buildNodeTraversal(preorder, inorder, 0, preorder.length, 0, inorder.length);

    }

    public static TreeNode buildNodeTraversal(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {
        if (preBegin >= preEnd || inBegin >= inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preBegin]);
        int index = inBegin;
        for (int i = inBegin; i < inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        root.left = buildNodeTraversal(preorder, inorder, preBegin + 1, preEnd, inBegin, index);
        root.right = buildNodeTraversal(preorder, inorder, preBegin + index - inBegin + 1, preEnd, index + 1, inEnd);

        return root;
    }


    //9ms, 42MB
    public static TreeNode buildTree3(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        TreeNode root = new TreeNode(preorder[0]);
        int deliIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                deliIndex = i;
                break;
            }
        }

        int[] leftInorder = {};
        int[] rightInorder = {};

        int[] leftPreorder = {};
        int[] rightPreorder = {};
        if (deliIndex == 0) {// 左节点为空  //1 2 //1 2
            rightPreorder = Arrays.copyOfRange(preorder, 1, preorder.length);
            rightInorder = Arrays.copyOfRange(inorder, 1, inorder.length);

        } else if (deliIndex == inorder.length - 1) {//右节点为空, //1 2 //2 1
            leftPreorder = Arrays.copyOfRange(preorder, 1, preorder.length);
            leftInorder = Arrays.copyOfRange(inorder, 0, deliIndex);
        } else {
            leftInorder = Arrays.copyOfRange(inorder, 0, deliIndex);
            rightInorder = Arrays.copyOfRange(inorder, deliIndex + 1, inorder.length);
            leftPreorder = Arrays.copyOfRange(preorder, 1, leftInorder.length + 1);
            rightPreorder = Arrays.copyOfRange(preorder, leftInorder.length + 1, preorder.length);

        }
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;

    }

    //25MS,67.1mb
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        TreeNode root = new TreeNode(preorder[0]);
        int deliIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                deliIndex = i;
                break;
            }
        }


        if (deliIndex == 0) {// 左节点为空  //1 2 //1 2
            root.left = null;
            int[] rightPreorder = Arrays.copyOfRange(preorder, 1, preorder.length);
            int[] rightInorder = Arrays.copyOfRange(inorder, 1, inorder.length);
            root.right = buildTree(rightPreorder, rightInorder);
        } else if (deliIndex == inorder.length - 1) {//右节点为空, //1 2 //2 1
            root.right = null;
            int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, preorder.length);
            int[] leftInorder = Arrays.copyOfRange(inorder, 0, deliIndex);
            root.left = buildTree(leftPreOrder, leftInorder);
        } else {
            int[] leftInorder = Arrays.copyOfRange(inorder, 0, deliIndex);
            int[] rightInorder = Arrays.copyOfRange(inorder, deliIndex + 1, inorder.length);

            int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftInorder.length + 1);
            int[] rightPreorder = Arrays.copyOfRange(preorder, leftInorder.length + 1, preorder.length);

            root.left = buildTree(leftPreorder, leftInorder);
            root.right = buildTree(rightPreorder, rightInorder);
        }


        return root;

    }
}
