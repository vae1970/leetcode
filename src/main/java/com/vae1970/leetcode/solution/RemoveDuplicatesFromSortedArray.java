package com.vae1970.leetcode.solution;

import java.util.Arrays;

/**
 * Remove Duplicates from Sorted Array
 *
 * @author vae
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public static int removeDuplicates(int[] nums) {
        int j;
        for (int i = 0; i < nums.length - 1; i++) {
            j = i + 1;
            if (nums[i] == nums[j]) {
                nums[j] = 0;
                for (j++; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        nums[j] = 0;
                    } else {
                        break;
                    }
                }
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > -1) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }

}
