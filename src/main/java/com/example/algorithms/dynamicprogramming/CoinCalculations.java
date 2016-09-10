package com.example.algorithms.dynamicprogramming;

/**
 * Created by cshah on 4/30/14.
 */
public class CoinCalculations {

    public static int makeChanges(int n, int denom) {
        int nextdenom = 0;
        switch (denom) {
            case 25: nextdenom = 10;break;
            case 10: nextdenom = 5; break;
            case  5: nextdenom = 1; break;
            case  1: return 1;
        }

        int ways = 0;
        for (int i =0; i * denom <=n; i++) {
            ways += makeChanges(n - i *denom, nextdenom);
        }

        return  ways;
    }

    public static void main(String args[])  {
        System.out.println(" Result " + CoinCalculations.makeChanges(25,25));

  //      int i = ;
        System.out.println("I is " + 0xFFFFFFF + ":" + 0x10000000 );

        int n = 10;
        System.out.println(" HERE " + (1 << (n %8)));

        n = 18;
        System.out.println(" HERE " + (1 << (n %8)));

        byte[] bitfield = new byte[0xFFFFFFF/8];


        System.out.println("Size " + bitfield.length);
     //   BitSet
    }
}
