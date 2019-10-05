package org.cshah.algorithms.ik.recursion;

import java.util.ArrayList;
import java.util.List;

public class WellFormBrackets {

    static String[] find_all_well_formed_brackets(int n) {
        List<String> results = new ArrayList<String>();
        find_all_well_formed_brackets_rec("", n,n,n,results);
        String[] arr = new String[results.size()];
        arr = results.toArray(arr);
        return arr;
    }

    static void find_all_well_formed_brackets_rec(String str, int left, int right, int n, List<String> results) {
        if (left == right  && right == 0) {
            results.add(str);
            return;
        }

        if (right == left) {
            find_all_well_formed_brackets_rec(str + "(", left-1, right, n,results);
        }

        if (left < right && left > 0) {
            find_all_well_formed_brackets_rec(str + "(", left-1, right, n,results);
        }

        if (right > 0) {
            find_all_well_formed_brackets_rec(str + ")", left, right - 1, n, results);
        }

    }

    public static void main(String[] args) {
        String result[] = WellFormBrackets.find_all_well_formed_brackets(2);
        for (String str : result) {
            System.out.println(str);
        }
    }
}
