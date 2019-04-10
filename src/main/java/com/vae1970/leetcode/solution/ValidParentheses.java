package com.vae1970.leetcode.solution;

/**
 * Valid Parentheses
 *
 * @author vae
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()") == true);
        System.out.println(isValid("()[]{}") == true);
        System.out.println(isValid("(]") == false);
        System.out.println(isValid("([)]") == false);
        System.out.println(isValid("{[]}") == true);
        System.out.println(isValid("{}{}()[]") == true);
        System.out.println(isValid("([]") == false);
        System.out.println(isValid("(([]){})") == true);
    }

    public static boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }
        Integer next;
        int length = 0;
        boolean[] bucket = new boolean[s.length()];
        for (int i = 0; i < s.length(); ) {
            if (!bucket[i]) {
                next = getNext(i, bucket);
                if (next != null && equal(s.charAt(i), s.charAt(next))) {
                    bucket[i] = true;
                    bucket[next] = true;
                    length += 2;
                    i = getPrevious(i, bucket);
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return s.length() == length;
    }

    public static Integer getPrevious(Integer index, boolean[] bucket) {
        while (--index >= 0) {
            if (!bucket[index]) {
                return index;
            }
        }
        index = getNext(index, bucket);
        return index == null ? 0 : index;
    }

    public static Integer getNext(int index, boolean[] bucket) {
        while (++index < bucket.length) {
            if (!bucket[index]) {
                return index;
            }
        }
        return null;
    }

    public static boolean equal(char a, char b) {
        if (a == '{') {
            return b == '}';
        } else if (a == '(') {
            return b == ')';
        } else if (a == '[') {
            return b == ']';
        } else {
            return false;
        }
    }

}
