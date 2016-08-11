package com.avisow.exercise;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by rwibawa on 2/15/2016.
 */
public class AtomicIntegerExample {

    private static AtomicInteger at = new AtomicInteger(0);

    public void execute() {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        t1.start();
        t2.start();
    }


    class MyRunnable implements Runnable {

        private int myCounter;
        private int myPrevCounter;
        private int myCounterPlusFive;
        private boolean isNine;

        public void run() {
            myCounter = at.incrementAndGet();
            System.out.println("Thread " + Thread.currentThread().getId() + "  / Counter : " + myCounter);
            myPrevCounter = at.getAndIncrement();
            System.out.println("Thread " + Thread.currentThread().getId() + " / Previous : " + myPrevCounter);
            myCounterPlusFive = at.addAndGet(5);
            System.out.println("Thread " + Thread.currentThread().getId() + " / plus five : " + myCounterPlusFive);
            isNine = at.compareAndSet(9, 3);
            if (isNine) {
                System.out.println("Thread " + Thread.currentThread().getId()
                        + " / Value was equal to 9, so it was updated to " + at.intValue());
            }

        }
    }

}