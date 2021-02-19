package POO.demo.services.exercice.generics.metier.implementations;

import POO.demo.services.exercice.generics.data_access.ModelLoader;
import POO.demo.services.exercice.generics.data_access.implementations.MaterielLoader;
import POO.demo.services.exercice.generics.metier.AbstractCrudService;
import POO.demo.services.exercice.generics.model.Materiel;

import java.util.NoSuchElementException;

public class MaterielServiceImpl extends AbstractCrudService<Materiel> {

    // region SINGLETON
    private static MaterielServiceImpl instance;
    public static MaterielServiceImpl getInstance(){
        return instance == null ? instance = new MaterielServiceImpl() : instance;
    }
    private MaterielServiceImpl() {
        super(new MaterielLoader());
    }
    // endregion

    @Override
    protected void calculateLastId() {
        lastId = getList().stream()
                .mapToInt(Materiel::getId)
                .max()
                .orElse(0);
    }

    @Override
    public void add(Materiel toAdd) {
        toAdd.setId(++lastId);
        getList().add(toAdd);
    }

    @Override
    public Materiel getOne(int id) throws NoSuchElementException {
        return getList().stream()
                .filter(materiel -> materiel.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void update(Materiel toUpdate) throws NoSuchElementException {
        Materiel m = getOne(toUpdate.getId());
        m.setMarque(toUpdate.getMarque());
        m.setModele(toUpdate.getModele());
        m.setPrix(toUpdate.getPrix());
    }
}
