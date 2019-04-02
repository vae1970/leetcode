package com.vae1970.leetcode.solution;

/**
 * Longest Palindromic Substring
 *
 * @author vae
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int tempLeft, tempRight, pointerLeft = 0, pointerRight = 0;
        int length = s.length(), max = length - 1;
        if (length > 1) {
            if (s.charAt(0) == s.charAt(1)) {
                pointerRight = 1;
            }
            if (length > 2) {
                for (int i = 1; i < max; i++) {
                    int previous = i - 1;
                    int next = i + 1;
                    boolean rightEqual = s.charAt(i) == s.charAt(next);
                    boolean leftAndRightEqual = s.charAt(previous) == s.charAt(next);
                    while (rightEqual || leftAndRightEqual) {
                        if (rightEqual) {
                            tempLeft = i;
                            tempRight = next;
                            rightEqual = false;
                        } else {
                            tempLeft = previous;
                            tempRight = next;
                            leftAndRightEqual = false;
                        }
                        for (; tempLeft > 0 && tempRight < max; ) {
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
