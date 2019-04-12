package com.vae1970.leetcode.solution;

/**
 * Remove Duplicates from Sorted Array
 *
 * @author vae
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{}));
        System.out.println(removeDuplicates(new int[]{1}));
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(removeDuplicates(new int[]{-1, 0, 0, 0, 0, 3, 3}));
        System.out.println(removeDuplicates(new int[]{-3, -1, -1}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int temp = nums[0], length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (temp != nums[i]) {
                temp = nums[i];
                nums[length++] = temp;
            }
        }
        return length;
    }

}
