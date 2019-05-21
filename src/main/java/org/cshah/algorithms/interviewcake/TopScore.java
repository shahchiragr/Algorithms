package org.cshah.algorithms.interviewcake;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

/**
 * https://www.interviewcake.com/question/java/top-scores?course=fc1&section=sorting-searching-logarithms
 *
 * Each round, players receive a score between 0 and 100, which you use to rank them from highest to lowest.
 * So far you're using an algorithm that sorts in O(n\lg{n})O(nlgn) time, but players are complaining that their
 * rankings aren't updated fast enough. You need a faster sorting algorithm.
 *
 * Write a method that takes:
 *
 * an array of unsortedScores
 * the highestPossibleScore in the game
 * and returns a sorted array of scores in less than O(n\lg{n})O(nlgn) time.
 *
 */

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