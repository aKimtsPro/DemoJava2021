package POO.demo.services.exercice.generics.presentation;

import POO.demo.services.exercice.generics.metier.LoadingService;
import POO.demo.services.exercice.generics.metier.implementations.InstrumentServiceImpl;
import POO.demo.services.exercice.generics.metier.implementations.MaterielServiceImpl;
import POO.demo.services.exercice.generics.metier.mocks.InstrumentServiceMock;
import POO.demo.services.exercice.generics.metier.mocks.MaterielServiceMock;
import POO.demo.services.exercice.generics.model.Instrument;
import POO.demo.services.exercice.generics.model.Materiel;
import POO.demo.services.exercice.todo.exceptions.LoadingException;
import POO.demo.services.exercice.todo.exceptions.SaveException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu implements Menu {

    private final InstrumentMenu iMenu = new InstrumentMenu();
    private final MaterielMenu mMenu = new MaterielMenu();
    private final LoadingService instrumentLoadingService = new InstrumentServiceMock();
    private final LoadingService materielLoadingService = new MaterielServiceMock();
    private final Scanner scanner = new Scanner(System.in);

    public MainMenu() {}

    @Override
    public void start() {
        load();

        int choix = 0;
        while(choix != 3){
            showMenu();
            choix = getChoice();
            mapChoice(choix);
        }

        save();
    }


    private void load(){
        System.out.println("- loading data -");
        try{
            instrumentLoadingService.load();
            materielLoadingService.load();
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
            instrumentLoadingService.save();
            materielLoadingService.save();
        } catch (SaveException e) {
            System.out.println("- save failed -");
        }
        System.out.println("- save complete -");
    }

    private void showMenu(){
        System.out.println();
        System.out.println("*--* Menu Principal *--*");
        System.out.println();
        System.out.println("- 1 - instrument");
        System.out.println("- 2 - materiel");
        System.out.println("- 3 - quitter");
    }

    private int getChoice(){ // Récupérer un choix valide
        int choice = 0;
        int min = 1, max = 3;

        while (choice > max || choice < min){ // tant que choix !in [1;4]
            try{
                System.out.print("---> Veuillez entrer votre choix : ");
                choice = scanner.nextInt();
                scanner.nextLine();

                if(choice > max || choice < min)
                    System.out.println("- choix invalide, réessayez -");
            }
            catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("- je passe ici; choix invalide, réessayez -");
            }

        }
        return choice;
    }

    private void mapChoice(int choice){
        switch (choice){
            case 1 -> iMenu.start();
            case 2 -> mMenu.start();
            case 3 -> System.out.println("merci d'avoir utilisé cette application");
        }
    }



}
