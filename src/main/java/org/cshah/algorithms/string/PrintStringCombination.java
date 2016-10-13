package org.cshah.algorithms.string;

/**
 * Created by cshah on 5/6/14.
 *
 * http://www.careercup.com/question?id=5765850736885760
 *
 */
public class PrintStringCombination {

    public void printCombination() {

    }
    public static void main(String args[]) {
        int a[] = new int[] {2,3,1,0};

        for (int i=0; i < a.length; i++) {
            a[i]  +=  (a[a[i]]%a.length) * a.length;
        }

        for (int i=0; i < a.length; i++) {
            a[i] /= a.length;

        }

        for (int i : a) {
            System.out.print(a[i] + " ");
        }
    }
}
