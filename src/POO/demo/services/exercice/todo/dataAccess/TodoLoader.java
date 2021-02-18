package POO.demo.services.exercice.todo.dataAccess;

import POO.demo.services.exercice.todo.exceptions.LoadingException;
import POO.demo.services.exercice.todo.exceptions.SaveException;
import POO.demo.services.exercice.todo.models.Todo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TodoLoader extends AbstractLoader<Todo> {

    // region SINGLETON

    private static TodoLoader instance;
    public static TodoLoader getInstance(){
        return instance == null ? instance = new TodoLoader() : instance;
    }
    private TodoLoader() {
        super(new TodoFormatter(regexDelimiter, delimiter), ".\\data\\todo.file");
    }

    // endregion
//
//    private final static String filename = ".\\data\\todo.file";
//    private final static String regexDelimiter = "\\|";
//    private final static String delimiter = "|";
//
//    public List<Todo> load() throws LoadingException {
//
//        String line = "";
//        List<Todo> todoList = new ArrayList<>();
//        String[] data = null;
//
//        try( BufferedReader reader = new BufferedReader(new FileReader(filename)) ){
//
//            while((line = reader.readLine()) != null){
//                data = line.split(regexDelimiter);
//                todoList.add(
//                        new Todo(
//                                Integer.parseInt(data[0]),
//                                data[1],
//                                Todo.Difficulty.valueOf(data[2])
//                        )
//                );
//            }
//
//        }
//        catch (IOException e){
//            throw new LoadingException("file doesn't exist");
//        }
//        catch (NumberFormatException e){
//            throw new LoadingException("file corrupted(line : "+(todoList.size()+1)+" | property concerned : id)");
//        }
//        catch (IllegalArgumentException e){
//            throw new LoadingException("file corrupted(line : "+(todoList.size()+1)+" | property concerned : difficulty)");
//        }
//
//        return todoList;
//    }
//
//    public void save(List<Todo> toSave) throws SaveException {
//
//        if(toSave == null){
//            throw new IllegalArgumentException("toSave cant be null.");
//        }
//
//        try(BufferedWriter writer = new BufferedWriter( new FileWriter(filename))){
//            for (Todo model : toSave) { // Todo.Difficulty.EASY -> name() -> "EASY"
//                writer.write( model.getId()+delimiter+ model.getName()+delimiter+ model.getDifficulty().name());
//                writer.newLine();
//            }
//        }
//        catch (IOException e){
//            throw new SaveException();
//        }
//
//    }
}
