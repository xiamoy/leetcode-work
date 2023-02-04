package com.example.leetcode;

import com.example.leetcode.common.ListNode;

public class LeetCode_L141_LinkedListCycle {
    public static void main(String[] args) {

    }

    //快慢指针，快：走两步，慢：走一步
    //如果有环，在环内相遇
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
