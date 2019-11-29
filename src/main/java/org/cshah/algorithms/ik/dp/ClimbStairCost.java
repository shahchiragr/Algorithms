package org.cshah.algorithms.ik.dp;

public class ClimbStairCost {

    public static int getCostForClimbStairs(int[] costArray) {
        int data[] = new int[costArray.length+2];
        data[0] = 0;
        data[data.length-1] =0;
        data[1] = costArray[0];

        for (int i=2 ; i < data.length-1; i++) {
            data[i] = costArray[i-1] + Math.min(data[i-1], data[i-2]);
        }

        data[data.length-1] = Math.min(data[data.length-2], data[data.length-3]);
        for (int cost : data) {
            System.out.print(cost + " | ");
        }
        System.out.println();
        return data[data.length-1];
    }

    public static void  main(String[] args) {
        int costArray[] = new int[] {1,2,3,4,1,6,7,8,9};
        System.out.println("Total cost for climbing stairs... " + ClimbStairCost.getCostForClimbStairs(costArray));
    }
}
