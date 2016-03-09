package com.example.algorithms;


public class TrailingZeroinFactorial {

    /**
     * @param args
     */
    public static void main(String[] args) {

       int num = 25;
       int count = 0;
        for (int i=5; num/i >0; i *=5) {
           count += num/i;
           System.out.println("Count " + count + ":" + i );
        }

        System.out.println("Count is " + count);
    }

}