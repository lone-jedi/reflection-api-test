package com.luxcampus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflection {
    public static Object createInstance(Class clazz) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Object result = clazz.getConstructor().newInstance();
        return result;
    }

    public static void callNoArgumentsMethods(Object value)
            throws InvocationTargetException, IllegalAccessException {
        for (Method method : value.getClass().getDeclaredMethods()) {
            if(method.getParameterCount() == 0) {
                method.setAccessible(true);
                method.invoke(value);
            }
        }
    }

    public static void printFinalMethods(Object value) {
        for (Method method : value.getClass().getDeclaredMethods()) {
            if(Modifier.isFinal(method.getModifiers())) {
                System.out.println(method);
            }
        }
    }

    public static void printPrivateMethods(Class clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if(!Modifier.isPublic(method.getModifiers())) {
                System.out.println(method);
            }
        }
    }

}
