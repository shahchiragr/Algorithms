package org.cshah.algorithms.bit;

/**
 * Created by chirag on 9/11/16.
 */
public class LSBMSB {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int val = 0x118;

        Byte b1 = (byte)val;
        Byte b2 = (byte) ((byte)val << 8);


        int msb = val & 0x80;
        int lsb = val & 1;
        boolean isMSB = msb < 0;

        System.out.println("MSB : " + msb + ":" +  isMSB + ", LSB : " + lsb);

        short x = (short) 0xabcd;

        byte high = (byte)(x >>> 8);

        byte low = (byte)x;/* cast implies & 0xff */

        System.out.println( "x=" + x + " high=" + high + " low=" + low );

        System.out.println(Integer.reverseBytes(1) + ":" + 0x00ff  + ":" + 0xff + ":" +  0xff00);
    }

}
