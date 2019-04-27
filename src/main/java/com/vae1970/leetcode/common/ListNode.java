package com.vae1970.leetcode.common;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode toListNode(int[] array) {
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