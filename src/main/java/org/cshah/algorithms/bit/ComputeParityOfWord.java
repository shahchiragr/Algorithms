package org.cshah.algorithms.bit;

/**
 * Created by chirag on 10/24/18.
 */
public class ComputeParityOfWord {

    public static short parity(long x) {

        short result = 0;
        long y = x;
        while ( y != 0) {
            result  ^= 1;
            y &= (y-1);
        }
        System.out.println("RESULT " + result);

        final int WORD_SIZE = 16;
        final int BIT_MASK = 0xFFFF;

  //      System.out.println("BIT MASK " + BIT_MASK);
        System.out.println((int) (( x >>> (3 * WORD_SIZE)) & BIT_MASK));
        System.out.println((int) (( x >>> (2 * WORD_SIZE)) & BIT_MASK));
        System.out.println((int) (( x >>> ( WORD_SIZE)) & BIT_MASK));
        System.out.println((int) (( x  & BIT_MASK)));

        System.out.println((int) (( x >>> (3 * WORD_SIZE)) & BIT_MASK)
        ^(int) (( x >>> (2 * WORD_SIZE)) & BIT_MASK)
        ^(int) (( x >>> ( WORD_SIZE)) & BIT_MASK)
        ^(int) (( x  & BIT_MASK)));

        return 0;

    }
    public static void main(String args[]) {
        long l1 = 258l;
        ComputeParityOfWord.parity(l1);
    }
}
