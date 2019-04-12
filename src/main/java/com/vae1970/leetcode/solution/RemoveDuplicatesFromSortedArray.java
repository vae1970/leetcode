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
        int i = 0, j;
        int length = 0;
        while (i < nums.length - 1) {
            j = i + 1;
            nums[length++] = nums[i];
            if (nums[i] == nums[j]) {
                for (j++; j < nums.length; j++) {
                    if (nums[i] != nums[j]) {
                        break;
                    }
                }
                i = j;
            } else {
                i++;
            }
        }
        if (nums[nums.length - 2] != nums[nums.length - 1]) {
            nums[length++] = nums[nums.length - 1];
        }
        return length;
    }

}
