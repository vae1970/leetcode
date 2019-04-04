package com.vae1970.leetcode.solution;

/**
 * Longest Common Prefix
 *
 * @author vae
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = getMinLength(strs);
        char temp;
        for (int i = 0; i < length; i++) {
            temp = strs[0].charAt(i);
            for (int j = 1, jm = strs.length; j < jm; j++) {
                if (temp != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, length);
    }

    public static int getMinLength(String[] strs) {
        int length = strs[0].length();
        for (int i = 1, im = strs.length; i < im; i++) {
            if (strs[i].length() < length) {
                length = strs[i].length();
            }
        }
        return length;
    }

}
