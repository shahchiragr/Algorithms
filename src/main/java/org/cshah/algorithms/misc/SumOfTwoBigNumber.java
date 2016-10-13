package org.cshah.algorithms.misc;

/**
 * Created by cshah on 5/11/14.
 */
public class SumOfTwoBigNumber {

    public static int[] intToIntArray(int number) {
        int[] arr  = new int[SumOfTwoBigNumber.getSize(number)];
        int max = arr.length-1;
        while (number > 0) {
             int mod = number %10;
            arr[max--] = mod;
            number /= 10;
        }

        return arr;
    }

    public static  int getSize(int number) {
        int count =0;
        while (number > 0) {
            int mod = number %10;
            number -= mod;
            number /=10;
            count++;
        }
        System.out.println("SIZE " + count);
        return  count;
    }

    public static int[] sumTwoNumbers(int[] a, int[] b) {
        int c[] = new int[a.length > b.length ? a.length +1 : b.length+1];
        int i = a.length-1;
        int j = b.length-1;
        int k= c.length-1;
        while ( i >= 0 && j >=0) {
            int sum = c[k] + a[i] + b[j];
            c[k] = sum%10;
            c[k-1] = sum/10;
            i--;
            j--;
            k--;
        }


        return c;
    }

    public static void printInt(int[] a) {
        for (int i=0; i< a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();

    }
    public static void main(String args[]) {
        int ii[] = SumOfTwoBigNumber.intToIntArray(123456789);
        int jj[] = SumOfTwoBigNumber.intToIntArray(123456789);
        printInt(ii);
        printInt(jj);

        int c[] = SumOfTwoBigNumber.sumTwoNumbers(ii,jj);
        printInt(c);

    }
}
