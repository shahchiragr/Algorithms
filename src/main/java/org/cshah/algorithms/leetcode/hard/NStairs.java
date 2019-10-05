package org.cshah.algorithms.leetcode.hard;

/**
 * here exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.
 *
 * For example, if N is 4, then there are 5 unique ways:
 *
 * 1, 1, 1, 1
 * 2, 1, 1
 * 1, 2, 1
 * 1, 1, 2
 * 2, 2
 * What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 *
 */
public class NStairs {
    public void nStairsRec(int num, String slate) {
        if (num == 0) {
            System.out.println(slate);
            return;
        }

        //this is for 1,3,5 steps
        for (int k=1; k <=5; k+=2) {
            if (num-k >= 0)
                nStairsRec(num-k,slate + k + ",");

        }

//        if (num-1 >=0)
//        nStairsRec(num-1,slate +"1,");
//        if (num-2 >= 0)
//        nStairsRec(num-2,slate +"2,");
    }

    public static void main(String[] args) {
        NStairs nStairs = new NStairs();
        nStairs.nStairsRec(9, "");
    }
}
