package com.vae1970.leetcode.solution;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
        long start = System.currentTimeMillis();
        setMatrixZeroes.setZeroes(b);
        long end = System.currentTimeMillis();
        System.out.println("ms: " + (end - start));
    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>(matrix.length);
        Set<Integer> column = new HashSet<>(matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }
        Iterator<Integer> rowIterator = row.iterator();
        while (rowIterator.hasNext()) {
            Integer i = rowIterator.next();
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
        Iterator<Integer> columnIterator = column.iterator();
        while (columnIterator.hasNext()) {
            Integer j = columnIterator.next();
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }

}
