package POO.demo.services.exercice.generics.metier;

import POO.demo.services.exercice.generics.data_access.ModelLoader;
import POO.demo.services.exercice.todo.exceptions.LoadingException;
import POO.demo.services.exercice.todo.exceptions.SaveException;
import POO.demo.services.exercice.todo.models.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class AbstractCrudService<T extends Model> implements CrudService<T>, LoadingService{

    private List<T> tList = new ArrayList<>();
    private final ModelLoader<T> loader;
    protected int lastId;

    public AbstractCrudService(ModelLoader<T> loader) {
        this.loader = loader;
    }

    // insert
    // getOne

    // Update

    @Override
    public List<T> getAll() {
        return new ArrayList<>(tList);
    }

    @Override
    public void delete(int id) throws NoSuchElementException {
        getList().remove( getOne(id) );
    }

    @Override
    public void save() throws SaveException {
        loader.save(tList);
    }

    @Override
    public void load() throws LoadingException {
        this.tList = loader.load();
        calculateLastId();
    }

    protected List<T> getList() {
        return tList;
    }

    protected abstract void calculateLastId();
}
