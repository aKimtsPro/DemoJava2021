package POO.demo.classes;

public class Chien {

    String nom;
    Proprietaire proprietaire;
    int age;
    boolean vaccine = true;

    public Chien(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }
}
