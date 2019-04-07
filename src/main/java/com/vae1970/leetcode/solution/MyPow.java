package com.vae1970.leetcode.solution;

/**
 * Pow(x, n)
 *
 * @author vae
 */
public class MyPow {

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
        System.out.println(myPow(1.00001, 123456));
        System.out.println(myPow(0.00001, 2147483647));
        System.out.println(6 & 1);
        System.out.println(-2 / 2);
    }

    public static double myPow(double x, int n) {
        double pow = 1;
        boolean positive = n > 0;
        for (; n != 0; n /= 2) {
            if (n % 2 != 0) {
                pow *= x;
            }
            x *= x;
        }
        return positive ? pow : 1 / pow;
    }

}
