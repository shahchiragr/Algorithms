package org.cshah.algorithms.leetcode.medium;

/**
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyString {
    public String multiply(String num1, String num2) {
        if (num1.length() ==0)
            return  num2;
        if (num2.length() ==0)
            return  num1;

        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int[] result = new int[num1.length() + num2.length()];
        int num1Len = num1.length()-1;
        int num2Len = num2.length() -1;

        for (int i= num1Len; i >=0; i--) {
            for (int j= num2Len; j>=0; j--) {
                int total = (num1.charAt(i) - '0')* (num2.charAt(j)-'0');
                int p1 = i +j;
                int p2 = i+j+1;

                int sum = total + result[p2];
                result[p1] += (sum/10) ;
                result[p2] = (sum%10) ;
            }
        }
        StringBuffer sb = new StringBuffer();
        boolean shouldStop = false;
        for (int s : result) {
            if ( s!=0 )
                shouldStop=true;

            if (!(s==0 && !shouldStop))
                sb.append(s);
        }
        return  sb.toString();
    }


    public static void main(String[] args) {
        MultiplyString multiplyString = new MultiplyString();
        System.out.println(multiplyString.multiply("15","15"));
    }
}
