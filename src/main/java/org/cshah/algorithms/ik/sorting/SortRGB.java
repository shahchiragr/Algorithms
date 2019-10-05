package org.cshah.algorithms.ik.sorting;

public class SortRGB {

    public String getSortedString(String string) {
     char[] chars = string.toCharArray();
     int counter =0;
     int rcounter = 0;
     int bcounter = chars.length-1;

     while (counter <= bcounter) {
         if ( chars[counter] == '0') {
             swap(chars, counter, rcounter);
             counter++;
             rcounter++;
         } else if ( chars[counter] == '1') {
             counter++;
         } else if (chars[counter] == '2') {
            swap(chars, counter, bcounter);
            bcounter--;
         }
     }

     return new String(chars);
    }

    public static void swap(char[] chars, int index1, int index2) {
        char c = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = c;
    }

    public static void dutch_flag_sort(char[] balls) {
        int counter = 0;
        int rCounter = 0;
        int bCounter = balls.length-1;

        while (counter <= bCounter) {
            if (balls[counter] == 'R') {
                swap(balls, counter, rCounter);
                counter++;
                rCounter++;
            } else if (balls[counter] == 'G') {
                counter++;
            } else if (balls[counter] == 'B') {
                swap(balls, counter, bCounter);
                bCounter--;
            }
        }
    }

    public static void main(String[] args) {
//        String str = "0120120110221211";
//        SortRGB sortRGB = new SortRGB();
//        System.out.println(sortRGB.getSortedString(str));

        String str1 = "RGBGRBGRRGBGR";
        char c[] = str1.toCharArray();
        SortRGB.dutch_flag_sort(c);
        System.out.println(new String(c));
    }
}
