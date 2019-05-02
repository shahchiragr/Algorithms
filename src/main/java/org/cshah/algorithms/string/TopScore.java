package org.cshah.algorithms.string;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class TopScore {

    public static int[] sortScores(int[] unorderedScores, int highestPossibleScore) {
        // sort the scores in O(n) time
        int[] sortedCount = new int[highestPossibleScore+1];
        for (int score : unorderedScores) {
            sortedCount[score]++;
        }

        int[] sortedArray = new int[unorderedScores.length];
        int index =0;

        for (int i=highestPossibleScore; i >= 0; i--) {
            int counter = sortedCount[i];

            for (int k=0; k < counter; k++) {
                sortedArray[index] =i;
                index++;
            }

        }

        return sortedArray;
    }
 /*
 * Complexity
O(n)O(n) time and O(n)O(n) space, where nn is the number of scores.

Wait, aren't we nesting two loops towards the bottom? So shouldn't it be O(n^2)O(n
2
 ) time? Notice what those loops iterate over. The outer loop runs once for each unique number in the array. The inner loop runs once for each time that number occurred.

So in essence we're just looping through the nn numbers from our input array, except we're splitting it into two steps: (1) each unique number, and (2) each time that number appeared.

Here's another way to think about it: in each iteration of our two nested loops, we append one item to sortedScores. How many numbers end up in sortedScores in the end? Exactly how many were in our input array! nn.

If we didn't treat highestPossibleScore as a constant, we could call it kk and say we have O(n+k)O(n+k) time and O(n+k)O(n+k) space.

 */

    // tests

    @Test
    public void noScoresTest() {
        final int[] scores = {};
        final int[] expected = {};
        final int[] actual = sortScores(scores, 100);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneScoreTest() {
        final int[] scores = {55};
        final int[] expected = {55};
        final int[] actual = sortScores(scores, 100);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoScoresTest() {
        final int[] scores = {30, 60};
        final int[] expected = {60, 30};
        final int[] actual = sortScores(scores, 100);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void manyScoresTest() {
        final int[] scores = {37, 89, 41, 65, 91, 53};
        final int[] expected = {91, 89, 65, 53, 41, 37};
        final int[] actual = sortScores(scores, 100);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void repeatedScoresTest() {
        final int[] scores = {20, 10, 30, 30, 10, 20};
        final int[] expected = {30, 30, 20, 20, 10, 10};
        final int[] actual = sortScores(scores, 100);
        assertArrayEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TopScore.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}