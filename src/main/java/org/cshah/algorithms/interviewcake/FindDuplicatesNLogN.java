package org.cshah.algorithms.interviewcake;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

/**
 * https://www.interviewcake.com/question/java/find-duplicate-optimize-for-space?course=fc1&section=sorting-searching-logarithms
 *
 * We have an array of integers, where:
 *
 * The integers are in the range 1..n1..n
 * The array has a length of n+1n+1
 * It follows that our array has at least one integer which appears at least twice. But it may have several duplicates,
 * and each duplicate may appear more than twice.
 *
 * Write a method which finds an integer that appears more than once in our array. (If there are multiple duplicates,
 * you only need to find one of them.)
 *
 * We're going to run this method on our new, super-hip MacBook Pro With Retina Display™. Thing is, the damn thing came
 * with the RAM soldered right to the motherboard, so we can't upgrade our RAM. So we need to optimize for space!
 *
 *
 *
 *
 * O(1) space and O(nlgn) time.
 *
 * Tricky as this solution is, we can actually do even better, getting our runtime down to O(n)
 * while keeping our space cost at O(1). The solution is NUTS; it's probably outside the scope of
 * what most interviewers would expect. But for the curious...here it is!
 *
 */
public class FindDuplicatesNLogN {

    public static int findRepeat(int[] theArray) {


        int floor = 1;
        int ceiling = theArray.length - 1;

        while (floor < ceiling) {

            // divide our range 1..n into an upper range and lower range
            // (such that they don't overlap)
            // lower range is floor..midpoint
            // upper range is midpoint+1..ceiling
            int midpoint = floor + ((ceiling - floor) / 2);
            int lowerRangeFloor   = floor;
            int lowerRangeCeiling = midpoint;
            int upperRangeFloor   = midpoint + 1;
            int upperRangeCeiling = ceiling;

            // count number of items in lower range
            int itemsInLowerRange = 0;
            for (int item : theArray) {

                // is it in the lower range?
                if (item >= lowerRangeFloor && item <= lowerRangeCeiling) {
                    itemsInLowerRange += 1;
                }
            }

            int distinctPossibleIntegersInLowerRange = lowerRangeCeiling - lowerRangeFloor + 1;

            if (itemsInLowerRange > distinctPossibleIntegersInLowerRange) {

                // there must be a duplicate in the lower range
                // so use the same approach iteratively on that range
                floor   = lowerRangeFloor;
                ceiling = lowerRangeCeiling;
            } else {

                // there must be a duplicate in the upper range
                // so use the same approach iteratively on that range
                floor   = upperRangeFloor;
                ceiling = upperRangeCeiling;
            }
        }

        // floor and ceiling have converged
        // we found a number that repeats!
        return floor;

    }

    // tests

    @Test
    public void justTheRepeatedNumberTest() {
        final int[] numbers = {1, 1};
        final int expected = 1;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void shortArrayTest() {
        final int[] numbers = {1, 2, 3, 2};
        final int expected = 2;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int[] numbers = {1, 2, 5, 5, 5, 5};
        final int expected = 5;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void longArrayTest() {
        final int[] numbers = {4, 1, 4, 8, 3, 2, 7, 6, 5};
        final int expected = 4;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FindDuplicatesNLogN.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}