package com.example.algorithms;

/**
 * Created by chirag on 9/10/16.
 */
public class PowerLogN {

    public static long power(int a,int b) {
        System.out.println("HERE " + a + ":" +b);
        if (b == 0)
            return 1;

        long x= power (a, b/2);

        if (b%2 == 0) {
            System.out.println("RETURN " + x * x);
            return x * x;
        } else {
            System.out.println("RETURN... " +  a* x * x);
            return a * x * x;
        }
    }

    public static void main(String args[]) {
        System.out.println("POWER  " + PowerLogN.power(2,6));

    }
}
