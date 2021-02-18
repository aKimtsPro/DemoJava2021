package POO.demo.services.exercice.todo.dataAccess;

import POO.demo.services.exercice.todo.exceptions.FormatException;
import POO.demo.services.exercice.todo.models.Model;
import POO.demo.services.exercice.todo.models.Todo;

public interface ModelFormatter<T extends Model> {

    T toModel(String line) throws FormatException;
    String toString(T model);

}
