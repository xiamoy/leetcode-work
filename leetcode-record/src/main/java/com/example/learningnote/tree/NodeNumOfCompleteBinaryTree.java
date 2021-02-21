package com.example.learningnote.tree;

import com.example.learningnote.TreeNode;

/**
 * 完全二叉树：每层从左到右满足节点依次完整性(子左节点不存在 子右节点不能存在)
 * <p>
 *      1
 *   2     3
 *  4  5  6  7
 * 8
 *
 *
 */
public class NodeNumOfCompleteBinaryTree {


    public static TreeNode getTree1() {
        TreeNode l1 = new TreeNode(8, null, null);
        TreeNode l2 = new TreeNode(4, l1, null);
        TreeNode l3 = new TreeNode(2, l2, new TreeNode(5, null, null));

        TreeNode r1 = new TreeNode(6, null, null);
        TreeNode r2 = new TreeNode(7, null, null);
        TreeNode r3 = new TreeNode(3, r1, r2);

        TreeNode treeNode = new TreeNode(1, l3, r3);
        return treeNode;
    }

    public static TreeNode getTree2() {
        TreeNode l1 = new TreeNode(8, null, null);
        TreeNode l2 = new TreeNode(4, l1, new TreeNode(9, null, null));
        TreeNode l3 = new TreeNode(2, l2, new TreeNode(5,
                new TreeNode(10, null, null),
                new TreeNode(11, null, null)));

        TreeNode r1 = new TreeNode(6, new TreeNode(12, null, null), null);
        TreeNode r2 = new TreeNode(7, null, null);
        TreeNode r3 = new TreeNode(3, r1, r2);

        TreeNode treeNode = new TreeNode(1, l3, r3);
        return treeNode;
    }

    public static void main(String[] args) {


        TreeNode treeNode = getTree1();
        // 8
        System.out.println(getNode(treeNode));

        TreeNode treeNode2 = getTree2();
        System.out.println(getNode(treeNode2));

//        System.out.println(1<<0);  //2^0
//        System.out.println(1<<1);  //2^1
//        System.out.println(1<<2);  //2^2
//        System.out.println(1<<3);  //2^3
    }

    // time cost: 小于O(N)
    public static int getNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int height = getHeight(node,0);
        return getSubNode(node, 1, height);
    }

    public static int getSubNode(TreeNode node, int level, int height) {
        if (level == height) {
            return 1;
        }

        //右子树是否达到最后一层

        if (getHeight(node.getRight(),level) == height) {
            //左子树是满二叉树  1<<(height-level) == 2^(height-level)
            return (1 << (height-level)) + getSubNode(node.getRight(), level + 1, height);
        } else {
            //右子树是满二叉树,height -1
            return (1 << (height-level-1)) + getSubNode(node.getLeft(), level + 1, height);
        }

    }


    public static int getHeight(TreeNode node,int level) {
        while (node != null) {
            level++;
            node = node.getLeft();
        }
        return level;
    }
}
