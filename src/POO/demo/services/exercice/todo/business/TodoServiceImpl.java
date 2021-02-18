package POO.demo.services.exercice.todo.business;

import POO.demo.services.exercice.todo.dataAccess.TodoLoader;
import POO.demo.services.exercice.todo.exceptions.LoadingException;
import POO.demo.services.exercice.todo.exceptions.SaveException;
import POO.demo.services.exercice.todo.models.Model;
import POO.demo.services.exercice.todo.models.Todo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TodoServiceImpl implements ListService<Todo> {

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

    public void add(Todo todo){
        todo.setId(++lastId);
        todoList.add(todo);
    }

    public void delete(int id) throws IllegalArgumentException {
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

    public List<Model> getList(){
        return new ArrayList<>(todoList);
    }
    public List<Todo> getSortedList(boolean croissant){
        if(croissant)
            return todoList.stream()
                .sorted( (t1,t2)-> t1.getDifficulty().compareTo(t2.getDifficulty()) )
                .collect( Collectors.toList() );
        else
            return todoList.stream()
                    .sorted( Comparator.comparing(Todo::getDifficulty).reversed() )
                    .collect( Collectors.toList() );
    }
}
