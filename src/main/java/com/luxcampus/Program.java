package com.luxcampus;

public class Program {
    public static void main(String[] args) {
        Person person = new Person("Jack", 13);
        try {
            Reflection.callNoArgumentsMethods(person);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
