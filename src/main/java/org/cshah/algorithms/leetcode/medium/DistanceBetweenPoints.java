package org.cshah.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.dreamincode.net/forums/topic/252823-manhattan-distance-between-points/
 */
public class DistanceBetweenPoints {

    public void distBetweenPoints(int[][] arr){
        Set<Integer> rowSet = new HashSet<Integer>();
        Set<Integer> colSet = new HashSet<Integer>();
        for (int row=0; row <arr.length; row++) {
            for (int col=0; col < arr[0].length; col++) {
                if (arr[row][col] == 1) {
                    rowSet.add(row);
                    colSet.add(col);
                }
            }
        }

        Integer[] rowArray = new Integer[rowSet.size()];
        rowArray = rowSet.toArray(rowArray);

        Integer[] colArray = new Integer[colSet.size()];
        colArray = rowSet.toArray(colArray);

        int rowLower = findRange(rowArray, true);
        int rowHigher = findRange(rowArray, false);

        System.out.println("Row Range " + rowLower + " : " + rowHigher);

        int colLower = findRange(colArray, true);
        int colHigher = findRange(colArray, false);

        System.out.println("Col Range " + colLower + " : " + colHigher);


        //TODO - needs to add logic here...

    }

    public int findRange(Integer[] arr, boolean isLower) {

        if (arr.length ==1)
            return arr[0];

        if (arr.length % 2 ==1)
            return arr[arr.length/2];

        if (isLower) {
            return  arr[(arr.length/2)-1];
        }

        return  arr[(arr.length/2)];
    }
    public static void main(String[] args) {
        /*

        Manhattan distance from LC
        *  1,0,0,0,1
        *  0,0,0,0,0
        *  0,0,1,0,0
        *
        *
        * => row (0,2)
        * => col (0,2,4)
        * take median for row , and col
        * */

        int[][] arr = new int[][] {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        DistanceBetweenPoints distanceBetweenPoints = new DistanceBetweenPoints();
        distanceBetweenPoints.distBetweenPoints(arr);
    }
}
