package org.cshah.algorithms.leetcode.hard;

public class ValidDecimalNumber {

    public boolean isNumber(String s) {
     //   System.out.println("String => " + s);
        if (s == null || s.length() == 0)
            return false;

        String str = s.trim();

        if (str.length() ==0)
            return false;

        if (str.length() == 1 && (str.charAt(0) >= '0' &&  str.charAt(0) <= '9'))
            return true;

        char[] chars = str.toCharArray();

        int index =0;
        int signCount =0;
        StringBuffer leftBuffer = new StringBuffer();
        StringBuffer rightBuffer = new StringBuffer();

        while (index < chars.length && !isEpsilon(chars[index])) {
            char c = chars[index];

            if (!isValidCharacter(c))
                return false;

            if (isSign(c)) {
                signCount++;
                if (signCount > 1)
                    return false;
            }

            leftBuffer.append(c);
            index++;
        }

        //there is no e
        if (index == chars.length)
            return  verifyNumber(leftBuffer.toString());

        boolean foundEpsilon = true;
        signCount =0;

        index++;
        while ( index < chars.length) {
            char c = chars[index];

            if (!isValidCharacter(c) || c == '.' || c == 'e')
                return false;


            if (isSign(c)) {
                signCount++;
                if (signCount > 1)
                    return false;
            }

            rightBuffer.append(c);
            index++;
        }

    //    System.out.println(leftBuffer.toString() + " === " + rightBuffer.toString());

        if (foundEpsilon && (!verifyNumber(leftBuffer.toString()) || !verifyNumber(rightBuffer.toString())))
            return false;

        return true;
    }

    public boolean verifyNumber(String str) {

        try {
            Double.parseDouble(str);
        }catch (Exception e) {
            return false;
        }
//        double currentNum = 0d;
//        int times = 10;
//        int divisor=1;
//        char[] chars = str.toCharArray();
//        int index =0;
//
//        if (str.length() ==1 && str.charAt(0) == '.')
//            return false;
//
//        while (index < str.length()) {
//            if (chars[index] >= '0' && chars[index] <= '9') {
//                currentNum = currentNum * times + (double)(chars[index]-'0')/divisor;
//                if (divisor > 1)
//                    divisor *=10;
//            } else if (chars[index] == '.') {
//                times =1;
//                divisor=10;
//            }
//            index++;
//        }

     //   System.out.println(currentNum);
      //  if (currentNum == 0)
      //      return  false;
        return true;
    }

    private boolean isValidCharacter(char c) {
        if (c >= '0' && c <= '9')
            return  true;

        if (c == 'e' || c == '-' || c == '+' || c == '.')
            return  true;


        return false;
    }


    private boolean isSign(char c) {
        return (c == '-' || c == '+');
    }

    private boolean isEpsilon(char c) {
        return c == 'e';
    }


    /*
        "0" => true
        " 0.1 " => true
        "abc" => false
        "1 a" => false
        "2e10" => true
        " -90e3   " => true
        " 1e" => false
        "e3" => false
        " 6e-1" => true
        " 99e2.5 " => false
        "53.5e93" => true
        " --6 " => false
        "-+3" => false
        "95a54e53" => false
     */

    public static void main(String args[]) {
        ValidDecimalNumber validDecimalNumber = new ValidDecimalNumber();

    //    System.out.println(validDecimalNumber.verifyNumber("0"));

        System.out.println(validDecimalNumber.isNumber("0"));

        System.out.println(validDecimalNumber.isNumber("0.1"));

        System.out.println(validDecimalNumber.isNumber("abc"));

        System.out.println(validDecimalNumber.isNumber("1 a"));

        System.out.println(validDecimalNumber.isNumber("2e10"));

        System.out.println(validDecimalNumber.isNumber("-90e3"));

        System.out.println(validDecimalNumber.isNumber("1e"));

        System.out.println(validDecimalNumber.isNumber("e3"));

        System.out.println(validDecimalNumber.isNumber("6e-1"));

        System.out.println(validDecimalNumber.isNumber("99e2.5"));

        System.out.println(validDecimalNumber.isNumber("53.5e93"));

        System.out.println(validDecimalNumber.isNumber(" --6 "));

        System.out.println(validDecimalNumber.isNumber("-+3"));

        System.out.println(validDecimalNumber.isNumber("95a54e53"));

        System.out.println(validDecimalNumber.isNumber("."));

        System.out.println(validDecimalNumber.isNumber("e"));

        System.out.println(validDecimalNumber.isNumber(".0"));

        System.out.println(validDecimalNumber.isNumber("0."));

        System.out.println(validDecimalNumber.isNumber("..."));

        System.out.println(validDecimalNumber.isNumber(".e1"));

        System.out.println(validDecimalNumber.isNumber("92e1740e91"));

        System.out.println(validDecimalNumber.isNumber( " -.7e+0435"));



    }
}
