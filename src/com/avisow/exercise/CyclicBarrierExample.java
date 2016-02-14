package com.avisow.exercise;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CyclicBarrierExample {
    // creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call await()
    final CyclicBarrier cb = new CyclicBarrier(3, () -> {
        // This task will be executed once all thread reaches barrier
        System.out.println("All parties are arrived at barrier, lets play");
    });

    public void execute() {
        // starting each of thread
        Thread t1 = new Thread(new Task(cb), "Thread 1");
        Thread t2 = new Thread(new Task(cb), "Thread 2");
        Thread t3 = new Thread(new Task(cb), "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }

    private class Task implements Runnable {

        private CyclicBarrier barrier;

        public Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
            } catch (InterruptedException e) {
                // e.printStackTrace();
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            } catch (BrokenBarrierException e) {
                //e.printStackTrace();
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
