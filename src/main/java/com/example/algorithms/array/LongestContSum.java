package com.example.algorithms.array;

import java.util.Arrays;

/**
 * Created by chirag on 9/10/16.
 */
public class LongestContSum {

    public static void longSum(int array[]) {
        int sum = 0;
        int longestSum =0
                ;
        for (int i=0; i< array.length; i++) {
//            System.out.println(i + ":" + sum  + ":" + array[i]);


            if (sum + array[i]>= sum) {
                sum += array[i];
                if ( sum > longestSum) {
                    longestSum = sum;
                }
                continue;
            } else {
                sum=0;
            }

        }

        System.out.println("longest sum " + longestSum);
    }

    public static void findMissingElement(int a[], int b[]) {
        int result = 0;
        for (int i =0; i <a.length;i++) {
            result ^=  a[i];
//            System.out.println(" A " + result);
            result ^=  b[i];
//            System.out.println(" B " + result);

        }
        System.out.println("Missing element is : "  + result);

    }
    public static void main(String args[]) {
        int a[] = { 4, 2,6, 1, 0,-1, 1,3,-2 ,7,7,8,-2};
        LongestContSum.longSum(a);

        int a1[] = {1,3,4,5};
        int b1[] = {4,1,5,0};

        LongestContSum.findMissingElement(a1,b1);

    }

}
