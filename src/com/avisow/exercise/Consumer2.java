package com.avisow.exercise;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by rwibawa on 2/13/2016.
 */
public class Consumer2 implements Runnable {
    private final BlockingQueue<Integer> sharedQ;

    public Consumer2(BlockingQueue<Integer> sharedQ) {
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        while (true) {
            int number = 0;

            try {
                number = sharedQ.take();
                System.out.println("Consumed: " + number);
            } catch (InterruptedException e) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, e);
            }

            if (number == 9) {
                break;
            }
        }
    }
}
