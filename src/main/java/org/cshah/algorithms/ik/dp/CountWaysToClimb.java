package org.cshah.algorithms.ik.dp;

public class CountWaysToClimb {

    static long countWaysToClimb(int[] steps, int n) {
        long[] table = new long[n+1];

        //base condition
        table[0] = 1;

        for (int i=1; i<= n; i++) {
            table[i] = 0;
        }

        for (int i=1; i<=n; i++) {
            for (int j=0; j < steps.length; j++) {
                 if ( i - steps[j] >= 0) {
                    table[i] = table[i] + table[i - steps[j]];
                }
            }
        }

        /*
        int counter =0;
        for (long data : table) {
            System.out.print(counter++ +  " (" + data + ") | ");
        }
        System.out.println();
        */

        return  table[n];
    }

    public static void main(String[] args) {
        int n = 8;
        int[] steps = new int[] {2,3};
        long result = CountWaysToClimb.countWaysToClimb(steps, n);
        System.out.println("total result... " + result);

        steps = new int[] {15,17,20,33};
        n=35;
        result = CountWaysToClimb.countWaysToClimb(steps, n);
        System.out.println("total result... " + result);

        steps = new int[] {30, 23, 46,28, 12, 34, 6, 29, 36, 17, 10};
        n=200;
        result = CountWaysToClimb.countWaysToClimb(steps, n);
        System.out.println("total result... " + result);

    }
}
