package POO.demo.services.exercice.generics.presentation;

import POO.demo.services.exercice.generics.metier.mocks.MaterielServiceMock;
import POO.demo.services.exercice.generics.model.Materiel;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class MaterielMenu extends CrudMenu<Materiel> {

    public MaterielMenu() {
        super(new MaterielServiceMock());
    }

    @Override
    public void insert() {
        System.out.println("Veuillez entrer les informations concernant le materiel à ajouter : ");

        String marque;
        String modele;
        double price;

        try{
            System.out.print("---> marque :");
            marque = scanner.nextLine();
            System.out.println("---> modele : ");
            modele = scanner.nextLine();
            System.out.println("---> prix (.) : ");
            price = scanner.nextDouble();

            service.add(
                    new Materiel(
                            0,
                            marque,
                            modele,
                            price
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

        int id = 0;

        String marque;
        String modele;
        double price;

        Materiel toUpdate;

        try{
            System.out.print("---> Quel instrument voulez-vous modifier (id): ");
            id = scanner.nextInt();
            scanner.nextLine();
            toUpdate = service.getOne(id);

        }catch (InputMismatchException e){
            System.out.println("- Valeur invalide -");
            return;
        }catch (NoSuchElementException e){
            System.out.println("- L'element en question n'existe pas -");
            return;
        }

        try{
            System.out.print("---> marque ("+toUpdate.getMarque()+"):");
            marque = scanner.nextLine();
            System.out.println("---> modele ("+toUpdate.getModele()+"): ");
            modele = scanner.nextLine();
            System.out.println("---> prix (,) ("+toUpdate.getPrix()+"): ");
            price = scanner.nextDouble();

            service.update(
                    new Materiel(
                            id,
                            marque,
                            modele,
                            price
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
        System.out.println("*-* Menu materiel *-*");
        super.showMenu();
    }
}
