package POO.demo.services.models;

public class CheckPersonService implements CheckPerson {
    @Override
    public boolean checkCriteria(Personne p) {
        return p.getFirstName().contains("C");
    }
}
