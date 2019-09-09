package org.cshah.algorithms.string;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

public class FindWordBinarySearch {

    public static int findRotationPoint(String[] words) {

        // find the rotation point in the array
        if ( words.length ==0)
            return  0;

        int start = 0;
        int end= words.length-1;

        while (start < end) {
            int midIndex = start +(end-start)/2;

            if ( words[start].compareTo(words[midIndex]) < 0)
                start = midIndex;
            else if ( words[start].compareTo(words[midIndex]) > 0)
                end = midIndex;
            else
                start++;
        }

            return end;
    }




    // tests

    @Test
    public void smallArrayTest() {
        final int actual = findRotationPoint(new String[] {"cape", "cake"});
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int actual = findRotationPoint(new String[] {"grape", "orange", "plum",
                "radish", "apple"});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void largeArrayTest() {
        final int actual = findRotationPoint(
                new String[] {"ptolemaic", "retrograde", "supplant", "undulate", "xenoepist",
                        "asymptote", "babka", "banoffee", "engender", "karpatka", "othellolagkage"});
        final int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void possiblyMissingEdgeCaseTest() {
        // are we missing any edge cases?
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FindWordBinarySearch.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}