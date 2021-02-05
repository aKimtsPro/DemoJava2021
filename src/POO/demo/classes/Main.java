package POO.demo.classes;

import java.util.function.BooleanSupplier;

public class Main {

    public static void main(String[] args) {

        System.out.println("salut");

        Proprietaire prop = new Proprietaire("luc", "luc", "000/00.00.00", 19);
        Chien fido = new Chien("fido", prop.age, prop);
        Chien rex = new Chien("rex", 5, prop);

        prop.prenom = "lucas";
        prop.age = 8;

        System.out.println("Proprietaire 1:" +
                "\n - prenom : " + prop.prenom + // lucas
                "\n - nom : " + prop.nom +       // luc
                "\n - numero : " + prop.numero + // 000/00.00.00
                "\n - age : " + prop.age );      // 8

        System.out.println("Proprietaire du chien:" +
                "\n - prenom : " + fido.proprietaire.prenom + // lucas
                "\n - nom : " + fido.proprietaire.nom +       // luc
                "\n - numero : " + fido.proprietaire.numero + // 000/00.00.00
                "\n - age chien : " + fido.age );             // 19

    }
}
