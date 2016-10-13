package org.cshah.algorithms.misc;

/**
 * Created by cshah on 5/3/14.
 */
public class FindMissingInteger {

    public static void findMissingInt() {
        int k = 2;
        byte bitfield[] = new byte[k];
        for (int i=0; i < k*8; i++)  {
            System.out.print("["+i + "]:[" + i/8 + "]:[" + i%8 + "] == Arr " + bitfield[i / 8]);

            if (i != 10)
             bitfield[i/8]  |=  1 << (i%8);

            System.out.println(" Arr " + bitfield[i/8]);
            //System.out.println("i " + i + ":" + i%8 + ":" + i/8 );
        }

        for (int i=0; i < bitfield.length; i++) {
            for (int j=0; j<8;j++) {
                 if ((bitfield[i] & (1 <<j)) ==0 ) {
                     System.out.println("Missing " + (i *8 + j));
                 }
            }
        }
     }
    public static void main(String args[]) {

        FindMissingInteger.findMissingInt();
    }

}
