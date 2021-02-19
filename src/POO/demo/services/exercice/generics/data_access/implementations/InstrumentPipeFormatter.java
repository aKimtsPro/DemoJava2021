package POO.demo.services.exercice.generics.data_access.implementations;

import POO.demo.services.exercice.generics.data_access.AbstractPipeFormatter;
import POO.demo.services.exercice.generics.model.Instrument;
import POO.demo.services.exercice.todo.exceptions.FormatException;
import POO.demo.services.exercice.todo.models.Todo;

public class InstrumentPipeFormatter extends AbstractPipeFormatter<Instrument> {
    @Override
    public Instrument toModel(String line) throws FormatException {
        String[] data = null;
        data = line.split(regexDelimiter);
        try{
            return new Instrument(Integer.parseInt(data[0]),
                    data[1],
                    data[2],
                    Double.parseDouble(data[3]),
                    Instrument.Type.valueOf(data[4]));
        }
        catch (Exception e){
            throw new FormatException();
        }
    }

    @Override
    public String toLine(Instrument model) {
        return model.getId()+delimiter+model.getMarque()+delimiter+model.getModele()+delimiter+model.getPrix()+delimiter+model.getType();
    }
}
