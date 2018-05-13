package com.sanhong.designpattern.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * 饿汉单例测试
 */
public class Singleton1Test {
    @Test
    public void testSingleton() {
        Singleton1 instance1 = Singleton1.getInstance();
        Singleton1 instance2 = Singleton1.getInstance();
        assertTrue(instance1 == instance2);
    }

    /**
     * 测试反射攻击单例
     */
    @Test
    public void testReflectAttack() {
        Singleton1 singleton1 = Singleton1.getInstance();
        Constructor<Singleton1> constructor = null;
        try {
            constructor = Singleton1.class.getDeclaredConstructor();
            constructor.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            fail();
        }
        Singleton1 singleton2 = null;
        try {
            singleton2 = constructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            fail();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            fail();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            fail();
        }
        assertTrue(singleton2 == singleton1);
    }
}