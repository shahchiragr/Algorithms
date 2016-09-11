package com.example.algorithms.array;

import java.util.Arrays;

/**
 * Created by chirag on 9/10/16.
 */
public class Sum3Number {

    public static void sum3Numbers(int a[], int target) {
        Arrays.sort(a);

        for (int i=0; i < a.length-2; i++) {
            int num = a[i];
            int l=i+1;
            int r= a.length-1;

            while (l < r ) {
                int sum = num + a[l]  + a[r];
                if (sum == target) {
                    System.out.println("Sum Matched... " + num + ":" + a[l] + ":" + a[r]);
                    break;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
    }
    public static void main(String args[]) {
        int a[] = { 4, 2,6, 0, 0,-1, 1,3,-2 };
        System.out.println("Target  " + 5);
        Sum3Number.sum3Numbers(a,5);

        System.out.println("Target  " + 4);
        Sum3Number.sum3Numbers(a,4);

    }
}
