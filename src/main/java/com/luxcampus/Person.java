package com.luxcampus;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void sayHi() {
        System.out.println("Hi, i am " + name);
    }

    private void sayAge() {
        System.out.println("I am " + age + " years old!");
    }
}
