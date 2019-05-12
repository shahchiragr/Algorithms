package org.cshah.algorithms.interviewcake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Code from Elements of programming interview books - page 56 - 57
 */
public class DutchFlagPartition {

    public static enum Color {RED, WHITE, BLUE};

    /**
     * Time complexity O(n) and Space complexity O(1)
     * @param pivotIndex
     * @param list
     */
    public static void dutchFlagPartition(int pivotIndex, List<Color> list) {
        Color pivot = list.get(pivotIndex);

        //first pass - group elements smaller than pivot
        int smaller = 0;
        for (int i =0; i < list.size(); i++ ) {
            if (list.get(i).ordinal() < pivot.ordinal()) {
                Collections.swap(list, smaller++, i);
            }
        } //for

        //second pass : group elements larger than pivot
        int larger = list.size() -1;
        for (int i = list.size()-1; i >=0 && list.get(i).ordinal() >= pivot.ordinal(); i-- ) {
            if (list.get(i).ordinal() > pivot.ordinal()) {
                Collections.swap(list, larger--, i);
            }
        } //for
    }

    /**
     * Same time and space complexity as above
     * @param pivotIndex
     * @param list
     */
    public static void dutchFlagPartition_V2(int pivotIndex, List<Color> list) {
        Color pivot = list.get(pivotIndex);
        /**
         * Keep m the following invariants during partitioning
         *
         */
        int smaller=0, equal=0, larger = list.size();
        while (equal < larger) {
            if (list.get(equal).ordinal() < pivot.ordinal()) {
                Collections.swap(list, smaller++, equal++);
            } else if (list.get(equal).ordinal() == pivot.ordinal()) {
                ++equal;
            } else {
                Collections.swap(list, equal, --larger);
            }
        }
    }
        public static void main(String arg[]) {
        List<Color> colors = new ArrayList<Color>();
        colors.add(Color.WHITE);
        colors.add(Color.RED);
        colors.add(Color.RED);
        colors.add(Color.WHITE);
        colors.add(Color.WHITE);
        colors.add(Color.BLUE);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.BLUE);

        DutchFlagPartition.dutchFlagPartition_V2(4, colors);

        for (Color color : colors) {
            System.out.println(color);
        }
    }
}
