package com.example.algorithms.string;

/**
 * Created by cshah on 6/16/14.
 */
/*************************************************************************
 *  Compilation:  javac LCS
 *  Execution:    java LCS < example10.txt
 *  Dependencies: StdIn.java
 *
 *  Reads in two strings from stdin and computes their longest
 *  common subsequence.
 *
 *************************************************************************/

public class LCS {

    public static String lcsRec(String a, String b){
        int aLen = a.length();
        int bLen = b.length();
        if(aLen == 0 || bLen == 0){
            return "";
        }else if(a.charAt(aLen-1) == b.charAt(bLen-1)){
            return lcsRec(a.substring(0,aLen-1),b.substring(0,bLen-1)) + a.charAt(aLen-1);
        }else{
            String x = lcsRec(a, b.substring(0,bLen-1));
            String y = lcsRec(a.substring(0,aLen-1), b);
            return (x.length() > y.length()) ? x : y;
        }
    }


    public static String lcs(String a, String b) {
        int[][] lengths = new int[a.length()+1][b.length()+1];

        // row 0 and column 0 are initialized to 0 already

        for (int i = 0; i < a.length(); i++)
            for (int j = 0; j < b.length(); j++)
                if (a.charAt(i) == b.charAt(j))
                    lengths[i+1][j+1] = lengths[i][j] + 1;
                else
                    lengths[i+1][j+1] =
                            Math.max(lengths[i+1][j], lengths[i][j+1]);

        // read the substring out from the matrix
        StringBuffer sb = new StringBuffer();
        for (int x = a.length(), y = b.length();
             x != 0 && y != 0; ) {
            if (lengths[x][y] == lengths[x-1][y])
                x--;
            else if (lengths[x][y] == lengths[x][y-1])
                y--;
            else {
                assert a.charAt(x-1) == b.charAt(y-1);
                sb.append(a.charAt(x-1));
                x--;
                y--;
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String x = "thisisatest";
        String y = "testing123testing";

        String returnString =LCS.lcs(x,y);
        System.out.println("Answer " + returnString);

        returnString =LCS.lcsRec(x,y);
        System.out.println("Answer Rec " + returnString);

        int M = x.length();
        int N = y.length();

        // opt[i][j] = length of LCS of x[i..M] and y[j..N]
        int[][] opt = new int[M+1][N+1];

        // compute length of LCS and all subproblems via dynamic programming
        for (int i = M-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
            }
        }


        for (int i=0;i<M+1;i++) {
            for (int j=0; j< N+1;j++) {
                System.out.print(opt[i][j]  +  " ");
            }
            System.out.println();
         }

        // recover LCS itself and print it to standard output
        int i = 0, j = 0;
        while(i < M && j < N) {
            if (x.charAt(i) == y.charAt(j)) {
                System.out.print(x.charAt(i));
                i++;
                j++;
            }
            else if (opt[i+1][j] >= opt[i][j+1]) i++;
            else                                 j++;
        }
        System.out.println();

    }

}