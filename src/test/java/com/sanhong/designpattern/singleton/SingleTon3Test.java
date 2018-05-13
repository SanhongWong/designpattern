package com.sanhong.designpattern.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class SingleTon3Test {
    @Test
    public void testSingleTon() {
        Singleton3 instance1 = Singleton3.getInstance();
        Singleton3 instance2 = Singleton3.getInstance();
        assertTrue(instance1 == instance2);
    }

    /**
     * 测试反射攻击单例
     */
    @Test
    public void testReflectAttack() {
        Singleton3 singleton1 = Singleton3.getInstance();
        Constructor<Singleton3> constructor = null;
        try {
            constructor = Singleton3.class.getDeclaredConstructor();
            constructor.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            fail();
        }
        Singleton3 singleton2 = null;
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