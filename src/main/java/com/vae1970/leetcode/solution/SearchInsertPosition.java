package com.vae1970.leetcode.solution;

/**
 * Search Insert Position
 *
 * @author vae
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 2}, 0));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5) == 2);
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2) == 1);
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7) == 4);
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0) == 0);
    }

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                return i - 1 < 0 ? 0 : i;
            }
        }
        return nums.length;
    }

}
