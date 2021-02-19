package POO.demo.services.exercice.generics.metier;

import POO.demo.services.exercice.todo.exceptions.LoadingException;
import POO.demo.services.exercice.todo.exceptions.SaveException;
import POO.demo.services.exercice.todo.models.Model;

public interface LoadingService {

    void save() throws SaveException;
    void load() throws LoadingException;
}
