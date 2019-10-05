package org.cshah.algorithms.ik.sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArray {

    static class ArrayItem {
        int value;
        int index;

        public ArrayItem(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    static int[] mergeArrays(int[][] arr) {

        if (arr == null || arr.length==0)
            return new int[0];
        int result[] = new int[arr.length * arr[0].length];
        int row = arr.length;
        int col = arr[0].length;
        int totalCount = row * col;
        int currentIndex = 0;
        int[] rowIndex = new int[row];
         boolean increasing = true;

        for (int i=1; i < arr[0].length;i++) {
            if (arr[0][i] < arr[0][i-1]) {
                increasing = false;
                break;
            }
        }

        Comparator<ArrayItem> increasingComparator = new Comparator<ArrayItem>() {
            @Override
            public int compare(ArrayItem o1, ArrayItem o2) {
                if (o1.value < o2.value)
                    return   -1;

                if (o1.value > o2.value)
                    return  1;

                return 0;
            }
        };

        Comparator<ArrayItem> decreasingComparator = new Comparator<ArrayItem>() {
            @Override
            public int compare(ArrayItem o1, ArrayItem o2) {
                if (o1.value > o2.value)
                    return  -1;

                if (o1.value < o2.value)
                    return  1;

                return 0;
            }
        };
        PriorityQueue<ArrayItem> minHeap = new PriorityQueue<ArrayItem>(increasing ? increasingComparator : decreasingComparator);

        for (int i=0; i < row; i++) {
            minHeap.offer(new ArrayItem(arr[i][0], i));
            rowIndex[i] = 0;
        }

        while (currentIndex < totalCount) {
            ArrayItem arrayItem = minHeap.poll();
            result[currentIndex] = arrayItem.value;
            currentIndex++;

            if (rowIndex[arrayItem.index] < col-1) {
                rowIndex[arrayItem.index]++;
                minHeap.offer(new ArrayItem(arr[arrayItem.index][rowIndex[arrayItem.index]], arrayItem.index ));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr2[][] = { {1, 3, 5, 7},
            {2, 4, 6, 8},
            {0, 9, 10, 11}} ;

        int arr[][] = {
                {34, 26, 20, 13, 11, 7, 4, 4},
                {41, 34, 27, 23, 19, 10, 8, 0},
                {26, 25, 19, 12, 7, 7, 7, 5},
                {46, 39, 35, 33, 27, 19, 12, 9},
                {33, 24, 22, 18, 18, 10, 3, 0},
                {42, 35, 35, 30, 21, 20, 12, 9}
        };

        MergeKSortedArray mergeKSortedArray  = new MergeKSortedArray();
        int[] result = MergeKSortedArray.mergeArrays(arr);

        for (int i : result) {
            System.out.print(i + " ,");
        }
        System.out.println();
    }
}
