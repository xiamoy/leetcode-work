package com.example.leetcode;

import com.example.leetcode.common.ListNode;

public class LeetCode_L707_DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

    }
}

class MyLinkedList {

    private int size;
    private ListNode dummy = new ListNode(-1);


    public MyLinkedList() {

    }

    public int get(int index) {
        if (index > size - 1 || index < 0) {
            return -1;
        }
        ListNode cur = dummy.next;
        while (index-- > 0) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode addNode = new ListNode(val);
        addNode.next = dummy.next;
        dummy.next = addNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode cur = dummy;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            index = 0;
        }
        if (index == size) {
            index = size - 1;
        }
        ListNode cur = dummy;
        while (index-- > 0) {
            cur = cur.next;
        }
        ListNode addNode = new ListNode(val);
        addNode.next = cur.next;
        cur.next = addNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index > size - 1 || index < 0) {
            return;
        }
        ListNode cur = dummy;
        while (index-- > 0) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}


