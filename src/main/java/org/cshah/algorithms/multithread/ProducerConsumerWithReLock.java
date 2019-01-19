package org.cshah.algorithms.multithread;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chirag on 6/29/17.
 */
public class ProducerConsumerWithReLock {
    ReentrantLock lock = new ReentrantLock();
    Condition produce = lock.newCondition();
    Condition consume = lock.newCondition();

    class Producer extends Thread {
        private Queue queue;

        public Producer(Queue queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                lock.lock();
                while (!queue.isEmpty()) {
                          //  produce.await();
                            System.out.println("Inserting...");
                            queue.offer(1);
                            Thread.sleep(500);
                }//while
            }catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
//                consume.signal();
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
                lock.lock();

                while (queue.isEmpty()) {
                       // consume.await();
                        if (queue.size() > 0) {
                            queue.remove();
                            System.out.println("Got Item...");
                            Thread.sleep(200);
                        }
                }//while
            }catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                //produce.signal();
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
        ProducerConsumerWithReLock producerConsumer = new ProducerConsumerWithReLock();
        producerConsumer.startThread();
    }
}
