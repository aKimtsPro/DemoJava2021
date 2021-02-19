package POO.demo.services.exercice.generics.data_access;

import POO.demo.services.exercice.todo.exceptions.LoadingException;
import POO.demo.services.exercice.todo.exceptions.SaveException;
import POO.demo.services.exercice.todo.models.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractModelLoader<T extends Model> implements ModelLoader<T> {

    private final String filename;
    private final ModelFormatter<T> formatter;

    public AbstractModelLoader(String filename, ModelFormatter<T> formatter) {
        this.filename = filename;
        this.formatter = formatter;
    }

    @Override
    public List<T> load() throws LoadingException {
        String line;
        List<T> list = new ArrayList<>();

        try( BufferedReader reader = new BufferedReader(new FileReader(filename)) ){
            System.out.println(filename);
            while((line = reader.readLine()) != null){
                list.add( formatter.toModel(line) );
            }
        }
        catch (Exception e){
            System.out.println(e.getClass());
            throw new LoadingException("- loading problem -");
        }

        return list;
    }

    @Override
    public void save(List<T> toSave) throws SaveException {
        if(toSave == null){
            throw new IllegalArgumentException("toSave cant be null.");
        }

        try(BufferedWriter writer = new BufferedWriter( new FileWriter(filename))){
            for (T model : toSave) {
                writer.write( formatter.toLine(model) );
                writer.newLine();
            }
        }
        catch (IOException e){
            throw new SaveException();
        }
    }
}
