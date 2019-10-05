package org.cshah.algorithms.leetcode.medium;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;

        if (matrix.length ==0 )
            return false;

        int row = 0;
        int col = matrix[0].length-1;

        while (row < matrix.length && col < matrix[0].length && row >=0 && col >= 0) {
            if (matrix[row][col] == target) {
                return  true;
            }

            if (target <matrix[row][col] ) {
               col--;
            } else {
                row++;
            }
        }

        return result;
    }


    public static void main(String args[]) {
        int[][] data = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        Search2DMatrix search2DMatrix = new Search2DMatrix();

        System.out.println(search2DMatrix.searchMatrix(data, 3));
        System.out.println(search2DMatrix.searchMatrix(data, 33));

    }
}
