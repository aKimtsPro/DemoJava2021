package POO.demo.services.exercice.todo.dataAccess;

import POO.demo.services.exercice.todo.exceptions.LoadingException;
import POO.demo.services.exercice.todo.exceptions.SaveException;
import POO.demo.services.exercice.todo.models.Model;
import POO.demo.services.exercice.todo.models.Todo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLoader<T extends Model> {

    private String filename;
    private ModelFormatter<T> formatter;
    protected final static String regexDelimiter = "\\|";
    protected final static String delimiter = "|";

    public void save(List<T> toSave) throws SaveException{
        if(toSave == null){
            throw new IllegalArgumentException("toSave cant be null.");
        }

        try(BufferedWriter writer = new BufferedWriter( new FileWriter(filename))){
            for (T model : toSave) {
                writer.write( formatter.toString(model) );
                writer.newLine();
            }
        }
        catch (IOException e){
            throw new SaveException();
        }

    }

    public List<T> load() throws LoadingException{
        String line = "";
        List<T> todoList = new ArrayList<>();
        String[] data = null;

        try( BufferedReader reader = new BufferedReader(new FileReader(filename)) ){
            System.out.println(filename);
            while((line = reader.readLine()) != null){
                todoList.add( formatter.toModel(line) );
            }

        }
        catch (Exception e){
            System.out.println(e.getClass());
            throw new LoadingException("- loading problem -");
        }

        return todoList;
    };

    public AbstractLoader(ModelFormatter<T> formatter, String filename) {
        this.formatter = formatter;
        this.filename = filename;
    }

}
