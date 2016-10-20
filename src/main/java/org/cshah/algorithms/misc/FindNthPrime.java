package org.cshah.algorithms.misc;

/**
 * Created by chirag on 10/18/16.
 */
public class FindNthPrime {

    public static int findNthPrime(int n) {
        int count =1;
        int num = 3;

        while (count != n) {
            if (isPrime(num)) {
                count++;
                if (count == n) {
                    return  num;
                }
            }
            num++;
        }

        return  num;
    }

    public static boolean isPrime(int num) {
        boolean isPrime = true;
         for (int i=2;i<= num/2; i++) {
             if (num%i == 0)
                 return false;
         }
        return isPrime;
    }
    public static void main(String args[]) {
        System.out.println(FindNthPrime.findNthPrime(104));
    }
}