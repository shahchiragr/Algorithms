package com.example.algorithms.hackerrank;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by chirag on 9/28/16.
 */
public class TradeProbability {

    public static void calculateTrade(double[][] data, int totalTrade, int maxTrade) {
        double[] result = new double[totalTrade];

        for (int i = 0; i < totalTrade; i++) {
            result[i] = data[0][i] * data[1][i] - (1 - data[0][i]) * data[2][i];
        }

        Arrays.sort(result);

        double sum =0;
        int currentProb =0;
        for (int j = result.length-1; j >0 && currentProb < maxTrade; j--) {
            if (result[j] > 0) {
                sum += result[j];
            }
            currentProb++;
        }

//        for (int i=0; i < 4; i++) {
//            for (int j=0; j < totalTrade; j++) {
//                System.out.print(data[i][j] + " " );
//            }
//
//            System.out.println();
//        }


        System.out.println(String.format("%.2f", sum));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int trade = scanner.nextInt();
        int maxTrade = scanner.nextInt();
        double darray[][] = new double[4][trade];

        for (int i = 0; i < trade; i++) {
            darray[0][i] = scanner.nextDouble();
        }

        for (int i = 0; i < trade; i++) {
            darray[1][i] = scanner.nextDouble();
        }

        for (int i = 0; i < trade; i++) {
            darray[2][i] = scanner.nextDouble();
        }

        calculateTrade(darray, trade, maxTrade);
    }
}