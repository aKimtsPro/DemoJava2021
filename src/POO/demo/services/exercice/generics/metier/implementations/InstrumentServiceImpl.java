package POO.demo.services.exercice.generics.metier.implementations;

import POO.demo.services.exercice.generics.data_access.implementations.InstrumentLoader;
import POO.demo.services.exercice.generics.metier.AbstractCrudService;
import POO.demo.services.exercice.generics.model.Instrument;

import java.util.NoSuchElementException;

public class InstrumentServiceImpl extends AbstractCrudService<Instrument> {

    // region SINGLETON

    private static InstrumentServiceImpl instance;
    public static InstrumentServiceImpl getInstance(){
        return instance == null ? instance = new InstrumentServiceImpl() : instance;
    }
    private InstrumentServiceImpl() {
        super(new InstrumentLoader());
    }

    // endregion

    @Override
    public Instrument getOne(int id) throws NoSuchElementException {
        return getList().stream()
                .filter(instrument -> instrument.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void update(Instrument toUpdate) throws NoSuchElementException {
        Instrument instru = getOne(toUpdate.getId());

        instru.setMarque(toUpdate.getMarque());
        instru.setModele(toUpdate.getModele());
        instru.setPrix(toUpdate.getPrix());
        instru.setType(toUpdate.getType());
    }

    @Override
    public void add(Instrument toAdd) {
        toAdd.setId(++lastId);
        getList().add(toAdd);
    }

    @Override
    protected void calculateLastId() {
        lastId = getList().stream()
                .mapToInt(Instrument::getId)
                .max()
                .orElse(0);
    }
}
