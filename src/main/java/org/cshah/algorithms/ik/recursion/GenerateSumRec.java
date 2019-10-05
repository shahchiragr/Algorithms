package org.cshah.algorithms.ik.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateSumRec {

    static String[] generate_all_expressions(String s, long target) {
        List<String> resultList = new ArrayList<String>();
        exprRec(s,target,"",0,0,resultList);
        String[] arr = new String[resultList.size()];
        arr = resultList.toArray(arr);
        return arr;
    }

    static void exprRec(String str, long target , String result,
                        long runningSum, long runningSum_right_most_sign, List<String> resultList) {
        if (str.length() == 0 ) {
            if (target == runningSum) {
                resultList.add(result);
            }
        //    System.out.println(result + " : " + runningSum);
            return;
        }

        for (int i=1; i <= str.length();i++) {
            String part = str.substring(0,i);
            long num_to_add = Long.parseLong(part);

            if (result.isEmpty()) {
                exprRec(str.substring(i), target, result + part,
                        runningSum * 10 +  num_to_add,
                        runningSum * 10 +  num_to_add,resultList);
            } else if (!result.isEmpty()) {
                exprRec(str.substring(i), target, result + "+" + part,
                        runningSum + num_to_add,
                        num_to_add,resultList);

               // System.out.println( result + "*" + part + " => " + runningSum + " : " + runningSum_right_most_sign + " : " + num_to_add );
                exprRec(str.substring(i), target, result + "*" + part,
                        runningSum - runningSum_right_most_sign  + (runningSum_right_most_sign * num_to_add),
                        runningSum_right_most_sign * num_to_add, resultList);
            }
        }
    }

    public static void main(String[] arg) {
        String[] result;

//        result = GenerateSumRec.generate_all_expressions("222",24);
//        for (String s: result) {
//            System.out.println(s);
//        }

         result = GenerateSumRec.generate_all_expressions("1234",11);

        for (String s: result) {
            System.out.println(s);
        }
    }
}
