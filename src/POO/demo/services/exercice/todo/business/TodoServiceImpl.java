package POO.demo.services.exercice.todo.business;

import POO.demo.services.exercice.todo.dataAccess.TodoLoader;
import POO.demo.services.exercice.todo.exceptions.LoadingException;
import POO.demo.services.exercice.todo.exceptions.SaveException;
import POO.demo.services.exercice.todo.models.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoServiceImpl implements TodoService {

    // region SINGLETON

    private static TodoServiceImpl instance;
    public  static TodoServiceImpl getInstance(){
        return instance == null ? instance = new TodoServiceImpl() : instance;
    }
    private TodoServiceImpl() {
    }
    // endregion

    private List<Todo> todoList = new ArrayList<>();
    private final TodoLoader loader = TodoLoader.getInstance();
    private int lastId = 0;


    public void load() throws LoadingException {
            todoList = loader.load();
            calculateLastId();
    }

    public void save() throws SaveException {
            loader.save(todoList);
    }

    public void addTodo(Todo todo){
        todo.setId(++lastId);
        todoList.add(todo);
    }

    public void deleteTodo(int id) throws IllegalArgumentException {
        todoList.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .ifPresentOrElse(
                        todoList::remove,
                        () -> { throw new IllegalArgumentException(); }
                );
    }

    private void calculateLastId(){
        lastId = todoList.stream()
                .mapToInt(Todo::getId)
                .max()
                .orElse(0);
    }

    public List<Todo> getTodoList(){
        return new ArrayList<>(todoList);
    }
    public List<Todo> getSortedTodoList(){
        return todoList.stream()
                .sorted((t1,t2)-> t1.getDifficulty().compareTo(t2.getDifficulty()))
                .collect(Collectors.toList());
    }
}
