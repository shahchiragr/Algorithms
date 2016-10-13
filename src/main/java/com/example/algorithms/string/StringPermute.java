package com.example.algorithms.string;

/**
 * Created by chirag on 9/22/16.
 */
public class StringPermute {

    public void permute(String str) {
        int length = str.length();
        boolean[] used = new boolean[length];
        StringBuffer sb = new StringBuffer();
        char[] in = str.toCharArray();

        for (int i=0; i < used.length; i++) {
            used[i] = false;
        }

        doPermute(in, sb, used, length, 0);
    }

    public void doPermute(char[] in, StringBuffer sb, boolean[] used, int length, int level) {
        if (length == level) {
            System.out.println(sb.toString());
            return;
        }

        for (int i=0; i < length; i++) {
            if (used[i]) {
                continue;
            }

            sb.append(in[i]);
            used[i] = true;
            doPermute(in, sb, used, length, level+1);
            used[i] = false;
            sb.setLength(sb.length()-1);
        }
    }

    public static void main(String args[]) {
        StringPermute stringPermute = new StringPermute();
        stringPermute.permute("abcd");
    }
}
