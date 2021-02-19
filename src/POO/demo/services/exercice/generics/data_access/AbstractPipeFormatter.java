package POO.demo.services.exercice.generics.data_access;

import POO.demo.services.exercice.todo.models.Model;

public abstract class AbstractPipeFormatter<T extends Model> implements ModelFormatter<T>{

    protected final static String regexDelimiter = "\\|";
    protected final static String delimiter = "|";

}
