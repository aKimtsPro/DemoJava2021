package POO.demo.services.exercice.todo.dataAccess;

import POO.demo.services.exercice.todo.exceptions.FormatException;
import POO.demo.services.exercice.todo.models.Person;

public class PersonFormatter implements ModelFormatter<Person> {
    @Override
    public Person toModel(String line) throws FormatException {
        return new Person("", "");
    }

    @Override
    public String toString(Person model) {
        return "null";
    }
}
