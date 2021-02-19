package POO.design_pattern.string;

import POO.demo.services.exercice.generics.model.Instrument;
import POO.demo.services.exercice.todo.models.Person;

// 1. Pas d'héritage
// 2. Pas de modif des valeurs des champs possibles
// 3. Champs immutables
public final class ClassImmutable {

    private final String propriete1;
    private final Person person; // ceci empêche la classe d'être immutable (clause 3)

    public ClassImmutable(String propriete1, Person person) {
        this.propriete1 = propriete1;
        this.person = person;
    }

    public String getPropriete1() {
        return propriete1;
    }

    public Person getPerson() {
        return person;
    }
}
