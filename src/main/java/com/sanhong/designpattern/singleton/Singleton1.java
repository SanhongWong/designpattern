package com.sanhong.designpattern.singleton;

/*
 * 饿汉
 */
public class Singleton1 {

    private static final Singleton1 instance = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return instance;
    }
}
