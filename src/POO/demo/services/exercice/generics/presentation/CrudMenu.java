package POO.demo.services.exercice.generics.presentation;

import POO.demo.services.exercice.generics.metier.CrudService;
import POO.demo.services.exercice.todo.models.Model;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class CrudMenu<T extends Model> implements Menu {

    protected final Scanner scanner = new Scanner(System.in);
    protected final CrudService<T> service;

    public CrudMenu(CrudService<T> service) {
        this.service = service;
    }

    public void start(){
        int choice = 0;
        while(choice != 6){ // Tant que je ne veux pas quitter
            showMenu(); // afficher menu
            choice = getChoice(); // recupère le choix
            mapChoice( choice ); // execution de l'action choisie
        }
    }

    public void showMenu(){
        System.out.println();
        System.out.println(" - 1 - Insert");
        System.out.println(" - 2 - Get One");
        System.out.println(" - 3 - Get All");
        System.out.println(" - 4 - Update");
        System.out.println(" - 5 - Delete");
        System.out.println(" - 6 - Retour au menu principal.");
        System.out.println();
    }

    public int getChoice(){ // Récupérer un choix valide
        int choice = 0;
        while (choice > 6 || choice <= 0){ // tant que choix !in [1;6]
            try{
                System.out.print("---> Veuillez entrer votre choix : ");
                choice = scanner.nextInt();
                scanner.nextLine();

                if(choice > 6 || choice <= 0)
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
            case 1 -> insert();
            case 2 -> showOne();
            case 3 -> showAll();
            case 4 -> update();
            case 5 -> delete();
            case 6 -> System.out.println("\n- retour au menu principal -\n");
        }
    }

    public abstract void insert();
    public abstract void update();

    public void showOne(){
        try{
            System.out.println("---> Veuillez entrer l'id de l'élément à récuperer :");
            T toShow = service.getOne(scanner.nextInt());
            scanner.nextLine();
            System.out.println(toShow);
        }
        catch (NoSuchElementException e){
            System.out.println("- L'element souhaité n'existe pas -");
        }
        catch (Exception e){
            scanner.nextLine();
            System.out.println("- Choix invalide -");
        }
    }
    public void showAll(){
        List<T> toShow = service.getAll();
        if(toShow.isEmpty())
            System.out.println("- rien à afficher -");
        else {
            toShow.forEach(System.out::println);
        }
    }

    public void delete(){
        try{
            System.out.print("---> Veuillez entrer l'id de l'élément à supprimer : ");
            int toDelete = scanner.nextInt();
            scanner.nextLine();
            service.delete(toDelete);
            System.out.println("- L'element d'id "+ toDelete +" supprimé -");
        }
        catch (NoSuchElementException e){
            System.out.println("- Pas d'element correspondant -");
        }
        catch (Exception e){
            scanner.nextLine();
            System.out.println("- Choix invalide -");
        }
    }
}
