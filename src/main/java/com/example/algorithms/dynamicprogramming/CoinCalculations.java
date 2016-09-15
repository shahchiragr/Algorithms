package com.example.algorithms.dynamicprogramming;

/**
 * Created by cshah on 4/30/14.
 */
public class CoinCalculations {

    private static void printLine(String str, int tab) {
        for (int i=0; i<tab; i++)
            System.out.print("\t");

        System.out.println(str);
    }
    public static int makeChanges(int n, int denom, int tab) {
        int nextdenom = 0;
        printLine("In Method " + n + ":" + denom , tab);
        switch (denom) {
            case 25: nextdenom = 10;break;
            case 10: nextdenom = 5; break;
            case  5: nextdenom = 1; break;
            case  1: return 1;
        }

        int ways = 0;
        for (int i =0; i * denom <=n; i++) {
            printLine("In Loop :" + i + ":" + denom + ":" + nextdenom, tab);
            ways += makeChanges(n - i *denom, nextdenom, tab+1);
            printLine("WAYS " + ways, tab);
        }

        return  ways;
    }

    public static void main(String args[])  {
        System.out.println(" Result " + CoinCalculations.makeChanges(10,10,0));

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
