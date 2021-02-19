package POO.design_pattern.string;

import POO.demo.services.exercice.todo.models.Person;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public class DemoImmutable {

    public static void main(String[] args) {
        ClassImmutable c = new ClassImmutable("1", new Person("luc", "luc"));
    }
}
