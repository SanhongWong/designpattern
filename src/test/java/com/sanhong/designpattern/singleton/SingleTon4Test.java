package com.sanhong.designpattern.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class SingleTon4Test {
    @Test
    public void testSingleTon() {
        Singleton4 singleton1 = Singleton4.INSTANCE;
        Constructor<Singleton4> constructor = null;
        try {
            constructor = Singleton4.class.getDeclaredConstructor();
            constructor.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            fail();
        }
        Singleton4 singleton2 = null;
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
        assert (singleton1 == singleton2);
    }
}