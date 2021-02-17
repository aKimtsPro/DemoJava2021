package POO.demo.services.exercice.todo.business;

import POO.demo.services.exercice.todo.exceptions.LoadingException;
import POO.demo.services.exercice.todo.exceptions.SaveException;
import POO.demo.services.exercice.todo.models.Todo;

import java.util.List;

public interface TodoService {

    void load() throws LoadingException;
    void save() throws SaveException;

    void deleteTodo(int id) throws IllegalArgumentException;
    void addTodo(Todo toAdd);
    List<Todo> getTodoList();
    List<Todo> getSortedTodoList();

}
