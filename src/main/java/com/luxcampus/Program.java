package com.luxcampus;

public class Program {
    public static void main(String[] args) {
        Person person = new Person("Jack", 13);
        try {
            Reflection.callNoArgumentsMethods(person);
            Reflection.printParentsAndInterfaces(Person.class);
            Reflection.printPrivateMethods(Person.class);
            ((Person)(Reflection.createInstance(Person.class))).sayHi();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
