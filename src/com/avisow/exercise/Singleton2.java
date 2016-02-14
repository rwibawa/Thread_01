package com.avisow.exercise;

/**
 * Created by rwibawa on 2/13/2016.
 */
public final class Singleton2 {
    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }

        return instance;
    }

    private static volatile Singleton2 instance;

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
