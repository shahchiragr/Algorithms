package org.cshah.algorithms.ik.dp;

import java.util.ArrayList;
import java.util.List;

public class MinCoin {

    public static int minimum_coins(List<Integer> coins, int value) {
        int[] table = new int[value+1];
        table[0] = 0;

        for (int i=1; i<= value; i++) {
            table[i]= Integer.MAX_VALUE;
        }

        for (int i=1; i <= value;i++) {
            for (int j=0; j <coins.size(); j++) {
                if (i - coins.get(j) >= 0) {
                    table[i] =   Math.min(table[i], table[i -coins.get(j)]);
                }
            }
            //as a lazy manager - add 1 at last...
            table[i] = 1 + table[i];
        }

        return table[value];
    }

    public static void main(String args[]) {
        int[] coins = new int[] {1,5,7};
        List<Integer> coinList = new ArrayList<Integer>();
        coinList.add(1);
        coinList.add(5);
        coinList.add(5);


        System.out.println("Total coins required... : "  + MinCoin.minimum_coins(coinList, 10));

        coinList.clear();
        coinList.add(1);
        coinList.add(3);
        coinList.add(5);

        System.out.println("Total coins required... : "  + MinCoin.minimum_coins(coinList, 9));

    }
}
