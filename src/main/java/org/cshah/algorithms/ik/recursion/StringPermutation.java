package org.cshah.algorithms.ik.recursion;

/**
 * This is DFS and time complexity is O(n! * n) which is O(n!) and the space complexity is the height of tree which is O(n)
 */
public class StringPermutation {


    public void stringPerm(String str, char[] array) {
        if (array.length ==0) {
            System.out.println(str);
            return;
        }

        for (int i=0; i < array.length;i++) {
            stringPerm(str + array[i], remove(array, i));
        }
    }

    public char[] remove(char[] array, int index) {
        char[] newArray = new char[array.length-1];
        int counter =0;
        for (int i =0; i < array.length; i++) {
            if (i != index) {
                newArray[counter++] = array[i];
            }
        }

        return newArray;
    }
    public static void main(String[] args) {
        StringPermutation stringPermutation = new StringPermutation();
        stringPermutation.stringPerm("", "abcd".toCharArray());
    }
}
