package org.cshah.algorithms.string;

/**
 * Created by chirag on 9/22/16.
 */
public class StringCombination {

    static int counter= 0;
    public void combine(String str) {
        int length = str.length();
        char[] in = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        doCombination(in, sb, length, 0, 0);
    }

    private void doCombination(char[] in, StringBuffer sb, int length, int level, int start) {
        for (int i=start; i < length; i++) {
            sb.append(in[i]);
            System.out.println(sb.toString());
            counter++;

            if (i < length-1) {
                doCombination(in, sb, length, level + 1, i + 1);
            }

            sb.setLength(sb.length()-1);
        }
    }
    public static void main(String args[]) {
        StringCombination stringCombination = new StringCombination();
        stringCombination.combine("xyzf");
        System.out.println("counter is" + counter);
    }
}
