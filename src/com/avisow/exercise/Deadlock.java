package com.avisow.exercise;

/**
 * Created by rwibawa on 8/11/2016.
 */
public class Deadlock {
    public void execute() {
        thread1.start();
        thread2.start();
    }

    final String resourceA = "Java";
    final String resourceB = "Linux";

    Thread thread1 = new Thread() {
        public void run() {
            while (true) {
                synchronized (resourceA) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (resourceB) {
                        System.out.println(resourceA + " " + resourceB);
                    }
                }
            }
        }
    };

    Thread thread2 = new Thread(() -> {
        while (true) {
            synchronized (resourceB) {
                synchronized (resourceA) {
                    System.out.println(resourceB + " " + resourceA);
                }
            }
        }
    });
}
