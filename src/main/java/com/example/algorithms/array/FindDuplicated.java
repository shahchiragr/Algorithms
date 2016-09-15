package com.example.algorithms.array;

/**
 * Created by chirag on 9/13/16.
 */
public class FindDuplicated {

    public static void findDuplicateNumber(int array[]) {
        byte bitarray[] = new byte[16];
        for (int i=0; i < array.length; i++) {
            int index = array[i]/8;
//            System.out.println( " HERE " + bitarray[index] );
            byte b = bitarray[index];
            int found = b & (1 << array[i]%8 );
            if ( found > 0  ) {
                System.out.println("Duplicate " + array[i]);
                continue;
            }

            bitarray[index] |= 1 << array[i]%8;
//            System.out.println( bitarray[index] );

        }

    }
    public static void main(String args[]) {
        int[] array = { 1,2,3,1,4,5,4};
        FindDuplicated.findDuplicateNumber(array);
    }
}
