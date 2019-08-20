package com.vae1970.leetcode.solution;

/**
 * @author dongzhou.gu
 * @date 2019/8/20
 * @description Set Matrix Zeroes
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] b = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        long start = System.nanoTime();
        setMatrixZeroes.setZeroes(b);
        long end = System.nanoTime();
        System.out.println("ms: " + (float) (end - start) / 1000000L);
    }

    public void setZeroes(int[][] matrix) {
        //  标记需要重置的行与列
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        //  遍历二维数组，标记为0的行与列
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        int i, j;
        //  遍历重置的行
        for (i = 0; i < row.length; i++) {
            if (row[i]) {
                for (j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //  遍历重置的列
        for (j = 0; j < column.length; j++) {
            if (column[j]) {
                for (i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
