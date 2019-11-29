package org.cshah.algorithms.ik.dp;

public class TwoGroupWeight {

    /**
     *  T = O(2 ^ n)
     *  S = O (n)
     * @param data
     * @param index
     * @param sum
     * @return
     */
    public static boolean checkWeight(int[] data, int index, int sum ) {
        if (sum == 0 )
            return  true;

        if (index == data.length)
            return  false;

        boolean result = false;
        if (sum >= data[index]) {
            result = checkWeight(data, index+1, sum-data[index]);
        }
        return  result ||
                checkWeight(data, index+1, sum);
    }

    /**
     *  T  = O (n * halfsum)
     *  S = O (n * halfsum)
     * @param data
     * @param halfSum
     * @return
     */
    public static boolean checkWeightDP(int[] data, int halfSum) {
        boolean[][] DP = new boolean[data.length+1][halfSum+1];

        for (int row=0; row < data.length;row++) {
            DP[row][0] = true;
        }

        for (int i = data.length-1; i >=0; i--) {
            for (int sum=1;sum <= halfSum; sum++) {
                boolean result = false;

                if (sum >= data[i]) {
                    result = DP[i+1][sum-data[i]];
                    DP[i][sum] = result || DP[i+1][sum];
                }
            }
        }


        return DP[0][halfSum];

    }
    public static void main(String[] args) {
        int[] data = new int[] {1,2,3,4,5,7};
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }

        if (sum%2 == 0) {
            System.out.println(TwoGroupWeight.checkWeight(data, 0, sum / 2));
            System.out.println(TwoGroupWeight.checkWeightDP(data, sum / 2));

        }
    }
}
