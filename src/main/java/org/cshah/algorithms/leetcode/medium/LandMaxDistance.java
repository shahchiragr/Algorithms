package org.cshah.algorithms.leetcode.medium;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * https://leetcode.com/problems/as-far-from-land-as-possible/
 */
public class LandMaxDistance {

    public int maxDistance(int[][] grid) {
        int totalCount =Integer.MIN_VALUE;

        Queue<int[]> land = new LinkedBlockingQueue<int[]>();
        Queue<int[]> water = new LinkedBlockingQueue<int[]>();

        for (int row=0; row < grid.length;row++) {
            for (int col=0; col < grid[0].length;col++) {
                if (grid[row][col] == 0) {
                    water.offer(new int[] {row,col});
                } else {
                    land.offer(new int[] {row,col});
                }
            }
        }

        if (land.isEmpty() || water.isEmpty())
            return  -1;

        while (!water.isEmpty()) {
            int[] waterArray = water.poll();
            Iterator<int[]> iterator = land.iterator();
            int currentCount = Integer.MAX_VALUE;
            while (iterator.hasNext()) {
             int[] landArray = iterator.next();
                int count = Math.abs(waterArray[0] - landArray[0]) + Math.abs(waterArray[1] - landArray[1]);
                currentCount = Math.min(currentCount,count );
            }

            totalCount= Math.max(totalCount, currentCount);
        }
        return totalCount;
    }



    public static void main(String[] args) {
        LandMaxDistance landMaxDistance = new LandMaxDistance();

        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
        int distance = landMaxDistance.maxDistance(grid);
        System.out.println( "Ans : " + distance);

        grid = new int[][]{{1,0,0},{0,0,0},{0,0,0}};
        distance = landMaxDistance.maxDistance(grid);
        System.out.println("Ans : " +  distance);

    }
}
