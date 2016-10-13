package org.cshah.algorithms.bit;

/**
 * Created by cshah on 4/29/14.
 */
public class BitReplacement {

    public static int updateBits(int n, int m, int i, int j) {
        int max = ~0;
        System.out.println("Max " + max );


        //1's through position j; then 0s
        int left = max - ((1 << j) -1);

        System.out.println("left " + left);

        //1s after position i;
        int right = ((1<<i) -1);
        System.out.println("Right " + right);

        //1s with 0s between i and j
        int mask = left | right;

        System.out.println("Mask " + mask);

        //clear i through j and put m in there

        System.out.println("N & mask " + (n & mask));
        return (n & mask) | (m << i) ;

    }

    public static void main(String args[]) {

        System.out.println("Bit Replacement : " + BitReplacement.updateBits(1024, 21, 2, 6));
    }
}
