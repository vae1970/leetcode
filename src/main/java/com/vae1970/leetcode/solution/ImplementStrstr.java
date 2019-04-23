package com.vae1970.leetcode.solution;

/**
 * Implement strStr()
 *
 * @author vae
 */
public class ImplementStrstr {

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("aaaaa", ""));
        System.out.println(strStr("", "bba"));
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("aaa", "aaaa"));
        System.out.println(strStr("mississippi", "issip"));
    }

    public static int strStr(String haystack, String needle) {
        int length = 0, index = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (length < needle.length()) {
                if (haystack.charAt(i) == needle.charAt(length)) {
                    length++;
                } else {
                    length = 0;
                }
            } else if (length == needle.length()) {
                index = i - length;
                break;
            }
        }
        if (needle.length() == 0) {
            return 0;
        } else if (needle.length() == length) {
            return index < 0 ? haystack.length() - length : index;
        } else {
            return -1;
        }
    }

}
