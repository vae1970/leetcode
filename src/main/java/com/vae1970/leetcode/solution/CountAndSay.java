package com.vae1970.leetcode.solution;

/**
 * Count and Say
 *
 * @author vae
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(11));
        System.out.println(countAndSay(1211));
    }

    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        int old = -1;
        int temp;
        int count = 0;
        while (true) {
            temp = n / 10;
            if (temp == 0) {
                temp = n;
            }
            n /= 10;
            if (old == temp) {
                count++;
            } else {
                sb.append(count);
                sb.append(old);
                count = 1;
                old = temp;
                if (n == 0) {
                    break;
                }
            }
        }
        return sb.substring(2, sb.length());
    }

}
