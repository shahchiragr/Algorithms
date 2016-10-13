package org.cshah.algorithms.array;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by chirag on 9/26/16.
 */
public class FindMedianFromStream {

    PriorityQueue<Integer> maxHeap;//lower half
    PriorityQueue<Integer> minHeap;//higher half

    public FindMedianFromStream(){
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (double)(maxHeap.peek()+(minHeap.peek()))/2;
        }else{
            return maxHeap.peek();
        }
    }

    public static void main(String args[]) {
        FindMedianFromStream findMedianFromStream = new FindMedianFromStream();
        for (int i =1; i<=5; i++) {
            findMedianFromStream.addNum(i);
            System.out.println("Median " + findMedianFromStream.findMedian());
        }
    }
}
