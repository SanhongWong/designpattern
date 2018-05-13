package com.sanhong.designpattern.singleton;

/**
 * 懒汉 利用类级内部类
 */
public class Singleton3 {
    private static class SingleTonHolder {
        // 静态初始化器，由jvm保证线程安全
        private static Singleton3 instance = new Singleton3();
    }
    private Singleton3() {

    }
    public static Singleton3 getInstance() {
        return SingleTonHolder.instance;
    }
}
