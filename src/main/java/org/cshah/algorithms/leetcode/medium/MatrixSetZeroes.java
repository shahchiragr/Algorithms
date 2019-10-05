package org.cshah.algorithms.leetcode.medium;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class MatrixSetZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix.length ==0)
            return;;

        int[] colArray = new int[matrix[0].length];
        int[] rowArray = new int[matrix.length];

        for (int row=0; row < matrix.length; row++) {
            for (int col=0; col < matrix[row].length; col++) {
                if (matrix[row][col] ==0) {
                    colArray[col] = 1;
                    rowArray[row] = 1;
                }
            }
        }

        for (int row=0; row < matrix.length; row++) {
            for (int col=0; col < matrix[row].length; col++) {
                if ( colArray[col] == 1 || rowArray[row] == 1) {
                    matrix[row][col] = 0;
                }
            }
        }

        /*
        for (int row=0; row < matrix.length; row++) {
            for (int col=0; col < matrix[row].length; col++) {
                System.out.print( matrix[row][col] + "  ");
            }
            System.out.println();
        }
         */

    }

    public static void main(String args[]) {

        int[][] data = new int[][]{{1, 0, 5, 7}, {10, 11, 17, 20}, {23, 30, 34, 37}};
        MatrixSetZeroes matrixSetZeroes = new MatrixSetZeroes();
        matrixSetZeroes.setZeroes(data);
    }
}
