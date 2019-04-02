package com.vae1970.leetcode.solution;

/**
 * Longest Palindromic Substring
 *
 * @author vae
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int tempLeft, tempRight, pointerLeft = 0, pointerRight = 0;
        int length = s.length();
        if (length > 1) {
            if (s.charAt(0) == s.charAt(1)) {
                pointerRight = 1;
            }
            if (length > 2) {
                for (int i = 1, im = length - 1; i < im; i++) {
                    boolean rightEqual = s.charAt(i) == s.charAt(i + 1);
                    boolean leftAndRightEqual = s.charAt(i - 1) == s.charAt(i + 1);
                    while (rightEqual || leftAndRightEqual) {
                        if (rightEqual) {
                            tempLeft = i;
                            tempRight = i + 1;
                            rightEqual = false;
                        } else {
                            tempLeft = i - 1;
                            tempRight = i + 1;
                            leftAndRightEqual = false;
                        }
                        for (; tempLeft > 0 && tempRight < length - 1; ) {
                            tempLeft--;
                            tempRight++;
                            if (s.charAt(tempLeft) != s.charAt(tempRight)) {
                                tempLeft++;
                                tempRight--;
                                break;
                            }
                        }
                        if ((tempRight - tempLeft) - (pointerRight - pointerLeft) > 0) {
                            pointerLeft = tempLeft;
                            pointerRight = tempRight;
                        }
                    }
                }
            }
            return s.substring(pointerLeft, pointerRight + 1);
        } else {
            return s;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aba"));
        System.out.println(longestPalindrome("aaaa"));
        System.out.println(longestPalindrome("aaa"));
        System.out.println(longestPalindrome("aa"));
    }

}
