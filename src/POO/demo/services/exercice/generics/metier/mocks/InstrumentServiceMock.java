package POO.demo.services.exercice.generics.metier.mocks;

import POO.demo.services.exercice.generics.metier.CrudService;
import POO.demo.services.exercice.generics.metier.LoadingService;
import POO.demo.services.exercice.generics.model.Instrument;
import POO.demo.services.exercice.todo.exceptions.LoadingException;
import POO.demo.services.exercice.todo.exceptions.SaveException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class InstrumentServiceMock implements CrudService<Instrument>, LoadingService {
    @Override
    public void add(Instrument toAdd) {

    }

    @Override
    public Instrument getOne(int id) throws NoSuchElementException {
        return new Instrument(0, "marque", "modele", 0, Instrument.Type.CORDE);
    }

    @Override
    public List<Instrument> getAll() {
        return Arrays.asList(
                new Instrument(0, "marque", "modele", 0, Instrument.Type.CORDE),
                new Instrument(1, "marque", "modele", 0, Instrument.Type.PERCUSSION),
                new Instrument(2, "marque", "modele", 0, Instrument.Type.CORDE),
                new Instrument(3, "marque", "modele", 0, Instrument.Type.VENT),
                new Instrument(4, "marque", "modele", 0, Instrument.Type.VENT)
        );
    }

    @Override
    public void update(Instrument toUpdate) {

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
