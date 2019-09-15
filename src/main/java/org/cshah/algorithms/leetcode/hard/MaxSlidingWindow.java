package org.cshah.algorithms.leetcode.hard;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] results = new int[0];

        if (k > nums.length || k ==0)
            return results;

        if (k == 1)
            return  nums;

        results = new int[nums.length - k+1];
        int windowStart =0;
        int runningMax = nums[0];
        int maxItemIndex = 0;
        int resultIndex = 0;
        for (int windowEnd=0; windowEnd < nums.length;windowEnd++) {

        //    int previousMax = runningMax;
            if ( runningMax < nums[windowEnd]) {
                runningMax = nums[windowEnd];
                maxItemIndex = windowEnd;
            }

            if (windowEnd >= k-1) {
          //      System.out.println("Running max " + runningMax + " " + maxItemIndex);
                results[resultIndex++] = runningMax;
                //mean max Item is about to be excluded from this window
                if (maxItemIndex == windowStart) {
                    int tempMax = nums[windowStart+1];
                    int tempIndex = windowStart+1;
                    for (int  i = windowStart+2; i <= windowEnd; i++) {
                        if (nums[i] >= tempMax) {
                            tempMax = nums[i];
                            tempIndex = i;
                        }
                    }

                    runningMax = tempMax;
                    maxItemIndex = tempIndex;
                }

                windowStart++;
            }
         }

        return results;
    }


    public void findMax(int[] data, int k) {
        int results[] =  maxSlidingWindow(data,k);
        for (int max : results) {
            System.out.print(max + ",");
        }
        System.out.println("");
        System.out.println("=======");

    }
    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow.findMax(nums,3);
        nums = new int[]{3,2,1,1,1,4,1,5};
        maxSlidingWindow.findMax(nums,3);

        maxSlidingWindow.findMax(nums,4);
        maxSlidingWindow.findMax(nums,2);

    }
}
