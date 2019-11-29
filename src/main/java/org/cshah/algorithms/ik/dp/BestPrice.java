package org.cshah.algorithms.ik.dp;

import java.util.List;

public class BestPrice {

    static int bestPrice(int[] prices, int len) {
        if (len <= 0)
            return 0;

         int result = -1;
         for (int i=1; i < prices.length; i++) {
             result = Math.max(result, prices[i] + bestPrice(prices, len-1));
         }

         return  result;
    }


    //TODO this is not working...
    static int bestPriceIterative(int[] price, int len) {
        int[] DP = new int[len+1];
        DP[0] = price[0];
        DP[1] = price[1];
        for (int iLen=2; iLen <= len; iLen++ ) {
            int result = -1;
            for (int i=1; i < iLen; i++) {
                result = Math.max(result, price[i] + DP[iLen-i]);
            }
            DP[iLen] = result;
        }

        return  DP[len];
    }

    public static void main(String args[]) {
        int price[]= new int[] {0,1,3,0,1,2};
        int result = BestPrice.bestPrice(price, price.length);
        System.out.println("Result " + result);

     //   System.out.println("Result Iterative " + BestPrice.bestPriceIterative(price, price.length));
    }

}
