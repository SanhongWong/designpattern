package com.sanhong.designpattern.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class Singleton2Test {
    @Test
    public void testSingleTon() {
        Singleton2 instance1 = Singleton2.getInstance();
        Singleton2 instance2 = Singleton2.getInstance();
        assertTrue(instance1 == instance2);
    }

    /**
     * 测试反射攻击单例
     */
    @Test
    public void testReflectAttack() {
        Singleton2 singleton1 = Singleton2.getInstance();
        Constructor<Singleton2> constructor = null;
        try {
            constructor = Singleton2.class.getDeclaredConstructor();
            constructor.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            fail();
        }
        Singleton2 singleton2 = null;
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