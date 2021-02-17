package POO.demo.services.exercice.todo.presentation;

import POO.demo.services.exercice.todo.business.TodoService;
import POO.demo.services.exercice.todo.business.TodoServiceImpl;
import POO.demo.services.exercice.todo.business.TodoServiceMock;
import POO.demo.services.exercice.todo.exceptions.LoadingException;
import POO.demo.services.exercice.todo.exceptions.SaveException;
import POO.demo.services.exercice.todo.models.Todo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    // region SINGLETON
    private static Menu instance;
    public static Menu getInstance(){
        return instance == null ? instance = new Menu() : instance;
    }
    private Menu() {
    }
    // endregion

    private final Scanner scanner = new Scanner(System.in);
    private final TodoService service = TodoServiceImpl.getInstance();

    public void start(){
        load(); // Charger les données

        int choice = 0;
        while(choice != 4){ // Tant que je ne veux pas quitter
            showMenu(); // afficher menu
            choice = getChoice(); // recupère le choix
            mapChoice( choice ); // execution de l'action choisie
        }

        save(); // Sauvegarder les données
    }

    private void load(){
        System.out.println("- loading data -");
        try{
            service.load();
        }
        catch (LoadingException e){
            System.out.println("- loading failed, launch cancelled -");
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        System.out.println("- loading complete -");
    }

    private void save(){
        System.out.println("- saving data -");
        try {
            service.save();
        } catch (SaveException e) {
            System.out.println("- save failed -");
        }
        System.out.println("- save complete -");
    }

    public void showMenu(){
        System.out.println();
        System.out.println("* -- * MENU PRINCIPAL * -- *");
        System.out.println();
        System.out.println(" - 1 - Ajouter une tâche.");
        System.out.println(" - 2 - Supprimer une tâche.");
        System.out.println(" - 3 - Afficher les tâches.");
        System.out.println(" - 4 - Quitter.");
        System.out.println();
    }

    public int getChoice(){ // Récupérer un choix valide
        int choice = 0;
        while (choice > 4 || choice <= 0){ // tant que choix !in [1;4]
            try{
                System.out.print("---> Veuillez entrer votre choix : ");
                choice = scanner.nextInt();
                scanner.nextLine();

                if(choice > 4 || choice <= 0)
                    System.out.println("- choix invalide, réessayez -");
            }
            catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("- je passe ici; choix invalide, réessayez -");
            }

        }
        return choice;
    }


    public void mapChoice(int choice){ // fait correspondre un choix avec une action
        switch (choice) {
            case 1 -> add();
            case 2 -> delete();
            case 3 -> showTodo();
            case 4 -> System.out.println("\n- Merci d'avoir utiliser notre application! A plus dans le bus! -\n");
        }
    }

    public void delete(){
        System.out.print("---> id de la tâche à supprimer: ");
        try{
            int toDelete = scanner.nextInt();
            service.deleteTodo(toDelete);
            System.out.println("- La tâche d'id("+toDelete+") a été supprimée-");
        }
        catch (IllegalArgumentException e){
            System.out.println("- Tâche inexistante -");
        }
        catch (Exception e){
            System.out.println("- Choix invalide -");
            scanner.nextLine();
        }
    }

    public void add(){
        String nom = "";
        int difficulty = 0;

        System.out.println("Veuillez entrer les informations pour former la tâche:");
        System.out.print("- nom --> ");
        nom = scanner.nextLine();

        Todo.Difficulty[] difficulties = Todo.Difficulty.values();

        try {
            System.out.println("- Difficulté");
            for (int i = 0; i < difficulties.length; i++) {
                System.out.println("\t- "+ (i+1) +" - " + difficulties[i]);
            }
            System.out.print("- votre choix -->");
            difficulty = scanner.nextInt();
            if(difficulty > difficulties.length || difficulty <= 0)
                throw new Exception();

            service.addTodo(
                    new Todo(
                            0,
                            nom,
                            Todo.Difficulty.values()[difficulty-1]
                    )
            );
        }
        catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("- Valeur de difficulté invalide, ajout annulé -");
        }
        catch (Exception e){
            System.out.println("- Valeur de difficulté invalide, ajout annulé -");
        }

    }

    public void showTodo(){

        System.out.println("Souhaitez-vous trier par difficulté?");
        System.out.println("- 1 - oui");
        System.out.println("- 2 - non");
        int choix = 0;
        while (choix >2 || choix <= 0){
            try{
                choix = scanner.nextInt();
            }
            catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("- choix invalide, veuillez réessayer -");
            }
        }
        if (choix == 1)
            service.getSortedTodoList().forEach(System.out::println);
        else
            service.getTodoList().forEach(System.out::println);
    }

}
