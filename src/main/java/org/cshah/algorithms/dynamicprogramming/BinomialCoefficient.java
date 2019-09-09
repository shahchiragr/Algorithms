package org.cshah.algorithms.dynamicprogramming;

public class BinomialCoefficient {

    public static int computeBioCo(int x, int y) {
        int[][] data = new int[x+1][y+1];

        int returnData =  computeBioCoefficient(x,y,data);

        for (int i=0; i < x+1;i++) {
            for (int j=0; j < y+1; j++) {
                System.out.print (data[i][j] + " | ");
            }
            System.out.println("");
        }

        return returnData;
    }

    private static int computeBioCoefficient(int x, int y, int[][] data) {
        if (y ==0 || x == y) {
           // data[x][y] = 1;
            return 1;
        }

        if (data[x][y] == 0) {
            int sumy = computeBioCoefficient(x-1,y, data);
            int sumy1 = computeBioCoefficient(x-1,y-1, data);

            data[x][y] = sumy + sumy1;
        }

        return data[x][y];
    }

    public static void main(String[] args) {
        System.out.println(BinomialCoefficient.computeBioCo(3,3));
    }
}
