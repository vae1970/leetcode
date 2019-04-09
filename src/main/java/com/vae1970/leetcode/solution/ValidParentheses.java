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
        if (s.length() % 2 == 1) {
            return false;
        }
        int size = 0, start = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (equal(s.charAt(i), s.charAt(i + 1))) {
                size = i - start + 1;
                for (int j = i + 1, jm = i + size + 1; j < jm; j++) {
                    if (!equal(s.charAt(i--), s.charAt(j))) {
                        return false;
                    }
                }
                i = start + size * 2 - 1;
                start = i + 1;
            }
        }
        return size > 0;
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
