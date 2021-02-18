package POO.demo.services.exercice.todo.business;

import POO.demo.services.exercice.todo.exceptions.LoadingException;
import POO.demo.services.exercice.todo.exceptions.SaveException;
import POO.demo.services.exercice.todo.models.Model;
import POO.demo.services.exercice.todo.models.Todo;

import java.util.List;

public interface ListService<T extends Model> { // Model ou un enfant de Model

    void load() throws LoadingException;
    void save() throws SaveException;

    void delete(int id) throws IllegalArgumentException;
    void add(T toAdd);
    List<? super T> getList(); // T ou un parent de T
    List<? extends T> getSortedList(boolean croissant);// T ou un enfant de T

}
