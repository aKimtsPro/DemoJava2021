package POO.demo.services.exercice.todo.dataAccess;

import POO.demo.services.exercice.todo.exceptions.FormatException;
import POO.demo.services.exercice.todo.models.Todo;

public class TodoFormatter implements ModelFormatter<Todo> {

    private String regexSeparator;
    private String separator;

    public TodoFormatter(String regexSeparator, String separator) {
        this.regexSeparator = regexSeparator;
        this.separator = separator;
    }

    @Override
    public Todo toModel(String line) throws FormatException {
        String[] data = null;
        data = line.split(regexSeparator);
        try{
            return new Todo(
                    Integer.parseInt(data[0]),
                    data[1],
                    Todo.Difficulty.valueOf(data[2])
            );
        }
        catch (Exception e){
            throw new FormatException();
        }
    }

    @Override
    public String toString(Todo model) {
        return model.getId()+separator+ model.getName()+separator+ model.getDifficulty().name();
    }
}
