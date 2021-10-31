package com.luxcampus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReflectionTest {
    @Test
    public void testCreateInstance() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        Person expectedPerson = new Person();
        Person actualPerson = (Person) Reflection.createInstance(Person.class);
        assertEquals(true, expectedPerson.equals(actualPerson));
    }

    @Test
    public void testCreateInstanceFromNull() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        Assertions.assertThrows(NullPointerException.class, () ->
                Reflection.createInstance(null));
        Assertions.assertThrows(NullPointerException.class, () ->
            Reflection.createInstance(null, 1, "Gdf"));

        try {
            Reflection.createInstance(null);
        } catch (NullPointerException exception) {
            assertEquals("First argument is null. Null is not supported", exception.getMessage());
        }
    }

    @Test
    public void testClearPrivateFieldsData() throws IllegalAccessException {
        Person person = new Person("Tommy", 21);
        Reflection.clearPrivateFieldsData(person);
        assertEquals(0, person.getAge());
        assertEquals(null, person.getName());
    }

    @Test
    public void testClearPrivateFieldsDataWithFromNull() throws IllegalAccessException {
        Assertions.assertThrows(NullPointerException.class, () ->
                Reflection.clearPrivateFieldsData(null));

        try {
            Reflection.clearPrivateFieldsData(null);
        } catch (NullPointerException exception) {
            assertEquals("Null is not supported", exception.getMessage());
        }
    }
}
