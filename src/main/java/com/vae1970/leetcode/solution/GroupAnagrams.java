package com.vae1970.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Group Anagrams
 *
 * @author vae
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] s = new String[]{"eat", "tea", "tan", "ate", "nat", "bat", "", ""};
        String[] s1 = new String[]{"", "b"};
        String[] s2 = new String[]{"tea", "", "eat", "", "tea", ""};
        String[] s3 = new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
        String[] s4 = new String[]{"duh", "ill"};
        System.out.println(groupAnagrams(s));
        System.out.println(groupAnagrams(s1));
        System.out.println(groupAnagrams(s2));
        System.out.println(groupAnagrams(s3));
        System.out.println(groupAnagrams(s4));
        System.out.println(groupAnagrams(new String[]{""}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<String> hashList = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String hash = hash(strs[i]);
            int index = getIndex(hash, hashList);
            List<String> list = get(result, index);
            list.add(strs[i]);
        }
        return result;
    }

    public static String hash(String s) {
        if (s == null) {
            return null;
        } else {
            char[] chars = s.toCharArray();
            sort(chars, 0, chars.length - 1);
            return new String(chars);
        }
    }

    public static int getIndex(String hash, List<String> hashList) {
        int index = hashList.indexOf(hash);
        if (index < 0) {
            hashList.add(hash);
            return hashList.size() - 1;
        } else {
            return index;
        }
    }

    public static List<String> get(List<List<String>> list, int index) {
        List<String> result;
        if (list.size() > index) {
            result = list.get(index);
        } else {
            result = new ArrayList<>();
            list.add(result);
        }
        return result;
    }

    public static void sort(char[] array, int start, int end) {
        int i = start;
        int j = end;
        boolean out = false;
        if (start < end) {
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

    public static void swap(char[] array, int start, int end) {
        char temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    public static int compare(int a, int b) {
        return a - b;
    }


}
