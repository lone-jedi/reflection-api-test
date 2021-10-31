package com.luxcampus;

public class Program {
    public static void main(String[] args) {
        Person person = new Person("Jack", 13);
        try {
            System.out.println("Call methods without arguments:");
            Reflection.callNoArgumentsMethods(person);
            System.out.println("Print patent class and interfaces:");
            Reflection.printParentsAndInterfaces(Person.class);
            System.out.println("Print private methods:");
            Reflection.printNonPublicMethods(Person.class);
            System.out.println("Create instance of Person and call sayHi()");
            ((Person)(Reflection.createInstance(Person.class, "Tom", 18))).sayHi();
            System.out.println("Print all final methods");
            Reflection.printFinalMethods(person);
            System.out.println("Clear private methods values");
            Reflection.clearPrivateFieldsData(person);
            System.out.println(person);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
