package POO.demo.services.exercice.generics.data_access.implementations;

import POO.demo.services.exercice.generics.data_access.AbstractModelLoader;
import POO.demo.services.exercice.generics.data_access.ModelFormatter;
import POO.demo.services.exercice.generics.data_access.ModelLoader;
import POO.demo.services.exercice.generics.model.Instrument;
import POO.demo.services.exercice.todo.exceptions.LoadingException;
import POO.demo.services.exercice.todo.exceptions.SaveException;

import java.util.List;

public class InstrumentLoader extends AbstractModelLoader<Instrument> {

    public InstrumentLoader() {
        super(".\\data\\instrument.file", new InstrumentPipeFormatter());
    }
}
