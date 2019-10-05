package org.cshah.algorithms.array;

import java.util.HashMap;
import java.util.Map;

/**
 * This problem was asked by Airbnb.
 *
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
 *
 * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
 *
 * Follow-up: Can you do this in O(N) time and constant space?
 */
public class LargestSum {
    public int largestSum(int data[]) {
        if (data.length == 0)
            return  -1;
        if (data.length == 1)
            return data[0];

        if (data.length == 2)
            return Math.max(data[0],data[1]);

        int newMax = -1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, data[0] > 0 ? data[0]: 0);
        map.put(1, data[1] > 0 ? data[1]: 0);
        map.put(2, map.get(0) + (data[2] > 0 ? data[2]: 0));
        for (int i= 3; i < data.length; i++) {
            int max1 = map.get(i-2);
            int max2 = map.get(i-3);
            int newSum = Math.max(max1,max2) + (data[i] > 0 ? data[i] : 0);
            map.put(i, newSum);
            newMax = Math.max(newMax, newSum);
            //removing to maintain constant space - we only need last 3 elements in the map
            map.remove(i-3);
        }

   //     return Math.max(map.get(data.length-1), map.get(data.length-2));
        return  newMax;
    }

    public static void main(String[] args) {
        LargestSum largestSum = new LargestSum();
        int[] data = new int[]  {2, 4, 6, 2, 5};
       //  data = new int[]  {5,1,1,5};
      //  data = new int[]  {10,56,45,40,50,1,30};
     //   data = new int[]  {5,10,7,-9,-2,6};
       // data = new int[]  {1,2,3,4,5,6,5,4,3,-5,-6};

        System.out.println("Sum " + largestSum.largestSum(data));
    }
}
