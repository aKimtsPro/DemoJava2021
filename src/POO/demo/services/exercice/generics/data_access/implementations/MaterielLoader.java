package POO.demo.services.exercice.generics.data_access.implementations;

import POO.demo.services.exercice.generics.data_access.AbstractModelLoader;
import POO.demo.services.exercice.generics.data_access.ModelFormatter;
import POO.demo.services.exercice.generics.model.Materiel;

public class MaterielLoader extends AbstractModelLoader<Materiel> {
    public MaterielLoader() {
        super(".\\data\\materiel.file", new MaterielPipeFormatter());
    }
}
