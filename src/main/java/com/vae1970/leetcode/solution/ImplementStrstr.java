package com.vae1970.leetcode.solution;

/**
 * Implement strStr()
 *
 * @author vae
 */
public class ImplementStrstr {

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll") == 2);
        System.out.println(strStr("aaaaa", "bba") == -1);
        System.out.println(strStr("aaaaa", "") == 0);
        System.out.println(strStr("", "bba") == -1);
        System.out.println(strStr("a", "a") == 0);
        System.out.println(strStr("aaa", "aaaa") == -1);
        System.out.println(strStr("mississippi", "issip") == 4);
        System.out.println(strStr("mississippi", "pi") == 9);
    }

    /**
     * strStr
     *
     * @param haystack haystack
     * @param needle   needle
     * @return
     * @deprecated 还有优化的空间
     */
    @Deprecated
    public static int strStr(String haystack, String needle) {
        int index = 0, length = 0;
        for (int i = 0; i < haystack.length(); i++) {
            index = i;
            while (i < haystack.length()) {
                if (length == needle.length()) {
                    return index;
                } else if (haystack.charAt(i) == needle.charAt(length)) {
                    length++;
                    i++;
                } else {
                    length = 0;
                    i = index;
                    break;
                }
            }
        }
        return length == needle.length() ? index : -1;
    }

}
