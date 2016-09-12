package com.example.algorithms.array;


//http://www.ardendertat.com/2011/10/18/programming-interview-questions-9-convert-array/

public class ConvertArray {

    public static void convertArray(int[] array, int n) {
        int len = array.length;
            for (int i = 0; i < len; i++) {
                int index = getIndex(i, n);
                if (index > i) {
                    int temp = array[i];
                    array[i] = array[index];
                    array[index] = temp;
                }
            }
    }

    public static int getIndex(int currentIndex, int n) {
        return (currentIndex%3) * n + currentIndex/3;
    }
    public static void main(String[] args) {
        int ar[] = {1,2,3,4,5,6,7,8,9};
        int N = 3;
        Sorting.print(ar);

        ConvertArray.convertArray(ar,N);
        Sorting.print(ar);
    }

//    0 1 2 3 4 5 6 7 8
//    1 2 3 4 5 6 7 8 9

//            0 index 0
//            1 index 3
//            2 index 6
//            3 index 1
//            4 index 4
//            5 index 7
//            6 index 2
//            7 index 5
//            8 index 8

}
