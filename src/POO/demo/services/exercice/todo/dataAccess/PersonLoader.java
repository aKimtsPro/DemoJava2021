package POO.demo.services.exercice.todo.dataAccess;

import POO.demo.services.exercice.todo.models.Person;

public class PersonLoader extends AbstractLoader<Person> {
    public PersonLoader() {
        super(new PersonFormatter(), ".\\data\\filename.file");
    }
}
