package com.example.algorithms;


public class FindMaxNumber {

    /**
     * @param args
     */
    public static void main(String[] args) {

       int a = 10;
       int b = 15;
       int c= a-b;
       int d= c >>31;
       System.out.println(" D " + Integer.toBinaryString(d) + " and C is " + c );
       int k = d & 0x01;
       System.out.println(" K " + k);
       int max = a - k *c;
       System.out.println("Max is " + max);
    }

}