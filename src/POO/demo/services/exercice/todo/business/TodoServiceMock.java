package POO.demo.services.exercice.todo.business;

import POO.demo.services.exercice.todo.exceptions.LoadingException;
import POO.demo.services.exercice.todo.exceptions.SaveException;
import POO.demo.services.exercice.todo.models.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoServiceMock implements TodoService {

    // region SINGLETON

    private static TodoServiceMock instance;
    public  static TodoServiceMock getInstance(){
        return instance == null ? instance = new TodoServiceMock() : instance;
    }
    private TodoServiceMock() {
    }
    // endregion

    @Override
    public void load() throws LoadingException {

    }

    @Override
    public void save() throws SaveException {

    }

    @Override
    public void deleteTodo(int id) throws IllegalArgumentException {
        if(id == 4)
            throw new IllegalArgumentException();
    }

    @Override
    public void addTodo(Todo toAdd) {

    }

    @Override
    public List<Todo> getTodoList() {
        return new ArrayList<>();
    }

    @Override
    public List<Todo> getSortedTodoList() {
        return new ArrayList<>();
    }
}
