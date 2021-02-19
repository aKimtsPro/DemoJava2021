package POO.demo.services.exercice.generics.presentation;

import POO.demo.services.exercice.generics.metier.implementations.InstrumentServiceImpl;
import POO.demo.services.exercice.generics.metier.mocks.InstrumentServiceMock;
import POO.demo.services.exercice.generics.model.Instrument;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class InstrumentMenu extends CrudMenu<Instrument> {

    public InstrumentMenu() {
        super(new InstrumentServiceMock());
    }

    @Override
    public void insert() {
        System.out.println("Veuillez entrer les informations concernant l'instrument à ajouter : ");
        String marque = "";
        String modele = "";
        Instrument.Type type = null;
        Double price = 0D;
        try{
            System.out.print("---> marque :");
            marque = scanner.nextLine();
            System.out.println("---> modele : ");
            modele = scanner.nextLine();
            System.out.println("---> type (vent, percussion, corde) :");
            type = Instrument.Type.valueOf(scanner.nextLine().toUpperCase());
            System.out.println("---> prix (,) : ");
            price = scanner.nextDouble();

            service.add(
                    new Instrument(
                            0,
                            marque,
                            modele,
                            price,
                            type
                    )
            );

        }catch (InputMismatchException e){  
            scanner.nextLine();
            System.out.println("- prix invalide -");
        }catch (IllegalArgumentException e){
            System.out.println("- type invalide -");
        }
    }

    @Override
    public void update() {

        Instrument toUpdate;

        int id = 0;
        String marque = "";
        String modele = "";
        Instrument.Type type = null;
        double price = 0D;

        try {
            System.out.print("---> Quel instrument voulez-vous modifier (id): ");
            id = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e){
            System.out.println("- Valeur invalide -");
            return;
        }

        try{
            System.out.print("---> marque :");
            marque = scanner.nextLine();
            System.out.println("---> modele : ");
            modele = scanner.nextLine();
            System.out.println("---> type (vent, percussion, corde) :");
            type = Instrument.Type.valueOf(scanner.nextLine().toUpperCase());
            System.out.println("---> prix (,) : ");
            price = scanner.nextDouble();

            service.update(
                    new Instrument(
                            id,
                            marque,
                            modele,
                            price,
                            type
                    )
            );

        }catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("- prix invalide -");
        }catch (IllegalArgumentException e){
            System.out.println("- type invalide -");
        }
    }

    @Override
    public void showMenu() {
        System.out.println();
        System.out.println("*-* Menu instrument *-*");
        super.showMenu();
    }
}
