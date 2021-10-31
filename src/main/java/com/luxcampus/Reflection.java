package com.luxcampus;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflection {
    public static Object createInstance(Class clazz, Object... constructorArguments) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Class[] classes = new Class[constructorArguments.length];
        for (int i = 0; i < constructorArguments.length; i++) {
            classes[i] = constructorArguments[i].getClass();
        }

        return clazz.getConstructor(classes).newInstance(constructorArguments);
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

    public static void printParentsAndInterfaces(Class clazz) {
        Class[] interfaces = clazz.getInterfaces();
        Class superClass = clazz.getSuperclass();

        System.out.println(superClass);

        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
    }

    public static void clearPrivateFieldsData(Object value) throws IllegalAccessException {
        for (Field field : value.getClass().getDeclaredFields()) {
            if(Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);

                if(field.getType() == int.class) {
                    field.setInt(value, 0);
                } else if(field.getType() == double.class) {
                    field.setDouble(value, 0.0);
                } else if(field.getType() == boolean.class) {
                    field.setBoolean(value,false);
                } else if(field.getType() == float.class) {
                    field.setFloat(value,0.0f);
                } else if(field.getType() == short.class) {
                    field.setShort(value, (short) 0);
                } else if(field.getType() == byte.class) {
                    field.setByte(value, (byte) 0);
                } else if(field.getType() == long.class) {
                    field.setLong(value, 0L);
                } else if(field.getType() == char.class) {
                    field.setChar(value, '\u0000');
                } else {
                    field.set(value, null);
                }
            }
        }
    }
}
