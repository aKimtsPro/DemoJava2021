package POO.demo.services.exercice.generics.data_access.implementations;

import POO.demo.services.exercice.generics.data_access.AbstractPipeFormatter;
import POO.demo.services.exercice.generics.model.Instrument;
import POO.demo.services.exercice.generics.model.Materiel;
import POO.demo.services.exercice.todo.exceptions.FormatException;

public class MaterielPipeFormatter extends AbstractPipeFormatter<Materiel> {
    @Override
    public Materiel toModel(String line) throws FormatException {
        String[] data = null;
        data = line.split(regexDelimiter);
        try{
            return new Materiel(Integer.parseInt(data[0]),
                    data[1],
                    data[2],
                    Double.parseDouble(data[3]));
        }
        catch (Exception e){
            throw new FormatException();
        }
    }

    @Override
    public String toLine(Materiel model) {
        return model.getId()+delimiter+model.getMarque()+delimiter+model.getModele()+delimiter+model.getPrix();
    }
}
