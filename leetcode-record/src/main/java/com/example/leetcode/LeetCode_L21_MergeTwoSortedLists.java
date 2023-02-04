package com.example.leetcode;

/**
 * Palindrome Number
 *
 * @link https://leetcode.com/problems/palindrome-number/
 */
public class LeetCode_L21_MergeTwoSortedLists {
    public static void main(String[] args) {

        ListNode21 list1 = new ListNode21(1, new ListNode21(2, new ListNode21(4)));
        ListNode21 list2 = new ListNode21(1, new ListNode21(3, new ListNode21(4)));
        System.out.println(mergeTwoLists(list1, list2));
    }

    // 1ms, 43M
    public static ListNode21 mergeTwoLists2(ListNode21 list1, ListNode21 list2) {
        ListNode21 head = new ListNode21(1), lHead = list1, rHead = list2;

        ListNode21 cur = head;
        while (lHead != null && rHead != null) {
            while (lHead != null && lHead.val <= rHead.val) {

                ListNode21 temp = new ListNode21(lHead.val);
                cur.next = temp;
                cur = cur.next;
                lHead = lHead.next;
            }
            while (rHead != null && lHead != null && lHead.val >= rHead.val) {
                ListNode21 temp = new ListNode21(rHead.val);
                cur.next = temp;
                cur = cur.next;
                rHead = rHead.next;
            }
        }


        if (lHead == null) {
            cur.next = rHead;
        } else {
            cur.next = lHead;
        }
        return head.next;
    }

    // 1ms, 43M
    public static ListNode21 mergeTwoLists3(ListNode21 list1, ListNode21 list2) {
        ListNode21 head = new ListNode21(1);
        ListNode21 cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = new ListNode21(list1.val);
                list1 = list1.next;
            } else {
                cur.next = new ListNode21(list2.val);
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next = list1 == null ? list2 : list1;
        return head.next;
    }

    public static ListNode21 mergeTwoLists(ListNode21 list1, ListNode21 list2) {
        ListNode21 head = new ListNode21(1);
        ListNode21 cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next = list1 == null ? list2 : list1;
        return head.next;
    }


    static class ListNode21 {
        int val;
        ListNode21 next;

        ListNode21() {
        }

        ListNode21(int val) {
            this.val = val;
        }

        ListNode21(int val, ListNode21 next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode21 cur = this;
            String res = cur.val + "";
            while (cur.next != null) {
                res += "->" + cur.next.val;
                cur = cur.next;
            }
            return res;
        }
    }
}


