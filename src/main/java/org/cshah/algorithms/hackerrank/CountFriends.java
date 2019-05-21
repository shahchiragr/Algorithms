package org.cshah.algorithms.hackerrank;

import java.util.Scanner;

/**
 * Created by chirag on 9/22/16.
 */
public class CountFriends {

    static int counter= 0;
    public void combine(int length) {
        doCombination(length, 0, 0);
    }

    private void doCombination(int length, int level, int start) {
        for (int i=start; i < length; i++) {
            counter++;

            if (i < length-1) {
                doCombination(length, level + 1, i + 1);
            }

        }
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int frames = scanner.nextInt();

        CountFriends stringCombination = new CountFriends();
        stringCombination.combine(n);
        System.out.println(Math.abs(frames - counter));
    }
}
