package com.example.algorithms.tree;

/**
 * Created by cshah on 5/17/14.
 */
public class ValidParentheses {

    public static  void printPar(int l, int r, char[] str, int count) {
        if (l < 0 || r < l )  return;

        if (l == 0 && r ==0) {
            System.out.println(str);
        }  else  {
            if (l >0 ) {
                str[count] = '{';
                printPar(l-1, r, str, count+1);
            }
            if ( r > 0) {
                str[count] = '}';
                printPar(l ,r-1, str, count+1);
            }
        }
    }

    public static void main(String args[]) {
        int count = 4;
        char[] str = new char[count*2];
        printPar(count, count, str, 0);
    }

 }

