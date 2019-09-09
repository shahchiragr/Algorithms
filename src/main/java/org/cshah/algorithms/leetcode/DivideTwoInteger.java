package org.cshah.algorithms.leetcode;

public class DivideTwoInteger {

    public int divide(int dividend, int divisor) {

        if (divisor ==1)
            return dividend;

        int negativeNum = 1;
        if (dividend < 0) {
            negativeNum = -negativeNum;
        } else {
            dividend = -dividend;
        }

        if (divisor < 0) {
            negativeNum = -negativeNum;
            divisor = -divisor;
        }

        int counter = 0;
        dividend += divisor;
        while (dividend <= 0) {
            counter++;
            if (counter == Integer.MAX_VALUE && negativeNum == 1) {
                return Integer.MAX_VALUE;
            }
            dividend += divisor;
        }

        if (negativeNum == -1)
            return  -counter;

        return counter ;
    }


    public static void main(String[] args) {
        DivideTwoInteger divideTwoInteger = new DivideTwoInteger();
        System.out.println(divideTwoInteger.divide(10,3));
        System.out.println(divideTwoInteger.divide(7,-3));
        System.out.println(divideTwoInteger.divide(-7,-3));
        System.out.println(divideTwoInteger.divide(100,10));
        System.out.println(divideTwoInteger.divide(100,100));
        System.out.println(divideTwoInteger.divide(100,1000));
        System.out.println(divideTwoInteger.divide(Integer.MIN_VALUE,-1));
        System.out.println(divideTwoInteger.divide(Integer.MIN_VALUE,1));

    }
}
