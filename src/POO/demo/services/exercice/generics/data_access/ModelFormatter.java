package POO.demo.services.exercice.generics.data_access;

import POO.demo.services.exercice.todo.exceptions.FormatException;
import POO.demo.services.exercice.todo.models.Model;

public interface ModelFormatter<T extends Model> {

    T toModel(String line) throws FormatException;
    String toLine(T model);

}
