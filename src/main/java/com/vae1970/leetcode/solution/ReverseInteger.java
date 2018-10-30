package com.vae1970.leetcode.solution;

/**
 * Reverse Integer
 *
 * @author vae
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int a = reverseInteger.reverse(123);
        System.out.println(a);
        int b = reverseInteger.reverse(-123);
        System.out.println(b);
        int c = reverseInteger.reverse(120);
        System.out.println(c);
        int d = reverseInteger.reverse(1534236469);
        System.out.println(d);
        int e = reverseInteger.reverse(-2147483648);
        System.out.println(e);
    }

    public int reverse(int x) {
        int negativeMaxLong = Integer.MIN_VALUE / 10;
        int negativeMaxShort = Integer.MIN_VALUE % 10;
        int positiveMaxLong = Integer.MAX_VALUE / 10;
        int positiveMaxShort = Integer.MAX_VALUE % 10;

        int sum = 0, temp;
        for (; x > 9 || x < -9; ) {
            temp = x % 10;
            x = x / 10;
            sum = sum * 10 + temp;
        }
        if (sum > positiveMaxLong || (sum == positiveMaxLong && x > positiveMaxShort)) {
            return 0;
        } else if (sum < negativeMaxLong || (sum == negativeMaxLong && x < negativeMaxShort)) {
            return 0;
        } else {
            sum = sum * 10 + x;
        }
        return sum;
    }

}
