package org.cshah.algorithms.multithread;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chirag on 6/29/17.
 */
public class ProducerConsumer {

    class Producer extends Thread {
        private Queue queue;

        public Producer(Queue queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                while (true) {
                    synchronized (queue) {
                        if (queue.isEmpty()) {
                            System.out.println("Inserting...");
                            queue.offer(1);
                            queue.notify();
                            Thread.sleep(500);
                        }
                    }
                }//while
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    } //class

    class Consumer extends Thread {
        private Queue queue;
        public Consumer(Queue queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                while (true) {
                    synchronized (queue) {
                        if (queue.size() > 0) {
                            queue.remove();
                            System.out.println("Got Item...");
                            queue.notify();
                            Thread.sleep(200);
                        }
                    }
                }//while
            }catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void startThread() {
        Queue<Integer> queue = new ArrayBlockingQueue<Integer>(500);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        producer.start();
        consumer.start();
        try {
            producer.join();
            consumer.join();
        } catch (Exception e) {}
    }
    public static void main(String arg[]) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        producerConsumer.startThread();
    }
}
