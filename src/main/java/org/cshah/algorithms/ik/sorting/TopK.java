package org.cshah.algorithms.ik.sorting;

import java.util.*;

public class TopK {

    static int[] topK(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        int runningCounter =0;
        Set<Integer> uniqueSet = new HashSet<Integer>();

        for (int i = 0; i < arr.length; i++)  {
            if (runningCounter < k ) {
                if (!uniqueSet.contains(arr[i])) {
                    uniqueSet.add(arr[i]);
                    maxHeap.offer(arr[i]);
                    runningCounter++;
                }
            } else {
                if (maxHeap.peek() < arr[i] && !maxHeap.contains(arr[i])) {
                    maxHeap.poll();
                    maxHeap.offer(arr[i]);
                }
            }
        }

        Set<Integer> integerSet = new HashSet<Integer>();

        while (!maxHeap.isEmpty()) {
            integerSet.add(maxHeap.poll());
        }
        int[] result = new int[integerSet.size()];
        int count = 0;
        Iterator<Integer> iterator = integerSet.iterator();
        while (iterator.hasNext()) {
            result[count++] = iterator.next();
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4,5};
         arr = new int[] {1,5,1,5,1};
         arr = new int[] {
                 4,
                 8,
                 9,
                 6,
                 6,
                 2,
                 10,
                 2,
                 8,
                 1,
                 2
         };
      //  arr = new int[] {1,2,3,5,4,3,2,1};
        arr = new int[] {
                2,
                9,
                3,
                1,
                10,
                6,
                7,
                7,
                9,
                10,
                7
        };
        int k  = 6;
        int[] result =TopK.topK(arr, k);
        for (int i : result) {
            System.out.print(i + " " );
        }

    }
}
