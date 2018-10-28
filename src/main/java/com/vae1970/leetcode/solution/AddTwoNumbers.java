package com.vae1970.leetcode.solution;

/**
 * @author vae
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        int[] a = {5};
        ListNode augendNode = toListNode(a);
        int[] b = {5};
        ListNode addendNode = toListNode(b);
        ListNode sum = addTwoNumbers(augendNode, addendNode);
        System.out.println(sum);
    }

    public static ListNode addTwoNumbers(ListNode augendNode, ListNode addendNode) {
        int max = 10, carry = 0, sum, augend = 0, addend = 0;
        ListNode listNode = new ListNode(0);
        ListNode tempListNode = listNode;

        boolean on;
        do {
            if (augendNode != null) {
                augend = augendNode.val;
                augendNode = augendNode.next;
            }
            if (addendNode != null) {
                addend = addendNode.val;
                addendNode = addendNode.next;
            }
            sum = augend + addend + carry;
            carry = sum < max ? 0 : sum / max;
            tempListNode = tempListNode.next = new ListNode(sum % max);
            augend = addend = 0;
            on = !(augendNode == null && addendNode == null && carry == 0);
        } while (on);

        tempListNode = listNode.next;
        listNode.next = null;
        return tempListNode;
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


}
