package org.cshah.algorithms.ik.dp;

import java.util.Arrays;

public class MaxStolenValues {
    static int maxStolenValue(int[] values) {

//     int[] memo = new int[values.length];
//     Arrays.fill(memo,-1);
//     return maxStolenValue(values.length-1, values,memo);
//
     return maxStolenValueDP(values);
    }

    //This is recursive way
    static int maxStolenValue(int index, int[] values, int[] memo) {
        if (index < 0)
            return  0;

        if (memo[index] != -1) {
            return memo[index];
        }

        if (index ==0) {
            memo[index] = values[index];
            return  memo[index];
        }

        if (index == 1) {
            memo[index] = Math.max(values[0], values[1]);
            return  memo[index];
        }

        memo[index] =  Math.max(maxStolenValue(index-1, values, memo), maxStolenValue(index-2, values, memo)+values[index])   ;
        return  memo[index];
    }

    //this is using DP
    static int maxStolenValueDP(int[] values) {
       int[] table = new int[values.length];

        if (values.length == 1) {
            return values[0];
        }

        if (values.length == 2) {
           return Math.max(values[0], values[1]);
       }
       table[0] = values[0];
       table[1] = Math.max(values[0], values[1]);

       for (int i=2; i < values.length; i++) {
           table[i] = Math.max(table[i-1], table[i-2]+ values[i]);
        }

        return table[values.length-1];
    }


    static int maxStolenValue_another(int[] values) {
       if ( values.length ==2)
           return  Math.max(values[0], values[1]);

       int value1 = values[0];

       int value2 = Math.max(values[0], values[1]);

       int value3 =0;

       for (int i=2; i < values.length; i++) {
           value3 = Math.max(value2, value1+ values[i]);
           value1 = value2;
           value2 = value3;
       }

       return  value3;
    }


    public static void main(String[] args) {
        int data[] = new int[] {6,1,2,7};
        System.out.println(MaxStolenValues.maxStolenValue(data));

        data = new int[] {1, 2, 4, 5, 1};
        System.out.println(MaxStolenValues.maxStolenValue(data));

    }
}
