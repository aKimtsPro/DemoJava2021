package POO.demo.classes;

public class Chien {

    String nom;
    Proprietaire proprietaire;
    int age;
    boolean vaccine = true;

    public Chien(String nom, int age, Proprietaire proprietaire) {
        this.nom = nom;
        this.age = age;
        this.proprietaire = proprietaire;
    }
}
