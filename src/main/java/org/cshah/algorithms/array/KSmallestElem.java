package org.cshah.algorithms.array;

/**
 * Created by chirag on 9/22/16.
 * http://articles.leetcode.com/find-k-th-smallest-element-in-union-of/
 */

public class KSmallestElem {
    int INT_MIN = Integer.MIN_VALUE;
    int INT_MAX = Integer.MAX_VALUE;

    public int findKthSmallest(int A[], int m, int B[], int n, int k) {
        assert(m >= 0); assert(n >= 0); assert(k > 0); assert(k <= m+n);

        int i = (int)((double)m / (m+n) * (k-1));
        int j = (k-1) - i;

        assert(i >= 0); assert(j >= 0); assert(i <= m); assert(j <= n);
        // invariant: i + j = k-1
        // Note: A[-1] = -INF and A[m] = +INF to maintain invariant
        int Ai_1 = ((i == 0) ? INT_MIN : A[i-1]);
        int Bj_1 = ((j == 0) ? INT_MIN : B[j-1]);
        int Ai   = ((i == m) ? INT_MAX : A[i]);
        int Bj   = ((j == n) ? INT_MAX : B[j]);

        if (Bj_1 < Ai && Ai < Bj)
            return Ai;
        else if (Ai_1 < Bj && Bj < Ai)
            return Bj;

        assert((Ai > Bj && Ai_1 > Bj) ||
                (Ai < Bj && Ai < Bj_1));

        // if none of the cases above, then it is either:
        if (Ai < Bj)
            // exclude Ai and below portion
            // exclude Bj and above portion
            return findKthSmallest(A, m-i-1, B, j, k-i-1);
        else /* Bj < Ai */
            // exclude Ai and above portion
            // exclude Bj and below portion
            return findKthSmallest(A, i, B, n-j-1, k-j-1);
    }

    public static void main(String args[] ) {
        int A[] = new int[] {8,15,20,25,30};
        int B[] = new int[] {2,9,17,29};

        //TODO - problem with code
        /** Problem with code */
        KSmallestElem kSmallestElem = new KSmallestElem();
        int elem = kSmallestElem.findKthSmallest(A, A.length, B, B.length, 3);
        System.out.println("ELEM " + elem);


    }
}
