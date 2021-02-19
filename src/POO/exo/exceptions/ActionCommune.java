package POO.exo.exceptions;

public interface ActionCommune {
    void depot(double depot);
    void retrait(double retrait) throws SoldeInsuffisantException;
    void consulter();
}
