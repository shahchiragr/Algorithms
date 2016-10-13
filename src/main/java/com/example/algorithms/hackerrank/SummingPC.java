package com.example.algorithms.hackerrank;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Created by chirag on 9/25/16.
 */
public class SummingPC {
    //static int TOTAL =0;
    public static void printCombination(ArrayList<Integer> list, int start, int length, int maxLength) {

        Map<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();

        if (start >= list.size() || length +1>= maxLength)
            return;

        for (int counter=list.size(); counter>0; counter--) {

            for (int k = 0; k < list.size(); k++) {
                List<List<Integer>> ssList = findCombination(list, k, counter);


                for (List<Integer> aList : ssList) {
                    if (map.containsKey(k)) {
                        map.get(k).add(aList);
                    } else {
                        List<List<Integer>> newLIst = new ArrayList<List<Integer>>();
                        newLIst.add(aList);
                        map.put(k, newLIst);
                    }
                }
            }
        }

        long totalSum = 0;
        List<List<Integer>> oList = map.get(0);

        for (List<Integer> keyList : oList) {
            List<List<Integer>> masterList1 = new ArrayList<List<Integer>>();
            totalSum += findCombination1(keyList.size(), map, list.size(), masterList1, keyList);
        }
        System.out.println(totalSum );


    }

    public static long findCombination1(int runningSize, Map<Integer, List<List<Integer>>> map, int size, List<List<Integer>> returnList, List<Integer> cList) {
        returnList.add(cList);
        long TOTAL =0;
        if (runningSize == size){
            for(List<Integer> i1List: returnList) {
                int ss = 0;
                for (Integer i1: i1List) {
//                    System.out.print(i1 + " ");
                    ss += i1;
                }

                TOTAL += ss * i1List.size();
//                System.out.println();
//                System.out.println("TOTAL " + TOTAL);
            }

//            System.out.println("=============================");

            return TOTAL;
        }


            int currentSize=runningSize;
            List<List<Integer>> mapList= map.get(currentSize);

             for (List<Integer> nList : mapList) {
                 List<List<Integer>> newList = new ArrayList<List<Integer>>();
                 newList.addAll(returnList);
                 TOTAL += findCombination1(runningSize+ nList.size(), map, size, newList, nList);
             }

             return TOTAL;
    }

/*
    public static int getSum(Map<Integer, List<List<Integer>>> map,int mapIndex, int size) {
        if (mapIndex >= size) {
            return 0;
        }
        int total = 0;
            List<List<Integer>> listOfList = map.get(mapIndex);

                for (List<Integer> aList : listOfList) {
                    int isum = 0;
                     for (int ii: aList) {
                         isum += ii;
                     }
//                       System.out.println("loop " + isum + ":"+ aList.size());
                      total += isum * aList.size();
                      total += getSum(map, mapIndex+ aList.size(), size);
                }//for

            return total;
    }
*/

    public static List<List<Integer>> findCombination(ArrayList<Integer> list,int length, int maxLength) {
        List<String> list1 = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        List<List<Integer>> returnList = new ArrayList<List<Integer>>();
        List<Integer> integerList = new ArrayList<Integer>();
        int i_c=0;
        int index =0;

        for (int i=length; i <list.size(); i++) {
            integerList.add(list.get(i));
            sb.append(list.get(i));
            i_c++;
            if (i_c == maxLength) {
                returnList.add(integerList);
                List<Integer> tempList = new ArrayList<Integer>(integerList);
                integerList = tempList;
                list1.add(index, sb.toString());
                index++;
                sb.append("-");
                i_c =0;
                break;
            }
        }

            return returnList;
    }


    public static ArrayList<ArrayList<Integer>> getSubSet2(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>>  allsubSets = new ArrayList<ArrayList<Integer>>();
        int max = 1 << set.size(); // multiply by 2


        for (int i = 0; i < max; i++) {
            boolean error = false;
            ArrayList<Integer> set1 = new ArrayList<Integer>();
            int k =  i;
            int index = 0;
            Stack<Integer> stack = new Stack<Integer>();
            while (k > 0) {
                if ( ( k & 1) > 0) {
                    set1.add(set.get(index));
//                    System.out.println(i + ":" + k + ":" + index ) ;

                    if (!stack.isEmpty() ) {
                        if ((( index - stack.peek()) > 1)) {
//                            System.out.println("ERROR " + i + ":" + index);
                            error = true;
                        }
                    }
                    stack.push(index);

                }
                k >>= 1;
                index++;
            }

            if (!error)
                allsubSets.add(set1);
        }

        return allsubSets;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<Integer>();
//        Scanner scanner = new Scanner(System.in);
//        int count  = scanner.nextInt();
//        int i =0;
//        while (i < count) {
//            list.add(scanner.nextInt());
//            i++;
//        }

//        list.add(100);
//        list.add(200);
////        list.add(300);
//        list.add(400);
//        list.add(500);
//        list.add(600);
//        list.add(700);
//        list.add(800);
//        list.add(900);
//        list.add(1000);
////
      list.add(1);
        list.add(3);
        list.add(6);
//        list.add(4);
//        list.add(2);
//        list.add(9);
//        list.add(10);
//        list.add(1);

////        list.add(7);
//        list.add(8);

        printCombination(list,0, 0, list.size() );
//
//
        /**
         * 5
         4 2 9 10 1
         Sample Output 1

         971
         */
//        ArrayList<ArrayList<Integer>>  allSubSets = getSubSet2(list);
//
//        for (ArrayList<Integer> integerArrayList : allSubSets) {
//            print(integerArrayList);
//        }
    }

    public static void print(ArrayList<Integer> list) {
        for (Integer ii : list) {
            System.out.print(ii + " " );
        }

        System.out.println();
    }
}
