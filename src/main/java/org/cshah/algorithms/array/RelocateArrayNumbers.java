package org.cshah.algorithms.array;

/**
 * Created by cshah on 5/6/14.
 */
public class RelocateArrayNumbers {

    public static void main(String args[]) {
        int a[] = new int[] {2,3,1,0};

        for (int i=0; i < a.length; i++) {
            a[i]  +=  (a[a[i]]%a.length) * a.length;
        }

        for (int i=0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
        for (int i=0; i < a.length; i++) {
            a[i] /= a.length;

        }

        for (int i=0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
