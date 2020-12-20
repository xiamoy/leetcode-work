package com.example.nowcoder;


/**
 * 反转链表
 * @link https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=190&&tqId=35203&rp=1&ru=/activity/oj&qru=/ta/job-code-high-rd/question-ranking
 */
public class NowCoder_NC78 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;

        Solution_NC78 solution_nc78=new Solution_NC78();
        ListNode listNode = solution_nc78.ReverseListByOthers(node1);
        System.out.println(listNode);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution_NC78{

    // self committed
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode listNode = new ListNode(head.val);
        while (head.next != null) {
            ListNode temp = new ListNode(head.next.val);
            temp.next = listNode;
            listNode = temp;
            head = head.next;
        }
        return listNode;
    }


    public ListNode ReverseListByOthers(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null;
        ListNode cur = head;

        ListNode pre = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return newHead;
    }
}