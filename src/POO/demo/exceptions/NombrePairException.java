package POO.demo.exceptions;

public class NombrePairException extends Exception {
    public NombrePairException(String message) {
        super(message + " : Nombre pair détecté !!!");
    }
}
