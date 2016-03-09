package com.test;

import com.sun.org.apache.bcel.internal.classfile.ConstantMethodref;

/**
 * Created by chirag on 6/19/15.
 */
public class Producer {

    public static void main(String args[]) {
        for (int i=0 ;i <100; i++) {
        Consumer.log("this is my first message " + i,1);
        }

    Thread thread1 = new Thread() {
        public void run() {
            Consumer.log("message from thrad1",1);
        }
    };

    thread1.start();

        Thread thread2 = new Thread() {
            public void run() {
                Consumer.log("message from thrad2",1);
            }
        };

        thread2.start();
try {
        thread1.join();
        thread2.join();

    Thread.sleep(5000);
} catch (Exception e) {}
    }


}
