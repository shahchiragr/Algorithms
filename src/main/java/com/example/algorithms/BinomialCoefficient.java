package com.example.algorithms;

/**
 * Created by cshah on 4/23/14.
 */
public class BinomialCoefficient {

    public void binom(int n, int m) {
        int i,j;
        int arr[][] = new int[n+1][m+1];
        if (n >= 0) {
            if (m>n || m < 0) {
                System.out.println("ERROR");
                return;
            }
            for (i=0; i<=n; i++) arr[i][0] = 1;

            for (i=1; i<=m;i++)  arr[0][i] = 0;

            for (j=1;j<=m;j++) {
                for (i=1; i<=n;i++) {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }

            for (i=0;i<=n;i++) {
                for (j=0;j<=m;j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println("");
            }
        }//if
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinomialCoefficient obj = new BinomialCoefficient();
        obj.binom(5, 3);
    }

}