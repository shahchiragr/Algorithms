package com.example.algorithms;


public class SwapCards {

    public static void shuffleArray() {
        int cards[] = new int[] {1,2,3,4,5,6,7,8,9,10};
        printArray(cards);
        int temp,index;
        for (int i=0;i<cards.length;i++) {
            index = (int) (Math.random() * (cards.length-i)) +i;
            System.out.println( i + ":" + index);
            temp = cards[i];
            cards[i] = cards[index];
            cards[index] = temp;
        }
        printArray(cards);

    }

    public static void printArray(int[] cards) {
        for (int i=0;i<cards.length;i++) {
            System.out.print(cards[i] + " ");
        }
        System.out.println();
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        shuffleArray();

    }

}