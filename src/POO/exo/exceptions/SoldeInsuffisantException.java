package POO.exo.exceptions;

public class SoldeInsuffisantException extends Exception {
    public SoldeInsuffisantException() {
        super("Solde insuffisant - Opération impossible");
    }
}
