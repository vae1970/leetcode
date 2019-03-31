package com.vae1970.leetcode.solution;

/**
 * Roman to Integer
 *
 * @author vae
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(1 == romanToInt("I"));
        System.out.println(3 == romanToInt("III"));
        System.out.println(1051 == romanToInt("ILM"));
        System.out.println(4 == romanToInt("IV"));
        System.out.println(9 == romanToInt("IX"));
        System.out.println(58 == romanToInt("LVIII"));
        System.out.println(1994 == romanToInt("MCMXCIV"));
        System.out.println(1695 == romanToInt("MDCXCV"));
    }

    public static int romanToInt(String s) {
        int result = 0;
        int length = s.length();
        int max = length - 1;
        for (int i = 0; i < length; i++) {
            char a = s.charAt(i);
            char b = i == max ? ' ' : s.charAt(i + 1);
            boolean special = (a == 'I' && (b == 'V' || b == 'X'))
                    || (a == 'X' && (b == 'L' || b == 'C'))
                    || (a == 'C' && (b == 'D' || b == 'M'));
            if (special) {
                result += romanToInt(b) - romanToInt(a);
                i++;
            } else {
                result += romanToInt(a);
            }
        }
        return result;
    }


    public static int romanToInt(char s) {
        switch (s) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}
