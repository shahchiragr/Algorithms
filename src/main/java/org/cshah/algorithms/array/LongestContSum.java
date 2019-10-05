package org.cshah.algorithms.array;

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

    public static void main(String args[]) {
        int a[] = { 4, 2,6, 1, 0,-1, 1,3,-2 ,7,7,8,-2};
        LongestContSum.longSum(a);

    }

}
