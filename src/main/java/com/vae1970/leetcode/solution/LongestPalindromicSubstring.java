package com.vae1970.leetcode.solution;

/**
 * Longest Palindromic Substring
 *
 * @author vae
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int tempLeft, tempRight, previous, next;
        int pointerLeft = 0, pointerRight = 0;
        int length = s.length(), max = length - 1;
        boolean rightEqual, leftAndRightEqual;
        if (length > 1) {
            for (int i = 0; i < max; i++) {
                previous = i - 1;
                next = i + 1;
                //  把当前值和右侧值比较是否相等
                rightEqual = s.charAt(i) == s.charAt(next);
                //  把左右两侧的值比较是否相等
                leftAndRightEqual = previous >= 0 && s.charAt(previous) == s.charAt(next);
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
                    if ((tempRight - tempLeft) > (pointerRight - pointerLeft)) {
                        pointerLeft = tempLeft;
                        pointerRight = tempRight;
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
        System.out.println(longestPalindrome("caa"));
        System.out.println(longestPalindrome("bananas"));
    }

}
