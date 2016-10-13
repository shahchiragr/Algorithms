package org.cshah.algorithms.misc;

/**
 * Created by chirag on 9/10/16.
 */
public class PowerLogN {

    public static long power(int a,int b) {
        if (b == 0)
            return 1;

        long x= power (a, b/2);

        if (b%2 == 0) {
            return x * x;
        } else {
            return a * x * x;
        }
    }

    public static void main(String args[]) {
        System.out.println("POWER  " + PowerLogN.power(2,6));

    }
}
