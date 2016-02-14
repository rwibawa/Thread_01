package com.avisow.exercise;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by rwibawa on 2/13/2016.
 */
public class ProducerConsumerPattern {
    // Creating shared object
    BlockingQueue<Integer> sharedQ = new LinkedBlockingQueue<Integer>();

    public void execute() {
        Thread producer = new Thread(new Producer2(sharedQ));
        Thread consumer = new Thread(new Consumer2(sharedQ));

        producer.start();
        consumer.start();
    }
}
