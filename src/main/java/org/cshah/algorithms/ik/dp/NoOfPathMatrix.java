package org.cshah.algorithms.ik.dp;

import java.util.ArrayList;
import java.util.List;

/**
 Consider a maze mapped to a matrix with an upper left corner at coordinates (row, column) = (0, 0). You can only move either towards
 right or down from a cell. You must determine the number of distinct paths through the maze. You will always start at a position (0, 0),
 the top left, and end up at (n-1, m-1), the bottom right.


 As an example, consider the following diagram where '1' indicates an open cell and '0' indicates blocked. You can only travel through
 open cells, so no path can go through the cell at (0, 2). There are two distinct paths to the goal.

 There are two possible paths from the cell (0, 0) to cell (1, 3) in this matrix.

 Complete the function numberOfPaths. The function must return the number of paths through the matrix, modulo (10^9 + 7).


 Input/Output Format For The Function:

 Input Format:

 The function contains a single argument, a 2d integer array matrix.

 Output Format:

 Return an integer, the number of paths to reach from (0, 0) to (n-1, m-1).

 Input/Output Format For The Custom Input:

 Input Format:

 The first line contains integer n, the number of rows. The next line contains integer m, number of columns. Next n lines contain m
 integers each.

 For example:

 3

 3

 1 1 0

 1 1 1

 0 1 1

 Output Format:

 Output the number of paths in a single line.

 For the above input, the output would be

 4

 Constraints:

 1 <= n*m <= 2*10^6
 Each cell, matrix[i][j], contains 1, indicating it is accessible or 0, indicating it is not accessible, where 0<=i<n and 0<=j<m.


 Sample Test Cases:

 Sample Test Case 1:

 Sample Input 1:

 3

 4

 1 1 1 1

 1 1 1 1

 1 1 1 1

 Sample Output 1:

 10

 Explanation 1:

 There are 10 possible paths from cell (0, 0) to cell (2, 3).﻿﻿﻿


 Sample Test Case 2:

 Sample Input 2:
 2

 2

 1 1

 0 1

 Sample Output 2:

 1

 Explanation 2:

 There is 1 possible path from the cell (0, 0) to cell (1, 1).

 */
public class NoOfPathMatrix {

    public static int numberOfPaths(List<List<Integer>> matrix) {
          int totalRow = matrix.size();
          int MOD = 1000000007;
          int totalCol = matrix.get(0).size();
          int[][] dpTable = new int[totalRow][totalCol];

          dpTable[0][0] = matrix.get(0).get(0);
          List<Integer> rowList = matrix.get(0);

          //first set the row with either 0 or 1 in first row
          for (int i=1; i < rowList.size();i++) {
              if (dpTable[0][i-1] == 1 &&  rowList.get(i) ==1)
                  dpTable[0][i] = 1;
          }

          for (int i=1; i < matrix.size(); i++) {
              if (dpTable[i-1][0]==1 &&  matrix.get(i).get(0)==1)
                    dpTable[i][0] = 1;
          }


          for (int row=1; row < totalRow; row++) {
                for (int col=1; col < totalCol; col++) {
                    if (matrix.get(row).get(col) == 0) {
                        dpTable[row][col] = 0;
                    } else {
                        dpTable[row][col] = (dpTable[row-1][col] + dpTable[row][col-1])%MOD;
                    }
                }
          }

          //last row and col
          return dpTable[totalRow-1][totalCol-1];
    }

    public static void main(String[] args) {

        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(1);
        firstList.add(1);

        List<Integer> secondList = new ArrayList<>();
        secondList.add(1);
        secondList.add(1);
        secondList.add(1);

        List<Integer> thirdList = new ArrayList<>();
        thirdList.add(1);
        thirdList.add(1);
        thirdList.add(1);

        matrix.add(firstList);
        matrix.add(secondList);
        matrix.add(thirdList);

        System.out.println(NoOfPathMatrix.numberOfPaths(matrix));

    }
}
