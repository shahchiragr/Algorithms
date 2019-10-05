package org.cshah.algorithms.ik.recursion;

public class CatalanBST {

    static long how_many_BSTs(int n) {
        if (n == 0 || n ==1)
            return 1;
        int total =0;

        for (int i=1; i<=n;i++) {
           total += how_many_BSTs(i-1) * how_many_BSTs(n-i);
        }

        return total;

    }


    public static void main(String[] args) {
        System.out.println(CatalanBST.how_many_BSTs(4));
    }
}
