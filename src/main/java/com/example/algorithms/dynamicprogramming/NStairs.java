package com.example.algorithms.dynamicprogramming;

/**
 * Created by chirag on 9/5/16.
 */
public class NStairs {
    static int counter =0;
    static int counterDP =0;
    /* 3^N time complexity ; since countways is called 3 times in recursion for every single value*/
    public static int countWays(int n) {
        counter++;
        if (n< 0) {
            return 0;
        } else if (n ==0) {
            return 1;
        } else {
            return countWays(n-1) + countWays(n-2) + countWays(n-3);
        }
    }

    /**
     * Total ways for 5 steps are  13, Loopcount 46 - Above Algo
     * Total ways for 5 steps are  13, Loopcount 16 - DP Algo
     *
     * Endless loop when steps = 37
     *
     * Total ways for 3 steps are  4, Loopcount 13
     Map N 1 value : 1
     Map N 2 value : 2
     Map N 3 value : 4
     Total ways for 3 steps are  4, Loopcount 10
     * @param n
     * @param map
     * @return
     */

    public static int countWaysDP(int n, int map[]) {
        counterDP++;
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (map[n] > -1) {
            return map[n];
        } else {
            map[n] = countWaysDP(n-1, map) + countWaysDP(n-2, map) + countWaysDP(n-3,map);
            System.out.println("Map N " + n + " value : " +  map[n]);
            return  map[n];
        }
    }

    public static void main(String args[]) {
        int steps = 3;
        System.out.println("Total ways for " + steps + " steps are  " + NStairs.countWays(steps) + ", Loopcount " + counter);

        int map[] = new int[steps+1];
        for (int i=0; i < map.length; i++) {
            map[i] = -1;
        }
        System.out.println("Total ways for " + steps + " steps are  " + NStairs.countWaysDP(steps, map) + ", Loopcount " + counterDP);

    }
}
