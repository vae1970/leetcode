package com.vae1970.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Group Anagrams
 *
 * @author vae
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] s = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(s));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean empty = false;
        List<Long> hashArray = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            Long hash = hash(strs[i]);
            if (hash == null) {
                empty = true;
            } else {

            }

        }


    }

    public static Long hash(String s) {
        Long hash = null;
        if (s != null) {
            hash = 0L;
            for (int j = 0; j < s.length(); j++) {
                hash += s.charAt(j);
            }
        }
        return hash;
    }

}
