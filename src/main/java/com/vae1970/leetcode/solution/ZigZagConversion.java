package com.vae1970.leetcode.solution;

/**
 * ZigZag Conversion
 *
 * @author vae
 */
public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3).equals("LCIRETOESIIGEDHN"));
        System.out.println(convert("LEETCODEISHIRING", 4).equals("LDREOEIIECIHNTSG"));
        System.out.println(convert("", 1).equals(""));
        System.out.println(convert(null, 1).equals(""));
        System.out.println(convert("A", 2).equals("A"));
        System.out.println(convert("AB", 1).equals("AB"));
        System.out.println(convert("ABCD", 2).equals("ACBD"));
    }

    /**
     * 这种占位法太浪费内存了
     * <p>
     * 0                8               16
     * 1            7   9           15  17
     * 2        6       10      14
     * 3    5           11  13
     * 4                12
     * <p>
     * <p>
     * 这种占位相对节约一些内存
     * <p>
     * 0        8       16
     * 1    7   9   15  17
     * 2    6   10  14
     * 3    5   11  13
     * 4        12
     *
     * @param s       s
     * @param numRows numRows
     * @return String
     */
    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        int maxLength = length - 1;
        int group = (numRows - 1) << 1;
        int maxWidth = numRows == 1 ? length : (maxLength / group << 1) + maxLength % group / numRows + 1;
        int[][] array = new int[maxWidth][numRows];
        char[] stringArray = new char[length];
        boolean add = true;
        int x = 0, y = 0;
        for (int i = 0; i < length; i++) {
            array[x][y] = i;
            if (y == numRows - 1) {
                x++;
                add = false;
            } else if (y == 1 && !add) {
                y = -1;
                x++;
                add = true;
            }
            if (add || (y == 0 && y < (numRows - 1))) {
                y++;
            } else if (y > 0) {
                y--;
            }
        }
        int index = 0;
        int temp;
        stringArray[index++] = s.charAt(0);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < maxWidth; j++) {
                temp = array[j][i];
                if (temp != 0) {
                    stringArray[index++] = s.charAt(temp);
                }
            }
        }
        return new String(stringArray);
    }

}
