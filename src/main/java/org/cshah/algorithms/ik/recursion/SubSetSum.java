package org.cshah.algorithms.ik.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {

    public int subSetSumRec(List<Integer> data, int sum) {
        if (data.size() == 0 ) {
            if (sum == 0)
                return  1;
            else
                return  0;
        }

        int number = data.get(0);

        return  subSetSumRec( data.subList(1, data.size()),sum) + /* first one to exclude the number, so just pass the same sum */
                subSetSumRec( data.subList(1, data.size()),sum -number); /* include this number, but exclude from the sum */
    }
    public static void main(String[] args) {
        List<Integer> data =new ArrayList<Integer>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        data.add(-1);
        data.add(-2);
        SubSetSum subSetSum = new SubSetSum();

        int total = subSetSum.subSetSumRec( data,3);
        System.out.println("Total " + total);
    }
}
