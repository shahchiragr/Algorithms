package com.example.algorithms;

/**
 * Created by chirag on 9/11/16.
 */
public class FindIntegerBit {

    int numOnesInBinary(int number) {
        int numOnes = 0;
        while (number != 0) {
            number = number & (number -1);
            numOnes++;
        }

        return numOnes;
    }

    int numOnsInBinary_1(int number) {
        int numOnes = 0;
        int count =0;
        while (number != 0) {
            if ((number & 1) ==1 ){
                numOnes++;
            }
            number = number >>> 1;
            count++;
        }
        System.out.println("TOTAL Loop " + count);
        return numOnes;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FindIntegerBit obj = new FindIntegerBit();
        int num = 132;
        System.out.println("ALGO 1 : " + obj.numOnesInBinary(num));
        System.out.println("ALGO 2 : " + obj.numOnsInBinary_1(num));

    }

}
