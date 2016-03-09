package com.example.algorithms.string;

/**
 * Created by cshah on 5/8/14.
 */
public class PrintStringsAccordingToNumber {
    static String alphabet="#abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) {

        parseNumber(0,3,"1123","");




    }

    private static void parseNumber(int i, int j, String string,String result) {
        if(j<i){System.out.println(result); return;}

        int c=Integer.parseInt(string.charAt(j)+"");
        if(c<=26)parseNumber(i, j-1, string, alphabet.charAt(c)+result);

        if(j>0){
            c=Integer.parseInt(string.charAt(j-1)+""+string.charAt(j)+"");
            if(c<=26)parseNumber(i, j-2, string, alphabet.charAt(c)+result);
        }

    }
}
