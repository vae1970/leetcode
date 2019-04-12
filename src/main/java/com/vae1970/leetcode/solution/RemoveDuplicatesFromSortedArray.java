package com.vae1970.leetcode.solution;

import java.util.Arrays;

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
        int i = 0, temp, length = 0, im = nums.length - 1;
        while (i < im) {
            nums[length++] = nums[i];
            temp = nums[i];
            for (i++; i < im; i++) {
                if (temp != nums[i]) {
                    break;
                }
            }
        }
        if (nums[nums.length - 2] != nums[im]) {
            nums[length++] = nums[im];
        }
        return length;
    }

}
