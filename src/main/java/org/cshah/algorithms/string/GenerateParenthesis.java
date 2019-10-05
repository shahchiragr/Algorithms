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
        List<String> list = generateParenthesis.generateParenthesis(4);
        for (String s : list) {
            System.out.println(s);
        }

    }

}