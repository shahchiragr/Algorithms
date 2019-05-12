package org.cshah.algorithms.interviewcake;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class CalculateProduct {

    /**
     * Complexity
     * O(n) time and O(n) space. We make two passes through our input an array,
     * and the array we build always has the same length as the input array.
     *
     * @param intArray
     * @return
     */

    /*
    To find the products of all the integers except the integer at each index, we'll go through our array greedily ↴ twice. First we get the products of all the integers before each index, and then we go backwards to get the products of all the integers after each index.

    When we multiply all the products before and after each index, we get our answer—the products of all the integers except the integer at each index!
     */
    public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

        if (intArray.length < 2) {
            throw new IllegalArgumentException("error");
        }
        // make an array of the products
        int currentProduct = 1;
        int beforeProductArray[] = new int[intArray.length];

        // for each integer, we find the product of all the integers
        // before it, storing the total product so far each time
        for (int i=0; i < intArray.length; i++) {
            beforeProductArray[i] = currentProduct;
            currentProduct *= intArray[i];
        }

        // for each integer, we find the product of all the integers
        // after it. since each index in products already has the
        // product of all the integers before it, now we're storing
        // the total product of all other integers
        currentProduct = 1;
        for (int i = intArray.length-1; i >= 0; i--) {
            beforeProductArray[i] *= currentProduct;
            currentProduct *= intArray[i];
        }

        return beforeProductArray;
    }

    // tests
    @Test
    public void smallArrayTest_1() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {2, 3, 4,5});
        final int[] expected = new int[] {60, 40, 30,24};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void smallArrayTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {1, 2, 3});
        final int[] expected = new int[] {6, 3, 2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void longArrayTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {8, 2, 4, 3, 1, 5});
        final int[] expected = new int[] {120, 480, 240, 320, 960, 192};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void arrayHasOneZeroTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {6, 2, 0, 3});
        final int[] expected = new int[] {0, 0, 36, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void arrayHasTwoZerosTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {4, 0, 9, 1, 0});
        final int[] expected = new int[] {0, 0, 0, 0, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneNegativeNumberTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {-3, 8, 4});
        final int[] expected = new int[] {32, -12, -24};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void allNegativeNumbersTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {-7, -1, -4, -2});
        final int[] expected = new int[] {-8, -56, -14, -28};
        assertArrayEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyArrayTest() {
        getProductsOfAllIntsExceptAtIndex(new int[] {});
    }

    @Test(expected = Exception.class)
    public void exceptionWithOneNumberTest() {
        getProductsOfAllIntsExceptAtIndex(new int[] {1});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(CalculateProduct.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}