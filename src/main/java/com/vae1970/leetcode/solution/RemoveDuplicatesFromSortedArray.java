package com.vae1970.leetcode.solution;

/**
 * Remove Duplicates from Sorted Array
 *
 * @author vae
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i + 1] = 0;


                i++;
            }
        }
    }

}
