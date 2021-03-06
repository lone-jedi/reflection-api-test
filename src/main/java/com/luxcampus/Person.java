package com.luxcampus;

public class Person implements Walkable {
    private String name;
    private int age;

    public Person() {
        name = "Bob";
        age = 43;
    }

    public Person(String name, Integer age) {
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

    public void walk() {
        System.out.println("* person " +  name + " is walking *");
    }

    private void sayAge() {
        System.out.println("I am " + age + " years old!");
    }

    private final void sayHiTo(String name) {
        System.out.println("Hi, " + name + "!");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object value) {
        if(this == value) {
            return true;
        }

        if(value == null) {
            return false;
        }

        if(getClass() != value.getClass()) {
            return false;
        }

        if(!(value instanceof Person)) {
            return false;
        }

        Person person = (Person) value;

        return name.equals(person.getName()) && age == person.getAge();
    }

}


