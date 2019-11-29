package org.cshah.algorithms.ik.dp;

import java.util.*;

public class KnightTour {

    static long numPhoneNumbers(int startdigit, int phonenumberlength) {
        Map<Integer, List<Integer>>  map = new HashMap<Integer, List<Integer>>();
        map.put(0, new ArrayList<>());
        map.put(1, new ArrayList<>());
        map.put(2, new ArrayList<>());
        map.put(3, new ArrayList<>());
        map.put(4, new ArrayList<>());
        map.put(5, new ArrayList<>());
        map.put(6, new ArrayList<>());
        map.put(7, new ArrayList<>());
        map.put(8, new ArrayList<>());
        map.put(9, new ArrayList<>());

        addNumber(map, 0, 4,6);
        addNumber(map, 1, 6,8);
        addNumber(map, 2, 7,9);
        addNumber(map, 3, 4,8);
        addNumber(map, 4, 3,9,0);
        addNumber(map, 6, 1,7,0);
        addNumber(map, 7, 2,6);
        addNumber(map, 8, 1,3);
        addNumber(map, 9, 2,4);



        long numTill[][] = new long[phonenumberlength][10];
        // First digit is already given. So we can only form one number of length 1.
        numTill[0][startdigit] = 1;

        for(int i = 1; i < phonenumberlength; i++){
            for(int num = 0; num < 10; num++){
                for(int to:map.get(num)){
                    // We can come to num from all its neighbours.
                    // So we will add all possible numbers of length i-1 that are neighbours of num.
                    numTill[i][num] += numTill[i-1][to];
                }
            }
        }

        /*
        for (int i=0; i < phonenumberlength; i++) {
            for (int j=0; j < 10; j++) {
                System.out.print(numTill[i][j] + " | ");
            }
            System.out.println();
        }
         */

        long ans = 0;
        // Sum all possible ending of length phonenumberlength
        for(int num = 0; num < 10; num++){
            ans += numTill[phonenumberlength-1][num];
        }
        return ans;

        /*
        Set<String> resultSet = new HashSet<String> ();
        long total = numPhoneNumbersRec(startdigit, phonenumberlength, map, "", resultSet);


        for (String str : resultSet) {
            System.out.println(str);
        }


        return total;
        */
    }

    static long numPhoneNumbersRec(int startdigit, int phonenumberlength, Map<Integer, List<Integer>>  map, String currentPhoneDigits, Set<String> resultSet ) {

        currentPhoneDigits = currentPhoneDigits + startdigit;

        if (currentPhoneDigits.length() == phonenumberlength) {
            resultSet.add(currentPhoneDigits);
            return 1;
        }

        List<Integer> digitList = map.get(startdigit);

        long total = 0;
        for (Integer digit : digitList) {
           total +=  numPhoneNumbersRec(digit, phonenumberlength, map, currentPhoneDigits, resultSet);
        }

        return  total;
    }


    static void addNumber(Map<Integer, List<Integer>>  map, Integer num, Integer... values) {
        for (Integer value : values) {
            map.get(num).add(value);
        }
    }
    public static void main(String[] args) {
        long count = KnightTour.numPhoneNumbers(1,3);
        System.out.println("Total count... " + count);

    }
}
