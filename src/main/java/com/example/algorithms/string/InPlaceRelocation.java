package com.example.algorithms.string;

/**
 * Created by cshah on 6/15/14.
 *
 WAP to modify the array such that arr[I] = arr[arr[I]].
 Do this in place i.e. with out using additional memory.

 example : if a = {2,3,1,0}
 o/p = a = {1,0,3,2}
 */
public class InPlaceRelocation {

     public static void printArray(int a[]) {
         for (int k=0; k<a.length; k++) {
             System.out.print(a[k] + " ");
         }
         System.out.println();

     }

    public static void relocate(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        int len = arr.length;
        int shift = (int) Math.ceil(Math.log10(len) / Math.log10(2));
        int mask = (int) Math.pow(2.0, shift) - 1;

        System.out.println(shift + ":" + mask);
        for (int i = 0; i < len; ++i) {
            arr[i] += (arr[arr[i] & mask] & mask) << shift;
        }

        for (int i = 0; i < len; ++i) {
            arr[i] >>= shift;
        }
    }

     public static void main(String[] args) {
     int a[] = new int[] {2,3,1,0};

        printArray(a);
        relocate(a);
        printArray(a);

     }
}
