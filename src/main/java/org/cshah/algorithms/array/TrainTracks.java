package org.cshah.algorithms.array;

import java.util.Scanner;

/**
 * Created by chirag on 9/25/16.
 */
public class TrainTracks {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        int row  = scanner.nextInt();
        int column = scanner.nextInt();
        int tracks = scanner.nextInt();

        int array[][] = new int[row][column];

        try {
            int line = 1;
            while (line <= tracks) {
                int r = scanner.nextInt();
                int c1 = scanner.nextInt();
                int c2 = scanner.nextInt();

                for (int i = c1; i <= c2 && (i - 1) <= column && (r - 1 >= 0); i++) {
                    array[r - 1][i - 1] = line;
                }
                line++;
            }
            scanner.close();
        } catch (Exception e) {}
        int count=0;
        for (int i=0; i < row; i++) {
            for (int j=0; j < column; j++) {
                System.out.print(array[i][j] + "|");
                if (array[i][j] ==0) {
                    count++;
                }
            }
            System.out.println();

        }

        System.out.println(count);

    }

}
