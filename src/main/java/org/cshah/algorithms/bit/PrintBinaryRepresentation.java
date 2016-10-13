package org.cshah.algorithms.bit;

/**
 * Created by chirag on 9/4/16.
 */
public class PrintBinaryRepresentation {

    public static String printBinary(double num) {
        if (num >= 1 || num <=0)
            return "ERROR";

        StringBuilder sb = new StringBuilder();
        sb.append(".");

        while (num > 0) {
        System.out.println(num  + ":" + sb.toString());
            if (sb.length() >= 320) {
                return "ERROR";
            }

            double r = num *2;
            if (r >= 1) {
                sb.append("1");
                num = r-1;
            } else {
                sb.append("0");
                num = r;
            }
        }

        return sb.toString();
    }

    public static String printBinaryFrac(double num) {
        if (num >= 1 || num <=0)
            return "ERROR";

        StringBuilder sb = new StringBuilder();
        sb.append(".");
        double frac = 0.5;

        while (num > 0) {
            System.out.println(num  + ":" + sb.toString());
            if (sb.length() >= 320) {
                return "ERROR";
            }

            if (num >= frac) {
                sb.append("1");
                num = num -frac;
            } else {
                sb.append("0");

            }

            frac = frac/2;
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        System.out.println("BIN STRING " + PrintBinaryRepresentation.printBinaryFrac(0.625));
        System.out.println("BIN STRING " + PrintBinaryRepresentation.printBinary(0.5));

    }
}
