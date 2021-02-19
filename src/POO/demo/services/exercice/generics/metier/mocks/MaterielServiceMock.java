package POO.demo.services.exercice.generics.metier.mocks;

import POO.demo.services.exercice.generics.metier.CrudService;
import POO.demo.services.exercice.generics.metier.LoadingService;
import POO.demo.services.exercice.generics.model.Materiel;
import POO.demo.services.exercice.todo.exceptions.LoadingException;
import POO.demo.services.exercice.todo.exceptions.SaveException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MaterielServiceMock implements CrudService<Materiel>, LoadingService {
    @Override
    public void add(Materiel toAdd) {

    }

    @Override
    public Materiel getOne(int id) throws NoSuchElementException {
        return new Materiel(0,"marque", "modele", 0);
    }

    @Override
    public List<Materiel> getAll() {
        return new ArrayList<>();
    }

    @Override
    public void update(Materiel toUpdate) {

    }

    @Override
    public void delete(int id) throws NoSuchElementException {

    }


    @Override
    public void save() throws SaveException {

    }

    @Override
    public void load() throws LoadingException {

    }
}
