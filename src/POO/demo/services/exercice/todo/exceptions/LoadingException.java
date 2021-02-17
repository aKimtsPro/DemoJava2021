package POO.demo.services.exercice.todo.exceptions;

public class LoadingException extends Exception {

    public LoadingException(String message) {
        super("Loading failed : " + message);
    }
}
