package com.example.algorithms.multithread;

/**
 * Created by cshah on 5/11/14.
 */
public class PingPong extends Thread {

    static int counter = 0;
    private int id;
    public PingPong(int id) {
        this.id = id;
    }

    public void run() {
        while (true) {
        if (id % 2  ==0) {
            System.out.println("PING");
        } else {
            System.out.println("PONG");
        }
        try {
            Thread.sleep(2000);
        } catch (Exception exp) {}
        }
    }

    public static void main(String args[]) {
        PingPong p1 = new PingPong(0);
        PingPong p2 = new PingPong(1);
        p1.start();
        p2.start();
        try {
        p1.join();
        p2.join();
        } catch (Exception exp) {}
    }
}
