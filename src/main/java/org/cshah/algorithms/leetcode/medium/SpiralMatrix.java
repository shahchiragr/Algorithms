package org.cshah.algorithms.leetcode.medium;

/*
https://leetcode.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        if (n <= 0)
            return null;

        int[][] results = new int[n][n];
        int rowEnd = n;
        int colEnd = n;
        int rowStart = 0;
        int colStart = 0;
        int counter =1;

        while (rowStart < rowEnd && colStart < colEnd) {

            for (int i= colStart; i < colEnd; i++) {
                results[rowStart][i] = counter++;
            }
            rowStart++;


            for (int i = rowStart; i < rowEnd; i++) {
                results[i][colEnd-1] = counter++;
            }
            colEnd--;

            for (int i= colEnd-1; i >=colStart; i--) {
                results[rowEnd-1][i] = counter++;
            }
            rowEnd--;


            for (int i=rowEnd-1; i >= rowStart;i--) {
                results[i][colStart] = counter++;
            }

            colStart++;

        }
        return  results;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] result = spiralMatrix.generateMatrix(1);
        for (int i=0; i < result.length;i++) {
            for (int col=0; col< result[0].length;col++) {
                int data = result[i][col];
                System.out.print(data +  (data < 10 ? "  " : " "));
            }
            System.out.println();
        };
    }
}
