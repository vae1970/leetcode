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
        int[] array = new int[10];
        int length = 0;
        while (n != 0) {
            array[length++] = n % 10;
            n /= 10;
        }
        int count = 0;
        int i = length - 1;
        int temp = array[i] + 1;
        for (; i >= 0; i--) {
            if (array[i] == temp) {
                count++;
            } else {
                sb.append(count);
                sb.append(temp);
                count = 1;
                temp = array[i];
            }
        }
        return sb.substring(0, sb.length());
    }

}
