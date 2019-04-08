package com.vae1970.leetcode.solution;

/**
 * String to Integer (atoi)
 *
 * @author vae
 */
public class StringToIntegerAtoi {

    public static void main(String[] args) {
        System.out.println(myAtoi("42") == 42);
        System.out.println(myAtoi("   -42") == -42);
        System.out.println(myAtoi("4193 with words") == 4193);
        System.out.println(myAtoi("words and 987") == 0);
        System.out.println(myAtoi("-91283472332") == -2147483648);
        System.out.println(myAtoi("+-2") == 0);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public static int myAtoi(String str) {
        int quotient = 0, remainder;
        boolean start = false, positive = true;
        int maxQuotient = Integer.MAX_VALUE / 10, maxRemainder = Integer.MAX_VALUE % 10;
        int minRemainder = -(Integer.MIN_VALUE % 10);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 0x30 && str.charAt(i) <= 0x39) {
                start = true;
                remainder = str.charAt(i) - 0x30;
                boolean overflow = (positive && (quotient < maxQuotient || (quotient == maxQuotient && remainder <= maxRemainder)))
                        || (!positive && (quotient < maxQuotient || (quotient == maxQuotient && remainder <= minRemainder)));
                if (overflow) {
                    quotient = quotient * 10 + remainder;
                } else {
                    return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                if (start) {
                    break;
                } else {
                    positive = str.charAt(i) == '+';
                }
                start = true;
            } else if (str.charAt(i) == ' ') {
                if (start) {
                    break;
                }
            } else {
                break;
            }
        }
        if (!start) {
            return 0;
        } else {
            return positive ? quotient : -quotient;
        }
    }
}
