package com.example.algorithms.array;

import java.util.Scanner;

/**
 * Created by chirag on 9/24/16.
 */
public class ReadValidateBatch {

    public static void checkEvent( String[] arr) {

        if (arr.length == 0) {
            return;
        }

        String sLine = arr[0];

        int lines = 0;

        try {
            lines = Integer.parseInt(sLine);
        } catch (NumberFormatException nfe) {
            System.out.println("FAILURE");
        }

        for (int i=1; i < arr.length;i++) {
            if (i > lines) {
                System.out.println("FAILURE => WRONG INPUT (LINE " + (i+1) +")") ;
            } else {
                sLine = arr[i];
                checkEventInLine(sLine);
            }
        }
    }

    public static void checkEventInLine(String line) {
        if (line == null || line.isEmpty()) {
            System.out.println("FAILURE");
        }

        String elements[] = line.split(" ");

        int expectedElement = elements.length;
        int maxElement = 0;
        boolean error = false;

        for (int i=0; i < elements.length;i++) {
            String elem = elements[i];
            try {
                int i1 = Integer.parseInt(elem);
                if (i1 > maxElement) {
                    maxElement = i1;
                }

            } catch (NumberFormatException nfe) {
                System.out.println("FAILURE => WRONG INPUT (LINE " + (i + 1) + ")");
                error = true;
            }
        }

        if (error) return;
        if (maxElement < expectedElement) {
            System.out.println("FAILURE => RECEIVED: " + expectedElement+ ", EXPECTED: " + maxElement);

        }

        if (maxElement > expectedElement) {
                System.out.println("FAILURE => RECEIVED: " + expectedElement+ ", EXPECTED: " + maxElement);

            }

            if (maxElement == expectedElement) {
                System.out.println("SUCCESS => RECEIVED: " + expectedElement);
            }



    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");

        int V = scan.nextInt();
        int size = scan.nextInt();
        scan.nextLine();
        String line =scan.nextLine();
        System.out.println("LINE " + line);
        scan.close();
        String sArr[] = line.split(" ");
        int[] intArray = new int[size];
        for (int i=0; i < size; i++) {
            intArray[i] = Integer.parseInt(sArr[i]);
        }

        // Write your code here.



//        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
//        List<String> list = new ArrayList<String>();
//
//        while (scanner.hasNext()) {
//            String line1 = scanner.nextLine();
//            list.add(line1);
//        }
//
//        String input[] = new String[list.size()];
//        list.toArray(input);
//
        String arr[] = new String[] {"4", "1 2 3", "2 1  5 3", "6 3 2","   "};
        ReadValidateBatch.checkEvent( arr);
        System.out.println("================");
         arr = new String[] {"3", "3 1 2", "2 1 3 5", "6 3 2"};
        ReadValidateBatch.checkEvent( arr);
        System.out.println("================");

        String arr1[] = new String[] { "2", "1 p 3", "4 2", "1 2", "2 1"};
        ReadValidateBatch.checkEvent( arr1);

    }
}
