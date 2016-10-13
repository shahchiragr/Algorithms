package org.cshah.algorithms.tree;

/**
 * Created by cshah on 4/29/14.
 */
public class PrintBinary {

    public static String printBinary(String n) {
        int intpart = Integer.parseInt(n.substring(0, n.indexOf('.')));
        double decpart = Double.parseDouble(n.substring(n.indexOf('.'), n.length())) ;

        String int_string = "";
        while (intpart >0 ) {
            int r = intpart%2;
            intpart = intpart >>1;
            int_string = r + int_string;
        }

        StringBuffer sb = new StringBuffer();

        while (decpart >0) {
            if (sb.length() > 32)return  "ERROR";

            if (decpart == 1) {
                sb.append((int)decpart);
                break;
            }

            double r = decpart * 2;
            System.out.println("R " + r) ;
            if ( r >= 1) {
                sb.append("1");
                decpart = r-1;
            } else {
                sb.append(0);
                decpart =r;
            }
        }

        return int_string + "." + sb.toString();

    }
    private static void convertInttoBin(int i) {
        int shift = 1;
        char[] buf = new char[32];
        int charPos = 32;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {

            System.out.print( i & mask);
            i = i >>> shift;
        } while (i != 0);
    }

    public static int swapOddEvenBits(int x) {
        return  (( (x & 0xaaaaaaaa) >> 1) | (( x & 0x55555555) <<1));
    }
    public static void main(String args[]) {
        //System.out.println("Print Binary : " + PrintBinary.printBinary("0.01"));
        System.out.println(PrintBinary.swapOddEvenBits(7));
        PrintBinary.convertInttoBin(7) ;
    }
}
