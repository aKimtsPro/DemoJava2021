package POO.demo.services.exercice.generics.metier;

import POO.demo.services.exercice.todo.models.Model;

import java.util.List;
import java.util.NoSuchElementException;

public interface CrudService<T extends Model> {

    void add(T toAdd);

    T getOne(int id) throws NoSuchElementException;
    List<T> getAll();

    void update(T toUpdate) throws NoSuchElementException;

    void delete(int id) throws NoSuchElementException;
}
