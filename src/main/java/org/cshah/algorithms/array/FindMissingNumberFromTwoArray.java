package org.cshah.algorithms.array;

/**
 * Created by chirag on 10/16/16.
 */
public class FindMissingNumberFromTwoArray {

    public static void main(String args[]) {
        int[] arr1 = {3, 7,10};
        int[] arr2 = { 7,3};
        int xor = 0;
        for (int i = 0; i < arr1.length; i++) {
            xor ^= arr1[i];
            System.out.println("XOR " + xor);
        }
        for (int i = 0; i < arr2.length; i++) {
            xor ^= arr2[i];
            System.out.println("XOR ..." + xor);

        }
        System.out.println("missing number: " + xor);
    }
}