package org.cshah.algorithms.string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        genPareRec(n, n, "", list);
        return list;
    }

    public void genPareRec(int leftP, int rightP, String s, List<String> list) {

        if (rightP < leftP)
            return;

        if (leftP == 0 && rightP == 0) {
            list.add(s);
            return;
        }

        if (leftP > 0) {
            genPareRec(leftP - 1, rightP, s + "(", list);
        }

        if (rightP > 0) {
            genPareRec(leftP, rightP - 1, s + ")", list);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> list = generateParenthesis.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println(generateParenthesis.reverse(123));
        System.out.println(generateParenthesis.reverse(-123));
        System.out.println(generateParenthesis.reverse(123456));
        System.out.println(generateParenthesis.reverse(5550));
        System.out.println(generateParenthesis.reverse(-1111));
        System.out.println(generateParenthesis.reverse(1534236469));

        System.out.println(Integer.MAX_VALUE - 1);
    }


    public int reverse(int x) {
        if (x == 0)
            return x;
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        long y = 0;
        while (x > 0) {
            y = y * 10 + x % 10;
            if (y > Integer.MAX_VALUE)
                return 0;
            x /= 10;
        }

        if (isNegative) {
            y = -y;
        }
        return (int) y;
    }

}