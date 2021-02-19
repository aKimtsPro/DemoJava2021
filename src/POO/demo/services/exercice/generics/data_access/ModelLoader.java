package POO.demo.services.exercice.generics.data_access;

import POO.demo.services.exercice.todo.exceptions.LoadingException;
import POO.demo.services.exercice.todo.exceptions.SaveException;
import POO.demo.services.exercice.todo.models.Model;

import java.util.List;

public interface ModelLoader<T extends Model> {

    List<T> load() throws LoadingException;
    void save(List<T> toSave) throws SaveException;
}
