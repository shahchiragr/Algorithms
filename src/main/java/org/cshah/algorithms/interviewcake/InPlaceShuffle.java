package org.cshah.algorithms.interviewcake;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * Write a method for doing an in-place ↴ shuffle of an array.
 *
 * The shuffle must be "uniform," meaning each item in the original array must have the same probability of ending up in each spot in the final array.
 *
 * Assume that you have a method getRandom(floor, ceiling) for getting a random integer that is >= floor and <= ceiling.
 *
 * Complexity
 * O(n) time and O(1) space.
 *
 */
public class InPlaceShuffle {

    private static Random rand = new Random();

    private static int getRandom(int floor, int ceiling) {
        return rand.nextInt((ceiling - floor) + 1) + floor;
    }

    public static void shuffle(int[] theArray) {
//        printArray("Array before shuffling", theArray);
        // shuffle the input in place
        if (theArray.length <= 1)
            return;

        for (int i=0; i < theArray.length-1;i++) {

            int randomNumber = getRandom(i, theArray.length-1);

            if (i != randomNumber) {
                int temp = theArray[i];
                theArray[i] = theArray[randomNumber];
                theArray[randomNumber] = temp;
            }
        }

//        printArray("Array after shuffling", theArray);

    }

    public static void printArray(String message, int[] array) {
        System.out.println(message);
        for (int i: array) {
            System.out.print(i + ", ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        final int[] initial = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int[] shuffled = Arrays.copyOf(initial, initial.length);
        shuffle(shuffled);
        System.out.printf("initial array: %s\n", Arrays.toString(initial));
        System.out.printf("shuffled array: %s\n", Arrays.toString(shuffled));
    }
}