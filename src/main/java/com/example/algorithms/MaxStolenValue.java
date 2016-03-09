package com.example.algorithms;

import java.util.List;

/**
 * Created by cshah on 5/16/14.
 */
public class MaxStolenValue {

    public static int maxStolenValue(int[] values) {
     int length = values.length;

        if(length == 0)
            return 0;

        int value1 = values[0];
        if(length == 1)
            return value1;

        int value2 = Math.max(values[0], values[1]);
        if(length == 2)
            return value2;

        int value=0;
        for(int i = 2; i < length; ++i)
        {
            value = Math.max(value2, value1 + values[i]);
            value1 = value2;
            value2 = value;
        }

        return value;
    }

    public static void main(String args[])  {
        int[] a = new int[]{6, 1, 9,2, 9,7};
        System.out.println(MaxStolenValue.maxStolenValue(a));
    }
}
