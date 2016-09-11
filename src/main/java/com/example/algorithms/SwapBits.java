package com.example.algorithms;

/**
 * Created by chirag on 9/11/16.
 */
public class SwapBits {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int x = 64;
        int a = (x & 0xaaaaaaaa) >> 1 ;
        int b = (x & 0x55555555) << 1;

        System.out.println("Value : " + x + " Answer : " + (a | b) );
    }

}
