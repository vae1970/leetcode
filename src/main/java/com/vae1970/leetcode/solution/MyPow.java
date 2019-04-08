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
        System.out.println(myPow(0.44528, 0));
        System.out.println(myPow(1.00000, -2147483648));
        System.out.println(6 & 1);
        System.out.println(-2 / 2);
    }

    /**
     * 值   临时值   递归     递归
     * 39   1       38+1    2n+1
     * 19   2       18+1    2n+1
     * 9    4       8+1     2n+1
     * 4    8+1     4       2n
     * 2    18+1    2       2n
     * 1    38+1    0+1     2n+1
     * 0    0       0       0
     *
     * @param x x
     * @param n n
     * @return pow
     */
    public static double myPow(double x, int n) {
        return n > 0 ? pow(x, n) : 1 / pow(x, n);
    }

    public static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            double pow = pow(x, n / 2);
            pow *= pow;
            return n % 2 == 0 ? pow : pow * x;
        }
    }

}
