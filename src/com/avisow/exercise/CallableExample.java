package com.avisow.exercise;

import java.util.concurrent.*;

/**
 * Created by rwibawa on 8/11/2016.
 */
public class CallableExample {
    public void execute() {
        ExecutorService es = Executors.newSingleThreadExecutor();

        System.out.println("submitted callable task to calculate factorial of 10");
        Future result10 = es.submit(new FactorialCalculator(10));

        System.out.println("submitted callable task to calculate factorial of 15");
        Future result15 = es.submit(new FactorialCalculator(15));

        System.out.println("submitted callable task to calculate factorial of 20");
        Future result20 = es.submit(new FactorialCalculator(20));

        try {
            System.out.println("Calling get method of Future to fetch result of factorial 10");
            long factorialof10 = (long) result10.get();
            System.out.println("factorial of 10 is : " + factorialof10);

            System.out.println("Calling get method of Future to get result of factorial 15");
            long factorialof15 = (long) result15.get();
            System.out.println("factorial of 15 is : " + factorialof15);

            System.out.println("Calling get method of Future to get result of factorial 20");
            long factorialof20 = (long) result20.get();
            System.out.println("factorial of 20 is : " + factorialof20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    class FactorialCalculator implements Callable<Long> {
        private int number;

        public FactorialCalculator(int number) {
            this.number = number;
        }

        @Override
        public Long call() throws Exception {
            return factorial(number);
        }

        private long factorial(int n) throws InterruptedException {
            long result = 1;
            while (n != 0) {
                result = n * result;
                n = n - 1;
                Thread.sleep(100);
            }

            return result;
        }

    }
}
