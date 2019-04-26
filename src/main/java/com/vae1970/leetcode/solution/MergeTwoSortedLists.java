package com.vae1970.leetcode.solution;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = toListNode(new int[]{1, 2, 4});
        ListNode l2 = toListNode(new int[]{1, 3, 4});
        mergeTwoLists(l1, l2);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tempA, tempB;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        while (l1.next != null) {
            tempA = l1.next;
            l1.next = l2;
            tempB = l2.next;
            l2.next = tempA;
            l2 = tempB;
        }
        return l1;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode toListNode(int[] array) {
        if (array.length == 0) {
            return null;
        }
        ListNode listNode = new ListNode(array[0]);
        ListNode tempListNode = listNode;
        for (int i = 1, im = array.length; i < im; i++) {
            tempListNode.next = new ListNode(array[i]);
            tempListNode = tempListNode.next;
        }
        return listNode;
    }
}
