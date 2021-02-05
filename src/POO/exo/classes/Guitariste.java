package POO.exo.classes;

public class Guitariste {

    private String nom;
    public String prenom;
    public int anneeExp; // = 0 par défaut
    public Guitare instrument = new Guitare("classique", 2021);

    public Guitariste(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
}
