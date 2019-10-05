package org.cshah.algorithms.array;

/**
 * Created by cshah on 6/15/14.
 */
public class ProductOfArray {

    public static int recursive(int[] a, int[] products, int index, int p) {

        if (index == a.length) {
            System.out.println();
            return 1;
        }
        products[index] = p;
//        System.out.print("P " + products[index] + " ");
        int result = recursive(a, products, index + 1, p * a[index]);
//        System.out.print("R " + result + " ");
        products[index] = products[index] * result;
//        System.out.println("X " + products[index] + " " + (result * a[index]));
        return result * a[index];
    }

     public static void main(String[] args) {
     int a[] = new int[] {2,3,4};
     int products[] = new int[a.length];

        ProductOfArray.recursive(a,products,0,1);

        for (int t : products) {
            System.out.println("Total " + t );
        }
    }
}
