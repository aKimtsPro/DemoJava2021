package POO.demo.services.exercice.todo;

import POO.demo.services.exercice.todo.business.ListService;
import POO.demo.services.exercice.todo.dataAccess.TodoLoader;
import POO.demo.services.exercice.todo.presentation.Menu;

public class Application {

    public static void main(String[] args) {
        Menu.getInstance().start();
    }
}
