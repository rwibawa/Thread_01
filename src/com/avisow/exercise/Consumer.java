package com.avisow.exercise;

import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by rwibawa on 2/13/2016.
 */
public class Consumer extends Thread {
    private static final Logger logger = Logger.getLogger(Producer.class.getName());
    private final Queue<Integer> sharedQ;

    public Consumer(Queue<Integer> sharedQueue) {
        super("Consumer");
        this.sharedQ = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQ) {
                // wait condition - wait until the queue is not empty
                while (sharedQ.size() == 0) {
                    try {
                        logger.log(Level.INFO, "Queue is empty, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException e) {
                        logger.log(Level.SEVERE, null, e);
                    }
                }

                int number = sharedQ.poll();
                logger.log(Level.INFO, "consuming : " + number);
                sharedQ.notify();

                if (number == 3) {
                    break;
                }
            }
        }
    }
}
