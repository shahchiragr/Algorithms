package com.example.algorithms.bit;

/**
 * Created by chirag on 9/4/16.
 */
public class BitOperation {

    public static int swapOddAndEventBits(int x) {
        int a = ((x & 0xaaaaaaaa) >> 1);
        int b = ((x & 0x55555555) << 1);

        System.out.println("a " +  a  + ", b " + b + " " + 0xaaaaaaaa + " " + 0x55555555  );
        return a |b;
    }

    public static void numOfBitRequriedToConvert(int a, int b) {
        int count = 0;
        for (int c = a^b; c>0; c = c& (c-1)) {
            count++;
        }

        System.out.println("Total bit required to convert a{" + a + " } to b{" + b + "} is {" + count +"}");

    }
    public static void main(String args[] ) {
        int num = 10;
        System.out.println(" N " + num + " , " + BitOperation.swapOddAndEventBits(num));

        BitOperation.numOfBitRequriedToConvert(10,5);

    }
}
