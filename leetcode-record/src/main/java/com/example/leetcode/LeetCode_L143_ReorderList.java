package com.example.leetcode;

import com.example.leetcode.common.ListNode;

public class LeetCode_L143_ReorderList {
    public static void main(String[] args) {
        ListNode cur = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList(cur);
        System.out.println(cur);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right;
        if (fast == null) {// 1 2 3 4
            right = slow;
            pre.next = null;
        } else {
            right = slow.next;
            slow.next = null;
        }
        ListNode l1 = head, l2 = reverse(right);

        while (l1 != null && l2 != null) {
            // 1 2 3
            // 5 4
            ListNode lNext1 = l1.next;
            ListNode lNext2 = l2.next;
            l1.next = l2;
            l2.next = lNext1;
            l1 = lNext1;
            l2 = lNext2;
        }

    }

    public static ListNode reverse(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode pre = null, cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
