package org.cshah.algorithms.interviewcake;

public class AtoI {

    public int myAtoi(String str) {
        char carray[] = str.toCharArray();
        if (str == null || str.length() == 0)
            return 0;

        int i =0;
        while ( i < carray.length && carray[i] ==  ' ' ) {
            i++;
        }

        if (i >= carray.length)
            return 0;

        if ( (carray[i] >= 'a' && carray[i] <= 'z' ) ||
                (carray[i] >= 'A' && carray[i] <= 'Z') )
            return 0;

        boolean isNegative = false;
        if (carray[i] == '-') {
            i++;
            isNegative = true;
        } else if (carray[i] == '+') {
            i++;
        }

        long num=0;
        while (i < carray.length && carray[i] >= '0' && carray[i] <= '9') {
            num = num*10 + carray[i]-'0';
            i++;

            if (num > Integer.MAX_VALUE) {
                if (isNegative)
                    return Integer.MIN_VALUE;

                return Integer.MAX_VALUE;
            }
        }

        if (isNegative) {
            num *= -1;
        }


        return (int)num;
    }

    public static void main(String[] args) {
        AtoI atoI = new AtoI();

        System.out.println( atoI.myAtoi("  -42"));
        System.out.println( atoI.myAtoi("+1"));
        System.out.println( atoI.myAtoi("-"));
        System.out.println( atoI.myAtoi(" "));
        System.out.println( atoI.myAtoi("   -123"));
        System.out.println( atoI.myAtoi("-456"));
        System.out.println( atoI.myAtoi("123"));
        System.out.println( atoI.myAtoi("4193 with words"));
        System.out.println( atoI.myAtoi("words and 987"));
        System.out.println( atoI.myAtoi("-91283472332"));
        System.out.println( atoI.myAtoi("9223372036854775808"));

    }
}
