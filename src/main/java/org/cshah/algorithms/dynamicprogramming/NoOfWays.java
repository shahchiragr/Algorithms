package org.cshah.algorithms.dynamicprogramming;

/*
* This program is for given a n column and row, count how many different of ways you can reach to point 0,0
*
*/

public class NoOfWays {
    public static int numberOfWays(int x, int y) {
        int[][] data = new int[x][y];
        int returnValue  =computeNoOfWays(x-1,y-1,data);

        for (int i=0; i < x;i++) {
            for (int j=0; j < y; j++) {
                System.out.print (data[i][j] + " | ");
            }
            System.out.println("");
        }

        return returnValue;

    }

    private static int computeNoOfWays (int x, int y, int[][] numberOfWays) {
        if (x ==0 || y == 0) {
            numberOfWays[x][y] = 1;
            return 1;
        }
        if (numberOfWays[x][y] == 0) {
            int waysTop =  computeNoOfWays(x-1,y, numberOfWays);
            int waysLeft = computeNoOfWays(x, y-1, numberOfWays);
       //     System.out.println("numberOfWays["+x+"]["+ y+ "]  ==> " + waysTop + " +  " + waysLeft );
            numberOfWays[x][y] = waysLeft + waysTop;
        }

        return numberOfWays[x][y];
    }

    public static void main(String[] args) {
        System.out.println("Result : " +NoOfWays.numberOfWays(3,3));

        System.out.println("Result : " + NoOfWays.numberOfWays(5,5));

    }
}
