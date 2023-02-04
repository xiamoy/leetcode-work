package com.example.leetcode;

import com.example.leetcode.common.ListNode;

public class LeetCode_L142_LinkedListCycleII {
    public static void main(String[] args) {

    }

    // 1ms,42.5MB
    // slow steps: s, fast steps: f
    // head to cycleEntry: a个节点, cycle:b个节点
    // f=2s = s +nb =》 s=nb
    //s+a => a, nb+a = a
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;

                }
                return slow;
            }
        }
        return null;
    }
}
