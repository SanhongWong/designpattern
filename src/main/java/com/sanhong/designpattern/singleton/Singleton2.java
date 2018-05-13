package com.sanhong.designpattern.singleton;

/*
 * 懒汉 double check
 */
public class Singleton2 {
    private static Singleton2 instance;
    private Singleton2() {

    }
    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized(Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
