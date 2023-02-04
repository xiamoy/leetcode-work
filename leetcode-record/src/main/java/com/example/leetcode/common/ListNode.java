package com.example.leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode cur = this;
        String res = cur.val + "";
        while (cur.next != null) {
            res += "->" + cur.next.val;
            cur = cur.next;
        }
        return res;
    }
}
