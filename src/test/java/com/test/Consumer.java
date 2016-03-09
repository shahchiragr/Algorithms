package com.test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by chirag on 6/19/15.
 */
public class Consumer {

    private static final ArrayBlockingQueue<LogClass> messageQueue = new ArrayBlockingQueue<LogClass>(1000);

    static  {
        Thread t = new Thread("logger-thread") {
            public void run() {
                 while (true) {
                     try {
                        LogClass logmessage = messageQueue.take();
                        System.out.println("Message " + logmessage.getMessage());
                     } catch (InterruptedException ie) {
                         ie.printStackTrace();
                     }
                 }
            }
        };
        t.setDaemon(true);
        t.start();
    }

    public static final void log(String message, int level) {

        messageQueue.offer(new LogClass(message, level));
    }


}
