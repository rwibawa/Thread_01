package com.avisow.exercise;

/**
 * Created by rwibawa on 2/13/2016.
 */
public final class Singleton1 {
    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }

    private static Singleton1 instance = new Singleton1();

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
