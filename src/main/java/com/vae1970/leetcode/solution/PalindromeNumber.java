package com.vae1970.leetcode.solution;

/**
 * Palindrome Number
 *
 * @author vae
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(-121));
        System.out.println(palindromeNumber.isPalindrome(121));
        System.out.println(palindromeNumber.isPalindrome(10));

    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            int sum = 0, temp = x;
            for (; temp > 0; ) {
                sum = sum * 10 + temp % 10;
                temp /= 10;
            }
            return sum == x;
        }
    }

}
