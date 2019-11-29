package org.cshah.algorithms.ik.dp;

import java.util.ArrayList;
import java.util.List;

public class MaxPathSum {

    //TODO - work on space optimized algo to store only 2 rows so that we dont have to create N*M 2-D array

    public static int getMaxDepth(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] DP = new int[row][col];

        List<Integer> pathValue = new ArrayList<Integer>();
        DP[0][0] = grid[0][0];

        //first initialize first row
        for (int i=1; i < col; i++) {
            DP[0][i] = DP[0][i-1]+ grid[0][i];
        }

        //then initialize first column
        for (int j=1; j< row; j++) {
            DP[j][0] = DP[j-1][0] + grid[j-1][0];
        }

        //always add first row and col as starting point
        pathValue.add(DP[0][0]);

        for (int iRow=1;iRow< row; iRow++) {
            for (int iCol=1; iCol < col; iCol++) {
                DP[iRow][iCol] = grid[iRow][iCol] + Math.max(DP[iRow-1][iCol], DP[iRow][iCol-1]);
        /*
                if (DP[iRow-1][iCol] > DP[iRow][iCol-1]) {
                    System.out.println( (iRow-1) +  "  " + iCol);
                } else {
                    System.out.println( iRow +  "  " + (iCol-1));
                }

         */
                pathValue.add(Math.max(DP[iRow-1][iCol], DP[iRow][iCol-1]));
            }
        }

        for (Integer val : pathValue) {
            System.out.print(val + " " );
        }

        System.out.println("");
        return DP[row-1][col-1];
    }


    public static void main(String[] args) {
        int[][] grid = new int[][] {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(MaxPathSum.getMaxDepth(grid));

    }
}
