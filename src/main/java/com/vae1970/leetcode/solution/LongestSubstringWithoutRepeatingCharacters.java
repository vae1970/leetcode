package com.vae1970.leetcode.solution;

/**
 * Longest Substring Without Repeating Characters
 *
 * @author vae
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String a = "pwwkew";
        int lengthA = lengthOfLongestSubstring(a);
        System.out.println(lengthA);
        System.out.println("----------------------");
        String b = "bbbbb";
        int lengthB = lengthOfLongestSubstring(b);
        System.out.println(lengthB);
        System.out.println("----------------------");
        String c = "pwwkew";
        int lengthC = lengthOfLongestSubstring(c);
        System.out.println(lengthC);


    }

    public static int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int maxIndex = 0, tempMax = 0, max = 0;
        for (int i = 0, im = array.length; i < im; i++) {
            maxIndex = i;
            for (int j = i + 1; j < im; j++) {
                if (exists(array, i, j)) {
                    maxIndex = j;
                    break;
                }
            }
            maxIndex = maxIndex == i ? im : maxIndex;
            tempMax = maxIndex - i;
            max = tempMax > max ? tempMax : max;
        }
        return max;
    }

    public static boolean exists(char[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            if (array[end] == array[i]) {
                return true;
            }
        }
        return false;
    }

}
