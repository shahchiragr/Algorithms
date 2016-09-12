package com.example.algorithms.multithread;

import java.util.concurrent.Semaphore;

/**
 * Created by cshah on 5/11/14.
 */
public class PingPong extends Thread {

    private static Semaphore pingSemaphore = new Semaphore(1);
    private static Semaphore pongSemaphore = new Semaphore(1);

    private int id;
    public PingPong(int id) {
        this.id = id;
        if (id == 1) {
            try {
                pongSemaphore.acquire();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        if (id == 2) {
//            try {
//                pongSemaphore.acquire();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

    }

    public void run() {
        while (true) {
        try {
            if (id == 1) {
                pingSemaphore.acquire();
                System.out.println("PING");
                pongSemaphore.release();
            }

            if (id == 2) {
                pongSemaphore.acquire();
                System.out.println("PONG");
                pingSemaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (Exception exp) {}
        }
    }

    public static void main(String args[]) {
        PingPong p1 = new PingPong(1);
        PingPong p2 = new PingPong(2);
        p1.start();
        p2.start();
        try {
            p1.join();
            p2.join();
        } catch (Exception exp) {}
    }
}
