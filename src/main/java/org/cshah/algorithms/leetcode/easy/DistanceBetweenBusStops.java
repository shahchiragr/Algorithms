package org.cshah.algorithms.leetcode.easy;

/**
 * https://leetcode.com/problems/distance-between-bus-stops/
 */
public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            int sum1 = 0;
            int total = 0;
            if (destination < start) {
                int temp = destination;
                destination = start;
                start = temp;
            }
            for (int i=0; i < distance.length; i++) {
                if (i >= start && i < destination)
                        sum1 += distance[i];

                total += distance[i];
            }
            int sum2 = total - sum1;
            return Math.min(sum1, sum2);
    }


    public static void main(String[] args) {
        DistanceBetweenBusStops distanceBetweenBusStops = new DistanceBetweenBusStops();
        int[] arr = new int[] {1,2,3,4};

        System.out.println(distanceBetweenBusStops.distanceBetweenBusStops(arr,0,1));
        System.out.println(distanceBetweenBusStops.distanceBetweenBusStops(arr,0,2));
        System.out.println(distanceBetweenBusStops.distanceBetweenBusStops(arr,0,3));

        arr = new int[] {7,10,1,12,11,14,5,0};
        System.out.println(distanceBetweenBusStops.distanceBetweenBusStops(arr,7,2));

    }
}
