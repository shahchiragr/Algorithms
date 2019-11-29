package org.cshah.algorithms.ik.dp;

public class MaxCoinWin {

    static int maxWin(int[] v) {

        return maxWinRecursive(v, 0, v.length-1);
    }

    static int maxWinRecursive(int[] v, int start, int end) {
        if (start > end)
            return  0;


        return Math.max( v[start] +
                        Math.min(maxWinRecursive(v, start+2, end), maxWinRecursive(v, start+1, end-1)),
                 v[end] +
                         Math.min( maxWinRecursive(v, start, end-2), maxWinRecursive(v, start+1, end-1)));
    }

    static int maxWinDP(int[] v) {
        int table[][] = new int[v.length][v.length];
        int n = v.length;
        for (int gap=0; gap < n; gap++) {
            for (int start=0, end=gap; end < n; start++, end++) {
                int num1 = start +2 <= end ? table[start+2][end] : 0;
                int num2 = start +1 <= end-1 ? table[start+1][end-1] : 0;
                int num3 = start <= end-2 ? table[start][end-2] : 0;

                table[start][end] = Math.max(v[start] + Math.min(num1,num2), v[end] + Math.min(num2, num3));
            }
        }

        /*
        for (int i=0; i < n; i++) {
            for (int j=0; j< n; j++) {
                System.out.print(table[i][j]+  " | ");
            }
            System.out.println();
        } */
        return  table[0][n-1];

    }

    /*
    static int maxWinRec_2(int[] v, int start, int end) {
            if (start > end)
                return  0;

            return  v[start] > v[end] ? maxWinRec_1(v, start+1, end) : maxWinRec_1(v, start, end-1);
    }

     */

    public static void main(String[] args) {
        int array[] = new int[] {8,15,3,7};
        System.out.println(MaxCoinWin.maxWin(array));
        System.out.println(MaxCoinWin.maxWinDP(array));

         array = new int[] {20,30,2,2,2,10};
        System.out.println(MaxCoinWin.maxWin(array));
        System.out.println(MaxCoinWin.maxWinDP(array));

    }
}
