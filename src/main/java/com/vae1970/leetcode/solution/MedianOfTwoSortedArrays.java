package com.vae1970.leetcode.solution;

import java.util.Arrays;

/**
 * Median of Two Sorted Arrays
 * (内存占用大)
 *
 * @author vae
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] array = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 8, 10};
        sort(array, 0, array.length - 1);
        Arrays.stream(array).forEach(i -> System.out.print(i + " "));
        System.out.println();
        double result = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println(result);
    }

    public static void sort(int[] array, int start, int end) {
        int i = start;
        int j = end;
        boolean out = false;
        if (start != end) {
            while (true) {
                if (compare(array[j], array[start]) < 0) {
                    for (; i < j; i++) {
                        if (compare(array[i], array[start]) > 0) {
                            swap(array, i, j);
                            out = true;
                            break;
                        }
                    }
                }
                if (out) {
                    out = false;
                } else {
                    if (i < j) {
                        j--;
                    } else {
                        break;
                    }
                }
            }
            if (start != j) {
                swap(array, start, j);
            }
            if (i > start) {
                i--;
            }
            if (j < end) {
                j++;
            }
            if (start != i) {
                sort(array, start, i);
            }
            if (j != end) {
                sort(array, j, end);
            }
        }
    }

    public static void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    public static int compare(int a, int b) {
        return a - b;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        int[] array = new int[length];
        for (int i = 0; i < length1; i++) {
            array[i] = nums1[i];
        }
        for (int j = 0; j < length2; j++) {
            array[j + length1] = nums2[j];
        }
        sort(array, 0, array.length - 1);
        int half = length / 2;
        return length % 2 == 0 ? ((double) array[half - 1] + array[half]) / 2 : array[half];
    }

}
