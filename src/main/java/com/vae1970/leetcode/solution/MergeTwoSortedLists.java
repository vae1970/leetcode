package com.vae1970.leetcode.solution;

import com.vae1970.leetcode.common.ListNode;

import static com.vae1970.leetcode.common.ListNode.toListNode;

/**
 * Merge Two Sorted Lists
 *
 * @author vae
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = toListNode(new int[]{1, 5, 6});
        ListNode l2 = toListNode(new int[]{1, 2, 3});
        ListNode r = mergeTwoLists(l1, l2);
        System.out.println(1);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode temp = result;
        while (true) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    temp.next = l1;
                    l1 = l1.next;
                } else {
                    temp.next = l2;
                    l2 = l2.next;
                }
                temp = temp.next;
            } else {
                temp.next = l1 == null ? l2 : l1;
                break;
            }
        }
        return result.next;
    }

}
