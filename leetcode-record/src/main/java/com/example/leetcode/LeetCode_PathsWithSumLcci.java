package com.example.leetcode;

import com.example.leetcode.common.TreeNode;

/**
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/paths-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_PathsWithSumLcci {

    public static void main(String[] args) {

    }

    //TODO
    public static int pathSum(TreeNode root, int sum) {
        if (root == null || sum == 0) {
            return 0;
        }
        int count = 0;
        if (root.val == sum) {
            count++;
        }
        sum -= root.val;
        count += pathSum(root.left, sum);
        count += pathSum(root.right, sum);
        return count;
    }


}
