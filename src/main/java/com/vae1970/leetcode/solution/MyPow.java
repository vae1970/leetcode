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
        System.out.println(6&1);
    }

//    public static double myPow(double x, int n) {
//        if (n == 0) {
//            return 1;
//        } else if (n > 0) {
//            return myPowPositive(x, n);
//        } else {
//            return 1 / myPowPositive(x, -n);
//        }
//    }

    public static double myPow(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return  n < 0 ? 1 / res : res;
    }

    public static double myPowPositive(double x, int n) {
        double doubleTemp = x * x;
        double result = 1;
        for (int i = 0, im = n / 2; i < im; i++) {
            result *= doubleTemp;
        }
        if (n % 2 == 1) {
            result *= x;
        }
        return result;
    }


}
